package br.com.erudio.erudioconfigserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class ErudioConfigServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErudioConfigServeApplication.class, args);
	}

}
