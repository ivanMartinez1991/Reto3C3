package co.usa.ivanm.reto3.Reto3C3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "co.usa.ivanm.reto3.Reto3C3")
@SpringBootApplication
public class Reto3C3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3C3Application.class, args);
	}

}
