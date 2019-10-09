package apaas.poc.microusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = { "apaas.poc.*" })
@SpringBootApplication
public class MicroUsersApplication {

	/**
	 * Main class of the MicroUsersApplication microservice.
	 * 
	 * @param args
	 *            the main args.
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroUsersApplication.class, args);
	}

}