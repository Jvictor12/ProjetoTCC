package io.github.jvictor12.apiestagioifba;

import io.github.jvictor12.apiestagioifba.infraestrutura.exception.ObjectNotFoundException;
import io.github.jvictor12.apiestagioifba.infraestrutura.service.Facade;
import io.github.jvictor12.apiestagioifba.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiestagioifbaApplication implements CommandLineRunner {

	@Autowired
	private Facade facade;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(ApiestagioifbaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		checkDefaultUser();
	}

	private void checkDefaultUser () {

		try {
			saveDefaultUser(facade.userFindByName("admin"));
		} catch (ObjectNotFoundException ex) {
			saveDefaultUser(new User());
		}
	}

	private void saveDefaultUser (User user) {

		user.setName("admin");
		user.setPassword(encoder.encode("admin"));

		facade.userSave(user);
	}
	
}
