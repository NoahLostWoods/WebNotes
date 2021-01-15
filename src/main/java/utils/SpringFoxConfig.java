package utils;

public class SpringFoxConfig {
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelector.any())
                .paths(PathSelector.any())
                .build();
    }
}
