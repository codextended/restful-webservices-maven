package dev.codextended.webservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API Documentation",
				description = "Documentation for a simple REST API",
				version = "v1.0",
				contact = @Contact(
						name = "Smath Cadet",
						email = "thesmartone0@gmail.com",
						url = "https://www.codextended.dev"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.codextended.dev/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "User management documentation",
				url = "https://www.codextended.dev/user_management.html"
		)
)
public class RestfulWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebservicesApplication.class, args);
	}

}
