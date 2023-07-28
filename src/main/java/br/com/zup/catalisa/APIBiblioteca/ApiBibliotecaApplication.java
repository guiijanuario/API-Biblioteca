package br.com.zup.catalisa.APIBiblioteca;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Biblioteca API", version = "1", description = "API desenvolvida para gerenciar os livros de uma biblioteca"))
public class ApiBibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBibliotecaApplication.class, args);
	}

}
