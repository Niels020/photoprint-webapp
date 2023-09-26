package nl.calco.photoapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    
    @Bean
    OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("PhotoShopAPI")
                .description("API for handling our PhotoShops WebShop")
                .version("1.0"));
    }
}
