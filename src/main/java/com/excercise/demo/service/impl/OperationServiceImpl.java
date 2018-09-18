package com.excercise.demo.service.impl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.excercise.demo.service.OperationService;
import com.excercise.demo.service.utils.Utils;

@Service
public class OperationServiceImpl implements OperationService {

	private static Logger LOGGER = LoggerFactory.getLogger(OperationServiceImpl.class);
	private static String FILE_PATH = "fileStore/user.json";

	@Override
	public void writeJson() {
		// TODO Auto-generated method stub
		Utils utils = new Utils();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("amount", "50.50");
		jsonObject.put("description", "This is a test");

		jsonObject.put("date", utils.formatoFecha(new Date()));
		jsonObject.put("userId", "1");
		jsonObject.put("transaction_id", utils.ramdomId());

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObject);

		JSONObject saveJson = new JSONObject();
		saveJson.put("userTransaction", jsonArray);

		try {
			FileWriter fileWriter = new FileWriter(FILE_PATH);
			fileWriter.write(saveJson.toJSONString());
			fileWriter.flush();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("JSON FORMAT " + saveJson);

	}

	@Override
	public JSONObject addTransaction(JSONObject newObject) {
		JSONParser parser = new JSONParser();
		FileWriter fileWriter = null;

		try {
			JSONObject jsonObject = this.jsonobject();
			if (jsonObject == null) {
				LOGGER.info("VAMOS A CREAR EL ARCHIVO");
				JSONArray jsonArray = new JSONArray();
				jsonArray.add(newObject);
				JSONObject saveJson = new JSONObject();
				saveJson.put("userTransaction", jsonArray);
				fileWriter = new FileWriter(FILE_PATH);
				fileWriter.write(saveJson.toJSONString());
			} else {
				JSONArray userList = (JSONArray) jsonObject.get("userTransaction");
				userList.add(newObject);
				fileWriter = new FileWriter(FILE_PATH);
				fileWriter.write(jsonObject.toJSONString());
			}

			fileWriter.flush();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException io) {
					io.printStackTrace();
					LOGGER.error(io.getMessage());
				}
			}
		}
		LOGGER.info("New transaction: " + newObject);
		return newObject;
	}

	@Override
	public JSONObject showTransaction(String userId, String id_Transaction) {
		JSONParser parser = new JSONParser();
		boolean flagExist = Boolean.FALSE;
		JSONObject userObject = null;
		try {
			JSONObject jsonObject = this.jsonobject();
			JSONArray userList = (JSONArray) jsonObject.get("userTransaction");
			Iterator<JSONObject> iterator = userList.iterator();
			while (iterator.hasNext()) {
				userObject = (JSONObject) iterator.next();
				if (userObject.get("userId").equals(userId)
						&& userObject.get("transaction_id").equals(id_Transaction)) {
					flagExist = Boolean.TRUE;
					break;

				} else {
					flagExist = Boolean.FALSE;

				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		if (!flagExist) {
			LOGGER.info("********** Transaction not found **********");
		} else {
			LOGGER.info("Transaction: " + userObject);
		}

		return userObject;
	}

	@Override
	public void listTransactions(String userId) {
		JSONParser parser = new JSONParser();
		boolean flagExist = Boolean.FALSE;
		try {
			JSONObject jsonObject = this.jsonobject();
			JSONArray userList = (JSONArray) jsonObject.get("userTransaction");
			Iterator<JSONObject> iterator = userList.iterator();
			while (iterator.hasNext()) {
				JSONObject userObject = (JSONObject) iterator.next();
				if (userObject.get("userId").equals(userId)) {
					flagExist = Boolean.TRUE;
					LOGGER.info("LIST TRANSACTIONS :  " + userObject);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		if (!flagExist) {
			LOGGER.info("Transaction list not found");
		}
	}

	@Override
	public void sumTransactions(String userId) {
		JSONParser parser = new JSONParser();
		Double sum = 0d;
		try {

			JSONObject jsonObject = this.jsonobject();
			JSONArray userList = (JSONArray) jsonObject.get("userTransaction");
			Iterator<JSONObject> iterator = userList.iterator();
			while (iterator.hasNext()) {
				JSONObject userObject = (JSONObject) iterator.next();
				if (userObject.get("userId").equals(userId)) {
					if (!userObject.get("amount").toString().equals("")) {
						Double d = Double.parseDouble(userObject.get("amount").toString());
						sum = sum + d;
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info(":::::::::: TOTAL ::::::::::   " + sum);
	}

	public JSONObject jsonobject() {
		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();
		FileReader fr = null;
		try {
			fr = new FileReader(FILE_PATH);
			Object obj = parser.parse(fr);
			jsonObject = (JSONObject) obj;

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return jsonObject;
	}

}
