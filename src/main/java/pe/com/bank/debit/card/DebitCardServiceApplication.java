package pe.com.bank.debit.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DebitCardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebitCardServiceApplication.class, args);
	}

}
