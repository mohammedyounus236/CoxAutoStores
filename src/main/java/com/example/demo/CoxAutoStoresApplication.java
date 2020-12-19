package com.example.demo;

import com.example.demo.model.Store;
import com.example.demo.service.StoreService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CoxAutoStoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoxAutoStoresApplication.class, args);
		
	}

	@Bean
	CommandLineRunner runner(StoreService storeService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Store>> typeReference = new TypeReference<List<Store>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stores.json");
			try{
				List<Store> stores = mapper.readValue(inputStream, typeReference);
				stores.stream().forEach(store -> storeService.newStore(store));
				System.out.println("Stores saved!");
			} catch(IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
}
