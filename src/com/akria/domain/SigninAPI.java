package com.akria.domain;

import com.akria.api.Callback;
import com.akria.api.ISigninAPI;
import com.akria.net.ClientRequest;
import com.alibaba.fastjson.JSONObject;

public class SigninAPI implements ISigninAPI {

	@Override
	public void createSignin(Signin signin, Callback callback) {
		JSONObject json = (JSONObject) JSONObject.toJSON(signin);
		ClientRequest.Request(json, "201", callback);
	}

	@Override
	public void getSignins(String gid, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("gid", gid);
		ClientRequest.Request(json, "202", callback);
	}

	@Override
	public void signin(SigninMember member, Callback callback) {
		JSONObject json = (JSONObject) JSONObject.toJSON(member);
		ClientRequest.Request(json, "203", callback);
	}

	@Override
	public void findMembers(String gid, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("gid", gid);
		ClientRequest.Request(json, "204", callback);
	}

	@Override
	public void findSigns(String uid, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("uid", uid);
		ClientRequest.Request(json, "205", callback);
	}
}
