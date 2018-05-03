package com.akria.api;

import com.akria.domain.User;

public interface IUserAPI {

	void register(User user, Callback callback);

	void login(String phonenumber, String password, Callback callback);

	void resetPassword(String phonenumber, String password, Callback callback);

	void queryUserInfo(String phonenumber, Callback callback);

	void changeUserInfo(User user, Callback callback);

	void findPhonenumber(String phonenumber, Callback callback);

}