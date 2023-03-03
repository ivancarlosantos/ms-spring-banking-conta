package core.ics.conta;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

@Slf4j
@SpringBootApplication
public class ContaAgenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContaAgenciaApplication.class, args);
		log.info("\n[Conta - Tomcat ATIVO] "+ HttpStatus.OK);
	}
}
