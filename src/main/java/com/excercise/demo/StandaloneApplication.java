package com.excercise.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.excercise.demo.service.OperationService;
import com.excercise.demo.service.utils.Utils;

@SpringBootApplication
public class StandaloneApplication implements CommandLineRunner {
	
	@Autowired
	private OperationService operationService;
	private static String ID_USER = "2";
	private static String ID_TRANSACTION = "dbb7a5bc-9d0f-4525-817b-35a56d80d451";
	
	public static void main(String[] args) {
		SpringApplication.run(StandaloneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Utils utils = new Utils();
		
		//this.operationService.writeJson();
		//this.operationService.addTransaction(utils.newUser());
		//this.operationService.showTransaction(ID_USER,ID_TRANSACTION);
		//this.operationService.listTransactions(ID_USER);
		this.operationService.sumTransactions(ID_USER);
	}

}
