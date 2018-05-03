package com.akria.domain;

import com.akria.api.Callback;
import com.akria.api.IUserAPI;
import com.akria.net.ClientRequest;
import com.alibaba.fastjson.JSONObject;

public class UserAPI implements IUserAPI{

	@Override
	public void register(User user, Callback callback) {
		JSONObject json = (JSONObject) JSONObject.toJSON(user);
		ClientRequest.Request(json, "001", callback);
	}

	@Override
	public void login(String phonenumber, String password, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("phonenumber", phonenumber);
		json.put("password", password);
		ClientRequest.Request(json, "002", callback);
	}

	@Override
	public void resetPassword(String phonenumber, String password, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("phonenumber", phonenumber);
		json.put("password", password);
		ClientRequest.Request(json, "003", callback);
	}

	@Override
	public void queryUserInfo(String phonenumber, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("phonenumber", phonenumber);
		ClientRequest.Request(json, "004", callback);
	}

	@Override
	public void changeUserInfo(User user, Callback callback) {
		JSONObject json = (JSONObject) JSONObject.toJSON(user);
		ClientRequest.Request(json, "005", callback);
	}

	@Override
	public void findPhonenumber(String phonenumber, Callback callback) {		
		JSONObject json = new JSONObject();
		json.put("phonenumber", phonenumber);		
		ClientRequest.Request(json, "006", callback);
	}
}
