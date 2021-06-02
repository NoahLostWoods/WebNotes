package com.ap.webnotes.controller.users;

import com.ap.webnotes.assembler.users.GetUserAssembler;
import com.ap.webnotes.assembler.users.GetUsersAssembler;
import com.ap.webnotes.command.users.UserCommand;
import com.ap.webnotes.dto.users.UserDto;
import com.ap.webnotes.factory.users.PostUserFactory;
import com.ap.webnotes.model.users.Users;
import com.ap.webnotes.resource.users.UsersResource;
import com.ap.webnotes.utils.UtilsClass;
import com.ap.webnotes.utils.mocks.UserMockModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends UtilsClass {

    /*
    TODO
     1) Aggiungere la modifica della username [Check -> se la user è stata già presa o meno].
     */

    @Autowired
    private UserCommand userCommand;

    @Autowired
    private PostUserFactory postUserFactory;

    @GetMapping("/users")
    public ResponseEntity<List<UsersResource>> getUsers(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio getUsers -> mock {}", mock);
            ResponseEntity.ok(UserMockModels.getUsers());
        }

        logger.info("Inizio chiamata servizio getUsers");


        Supplier<List<Users>> userRetriver = () -> userCommand.getUsers();
        GetUsersAssembler assembler = new GetUsersAssembler();

        logger.info("Fine servizio getUsers");
        return ResponseEntity.ok(assembler.toResource(userRetriver.get()));

    }

    @PostMapping("/user")
    public ResponseEntity<String> postUser(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @RequestBody @Validated UserDto dto
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine servizio postUser mock -> {}", mock);
            return ResponseEntity.ok("MOCKED");
        }

        logger.info("Inizio servizio postUser");

        Users users = postUserFactory.dtoToModel(dto);

        List<Users> getUser = userCommand.getUsers();

        if (getUser.isEmpty() || !checkUserExsistence(getUser, dto)) {
            userCommand.postUser(users);
            logger.info("Fine servizio postUser");
            return ResponseEntity.ok("Utente registrato con successo!");
        } else {
            logger.info("Fine servizio postUser");
            return ResponseEntity.ok("Utente già esistente");
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UsersResource> getUser(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @PathVariable("userId") Integer userId
    ) {

        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio getUser mock -> {}", mock);
            return ResponseEntity.ok(UserMockModels.getUser());
        }

        logger.info("Inizio servizio getUser userid -> {}", userId);

        Users user = userCommand.getUser(userId);

        GetUserAssembler assembler = new GetUserAssembler();

        logger.info("Fine servizio getUser");
        return ResponseEntity.ok(assembler.toResource(user));
    }

    @GetMapping("/user")
    public ResponseEntity<UsersResource> getUserFromName(
            @RequestParam(required = false, defaultValue = "false") Boolean mock,
            @RequestParam("nominativo") String nominativo
    ){
        if(Boolean.TRUE.equals(mock)){
            logger.info("Fine chiamata servizio getUserByName mock -> {}", mock);
            return ResponseEntity.ok(UserMockModels.getUser());
        }

        logger.info("Inizio servizio getUserByName nominativo -> {}", nominativo);
        Users user = userCommand.getUserByName(nominativo);
        GetUserAssembler assembler = new GetUserAssembler();
        logger.info("Fine servizio getUserByName");
        return ResponseEntity.ok(assembler.toResource(user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(
            @RequestParam(required = false, defaultValue = "false") Boolean mock,
            @PathVariable("id") Integer id
    ){
        if(Boolean.TRUE.equals(mock)){
            logger.info("Fine chiamata servizio getUserByName mock -> {}", mock);
            return ResponseEntity.ok("OK MOCKED");
        }

        logger.info("Inizio servizio deleteById id -> {}", id);

        String message = userCommand.deleteById(id);

        logger.info("Fine servizio deleteById id -> {}", id);
        return ResponseEntity.ok(message);

    }

}
