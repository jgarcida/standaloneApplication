package com.excercise.demo.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface OperationService {

	void writeJson();

	JSONObject addTransaction(JSONObject newObject);

	JSONObject showTransaction(String userId,String id_Transaction);

	void listTransactions(String userId);

	void sumTransactions(String userId);

}
