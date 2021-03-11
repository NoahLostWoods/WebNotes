package com.ap.webnotes.controller;

import com.ap.webnotes.assembler.GetUserAssembler;
import com.ap.webnotes.dto.UserDto;
import com.ap.webnotes.factory.PostUserFactory;
import com.ap.webnotes.model.Users;
import com.ap.webnotes.resource.UsersResource;
import com.ap.webnotes.service.implementations.UserServiceImpl;
import com.ap.webnotes.utils.UtilsClass;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends UtilsClass {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PostUserFactory postUserFactory;

    @GetMapping("/users")
    public ResponseEntity<List<UsersResource>> getUsers(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio getUsers -> mock {}", mock);
            ResponseEntity.ok(Collections.singletonList(new Users()));
        }

        logger.info("Inizio chiamata servizio getUsers");

        try {
            Supplier<List<Users>> userRetriver = () -> userService.getAllUsers();
            GetUserAssembler assembler = new GetUserAssembler();
            return ResponseEntity.ok(assembler.toResource(userRetriver.get()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(Collections.emptyList());
    }

    @PostMapping("/user")
    public ResponseEntity<String> postUser(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @RequestBody @Validated UserDto dto
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio postUser mock -> {}", mock);
            return ResponseEntity.ok("OK");
        }

        logger.info("Inizio chiamata servizio postUser");

        Users users = postUserFactory.dtoToModel(dto);
        if (users != null &&
                !users.getUser().isEmpty() &&
                !users.getPassword().isEmpty()) {
            try {
                /*
                Creare funzione di controllo di user già esistente.
                 */
                userService.saveUser(users);
                return ResponseEntity.ok("OK");
            } catch (Exception e) {
                return ResponseEntity.ok("KO");
            }
        }
        return null;
    }
}
