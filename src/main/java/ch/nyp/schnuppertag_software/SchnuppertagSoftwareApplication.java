package ch.nyp.schnuppertag_software;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(/*scanBasePackages = {"ch.nyp.schnuppertag_software"}*/)
@EnableJpaRepositories(/*"ch.nyp.schnuppertag_software"*/)
@EntityScan(/*"ch.nyp.schnuppertag_software"*/)
public class SchnuppertagSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchnuppertagSoftwareApplication.class, args);
	}

}
