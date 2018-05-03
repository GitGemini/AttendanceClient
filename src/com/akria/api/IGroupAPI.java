package com.akria.api;

import com.akria.domain.Group;

public interface IGroupAPI {

	void createGroup(Group group, Callback callback);

	void updateGroup(Group group, Callback callback);

	void dissGroup(String gid, Callback callback);

	void joinGroup(String gid, String uid, Callback callback);

	void exitGroup(String gid, String uid, Callback callback);

	void getGroup(String gid, Callback callback);

	void getGroupList(Callback callback);

	void getGroupMember(String gid, Callback callback);

	void getOwnGroups(String gowner, Callback callback);

	void getInGroups(String userid, Callback callback);

}