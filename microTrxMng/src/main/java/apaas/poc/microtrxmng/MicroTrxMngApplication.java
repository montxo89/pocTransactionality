package apaas.poc.microtrxmng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = { "apaas.poc.*" })
@SpringBootApplication
public class MicroTrxMngApplication {

	/**
	 * Main class of the MicroTrxMngApplication microservice.
	 * 
	 * @param args
	 *            the main args.
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroTrxMngApplication.class, args);
	}

}