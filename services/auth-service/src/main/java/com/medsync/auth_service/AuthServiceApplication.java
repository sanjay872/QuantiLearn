package com.medsync.auth_service;

import com.medsync.auth_service.utils.PreLoadData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServiceApplication implements CommandLineRunner {

	private final PreLoadData preLoadData;

	public AuthServiceApplication(PreLoadData preLoadData){
		this.preLoadData=preLoadData;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(args);
		preLoadData.loadRequiredData();
	}
}
