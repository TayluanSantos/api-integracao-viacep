package com.example.api_cep_integracao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiCepIntegracaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiCepIntegracaoApplication.class, args);
	}
}
