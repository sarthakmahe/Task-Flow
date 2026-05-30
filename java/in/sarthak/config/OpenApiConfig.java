package in.sarthak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI taskFlowOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("TaskFlow API")
						.description("REST API for the Todo Application")
						.version("1.0"));
	}
}
