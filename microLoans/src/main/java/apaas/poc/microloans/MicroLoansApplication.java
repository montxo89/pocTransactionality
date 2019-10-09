package apaas.poc.microloans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@ComponentScan(value = {"apaas.poc.*"})
@SpringBootApplication
@EnableJms
public class MicroLoansApplication {

	/**
	 * Main class of the MicroLoansApplication microservice.
	 * 
	 * @param args
	 *            the main args.
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroLoansApplication.class, args);
	}

}
