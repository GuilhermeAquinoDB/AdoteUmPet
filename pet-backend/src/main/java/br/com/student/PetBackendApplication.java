package br.com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.student.core.models.Pet;
import br.com.student.core.repositories.PetRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class PetBackendApplication implements CommandLineRunner {

	@Autowired
	private PetRepository petRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PetBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var pet = new Pet();
		pet.setNome("Oscar");
		pet.setHistoria("Cachorro lindo, amigável e companheiro, Lorem ipsum dolor sit amet consectetur adipisicing elit.");
		pet.setFoto("https://media.istockphoto.com/photos/its-a-paddle-board-time-picture-id1327654972");
		petRepository.save(pet);
		
		var pet2 = new Pet();
		pet2.setNome("Lilia");
		pet2.setHistoria("Cachorro lindo, amigável e companheiro, Lorem ipsum dolor sit amet consectetur adipisicing elit.");
		pet2.setFoto("https://images.unsplash.com/photo-1561037404-61cd46aa615b");
		petRepository.save(pet2);
		
		var pet3 = new Pet();
		pet3.setNome("Thor");
		pet3.setHistoria("Cachorro lindo, amigável e companheiro, Lorem ipsum dolor sit amet consectetur adipisicing elit.");
		pet3.setFoto("https://images.unsplash.com/photo-1517849845537-4d257902454a");
		petRepository.save(pet3);
	}
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Projeto Backend de Adoção de Pets")
				.version("1.0")
				.termsOfService("http://swagger.io/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
