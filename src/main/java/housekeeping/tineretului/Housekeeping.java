package housekeeping.tineretului;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Housekeeping /*extends SpringBootServletInitializer*/ {

	public static void main(String[] args) {
		SpringApplication.run(Housekeeping.class, args);
	}

}
