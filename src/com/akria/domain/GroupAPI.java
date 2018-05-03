package com.akria.domain;

import com.akria.api.Callback;
import com.akria.api.IGroupAPI;
import com.akria.net.ClientRequest;
import com.alibaba.fastjson.JSONObject;

public class GroupAPI implements IGroupAPI {

	@Override
	public void createGroup(Group group, Callback callback) {
		JSONObject json = (JSONObject) JSONObject.toJSON(group);
		ClientRequest.Request(json, "101", callback);
	}

	@Override
	public void updateGroup(Group group, Callback callback) {
		JSONObject json = (JSONObject) JSONObject.toJSON(group);
		ClientRequest.Request(json, "102", callback);
	}

	@Override
	public void dissGroup(String gid, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("gid", gid);
		ClientRequest.Request(json, "103", callback);
	}

	@Override
	public void joinGroup(String gid, String uid, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("gid", gid);
		json.put("uid", uid);
		ClientRequest.Request(json, "104", callback);
	}

	@Override
	public void exitGroup(String gid, String uid, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("gid", gid);
		json.put("uid", uid);
		ClientRequest.Request(json, "105", callback);
	}

	@Override
	public void getGroup(String gid, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("gid", gid);
		ClientRequest.Request(json, "106", callback);
	}

	@Override
	public void getGroupList(Callback callback) {
		JSONObject json = new JSONObject();
		ClientRequest.Request(json, "107", callback);
	}

	@Override
	public void getGroupMember(String gid, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("gid", gid);
		ClientRequest.Request(json, "108", callback);
	}
	
	@Override
	public void getOwnGroups(String gowner, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("gowner", gowner);
		ClientRequest.Request(json, "109", callback);
	}

	@Override
	public void getInGroups(String userid, Callback callback) {
		JSONObject json = new JSONObject();
		json.put("userid", userid);
		ClientRequest.Request(json, "110", callback);
	}
}
