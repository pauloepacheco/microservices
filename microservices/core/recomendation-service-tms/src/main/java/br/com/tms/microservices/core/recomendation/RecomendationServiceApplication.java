package br.com.tms.microservices.core.recomendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * 
 * @author Paulo Pacheco
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
public class RecomendationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecomendationServiceApplication.class, args);
	}
}
