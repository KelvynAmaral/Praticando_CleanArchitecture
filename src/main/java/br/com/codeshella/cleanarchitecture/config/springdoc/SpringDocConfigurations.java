package br.com.codeshella.cleanarchitecture.config.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Clean Architecture API")
                        .version("1.0")
                        .description("Documentação da API do projeto Clean Architecture"));

                //forma de acesso: http://localhost:8081/swagger-ui/index.html
    }
}
