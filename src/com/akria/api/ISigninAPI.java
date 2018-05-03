package com.akria.api;

import com.akria.domain.Signin;
import com.akria.domain.SigninMember;

public interface ISigninAPI {

	void createSignin(Signin signin, Callback callback);

	void getSignins(String gid, Callback callback);

	void signin(SigninMember member, Callback callback);

	void findMembers(String sid, Callback callback);

	void findSigns(String uid, Callback callback);

}