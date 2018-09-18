package com.excercise.demo.service.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.json.simple.JSONObject;

public class Utils {
	
	public  String formatoFecha(Date date) {
		String formatDate;
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return formatDate =simpleDateFormat.format(date);
	}
	
	public String ramdomId() {
		UUID idTransaction = UUID.randomUUID();
		return idTransaction.toString();
	}
	
	
	public JSONObject newUser() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("amount", "45.00");
		jsonObject.put("description", "this is another test about nothing");
		jsonObject.put("date", this.formatoFecha(new Date()));
		jsonObject.put("userId", "2");
		jsonObject.put("transaction_id",this.ramdomId());
		return jsonObject;
	}

}
