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
	private static String ID_TRANSACTION = "f4d42c9b-156b-44fb-aeee-25dd7c530381";
	/*id transaction test
	 * dbb7a5bc-9d0f-4525-817b-35a56d80d451
	 * f4d42c9b-156b-44fb-aeee-25dd7c530381
	 * e2cd50df-557e-4909-afaa-d4a3b7515f8b
	 * */
	
	public static void main(String[] args) {
		SpringApplication.run(StandaloneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Utils utils = new Utils();
		
		//this.operationService.addTransaction(utils.newUser());
		this.operationService.showTransaction(ID_USER,ID_TRANSACTION);
		//this.operationService.listTransactions(ID_USER);
		//this.operationService.sumTransactions(ID_USER);
	}

}
