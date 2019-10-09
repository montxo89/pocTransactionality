package apaas.poc.microaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@ComponentScan(value = { "apaas.poc.*" })
@SpringBootApplication
@EnableJms
public class MicroAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroAccountsApplication.class, args);
	}

}
