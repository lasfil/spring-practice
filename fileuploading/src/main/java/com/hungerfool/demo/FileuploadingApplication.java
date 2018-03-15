package com.hungerfool.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.hungerfool.demo.storage.StorageProperties;
import com.hungerfool.demo.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FileuploadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileuploadingApplication.class, args);
	}

	@Bean
	CommandLineRunner init1(StorageService storageService) {
		CommandLineRunner runner = (args1) -> {
			storageService.deleteAll();
			storageService.init();
		};
		return runner;
	}
}
