package abastian.dwi.saputra.testtechnicaldevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TestTechnicalDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTechnicalDevelopmentApplication.class, args);
	}

}
