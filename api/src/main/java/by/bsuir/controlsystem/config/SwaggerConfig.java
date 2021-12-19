package by.bsuir.controlsystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Bus booking system api")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("alexeyyakubovsky@coherentsolutions.com")
                                                .url("https://t.me/aleksey2411")
                                                .name("Alexey Yakubovsky")
                                )
                );
    }
}
