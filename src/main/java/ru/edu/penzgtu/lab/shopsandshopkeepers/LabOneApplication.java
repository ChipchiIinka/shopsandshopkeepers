package ru.edu.penzgtu.lab.shopsandshopkeepers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "PenzGTU Java Lab API",
				description = "API for Labs", version = "1.0.0",
				contact = @Contact(
						name = "Gizbreht Mark",
						email = "m.gi2016@yandex.ru"
						)
		)
)
@SpringBootApplication
public class LabOneApplication {
	public static void main(String[] args) {
		SpringApplication.run(LabOneApplication.class, args);
	}
}
