package br.com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.student.core.models.Pet;
import br.com.student.core.repositories.PetRepository;

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
		pet.setHistoria("Cachorro lindo, amigável e companheiro.");
		pet.setFoto("http://www.example.com.br/photo.png");
		petRepository.save(pet);
	}

}
