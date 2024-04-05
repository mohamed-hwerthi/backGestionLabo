package com.example.GestionLabo;

import com.example.GestionLabo.testJava.Cutomer;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GestionLaboApplication {
	@Value("${server.port}")
	private int port;
	private static final Logger log = LoggerFactory.getLogger(GestionLaboApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GestionLaboApplication.class, args);
	}

	@PostConstruct
	public void postContruct() {
		log.info("my spring server is runnning on port :{}", port);
	}

}
