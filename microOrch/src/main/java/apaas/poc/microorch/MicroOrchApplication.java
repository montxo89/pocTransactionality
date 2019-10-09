package apaas.poc.microorch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = { "apaas.poc.*" })
@SpringBootApplication
public class MicroOrchApplication {

	/**
	 * Main class of the MicroOrchApplication microservice.
	 * 
	 * @param args
	 *            the main args.
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroOrchApplication.class, args);
	}

}
