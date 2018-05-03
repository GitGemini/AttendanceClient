package junit.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.akria.api.Callback;
import com.akria.api.IUserAPI;
import com.akria.domain.User;
import com.akria.domain.UserAPI;
import com.henu.utils.SocketUtil;

public class SocketClient {

	private Socket s = SocketUtil.getInstance().getSocket();
	private IUserAPI userAPI = new UserAPI();

	// 测试 注册用户
	public void test1() {
		User user = new User();
		user.setPassword("123456");
		user.setRealname("Mack");
		user.setStudentid("1510120026");
		user.setPhonenumber("18612345678");
//		user.setUsericon("defaulticon.png");

		userAPI.register(user, new Callback() {

			@Override
			public void onSuccess(String msg) {
				System.out.println(msg);
			}

			@Override
			public void onFail(String msg) {
				System.out.println(msg);

			}
		});
	}

	// 测试 查询手机号是否注册
	public void test6() {
		String phonenumber = "18637885643";
		userAPI.findPhonenumber(phonenumber, new Callback() {

			@Override
			public void onSuccess(String msg) {
				System.out.println(msg);
			}

			@Override
			public void onFail(String msg) {
				System.out.println(msg);

			}
		});
	}

	// 测试 登录
	public void test2() {
//		String password = "123456";
//		String loginname = "Jack666";
		String password = "666666";
		String loginname = "18756432196";
		userAPI.login(loginname, password, new Callback() {

			@Override
			public void onSuccess(String msg) {
				System.out.println(msg);
			}

			@Override
			public void onFail(String msg) {
				System.out.println(msg);

			}
		});
	}

	// 测试 更改密码
	public void test3() {
		String phonenumber = "110";
		String password = "666666";
		userAPI.resetPassword(phonenumber, password, new Callback() {

			@Override
			public void onSuccess(String msg) {
				System.out.println(msg);
			}

			@Override
			public void onFail(String msg) {
				System.out.println(msg);

			}
		});
	}

	// 测试 获取用户信息功能
	public void test4() {
		String phonenumber = "18234567890";
		userAPI.queryUserInfo(phonenumber, new Callback() {

			@Override
			public void onSuccess(String msg) {
				System.out.println(msg);
			}

			@Override
			public void onFail(String msg) {
				System.out.println(msg);

			}
		});
	}

	// 测试 更改用户信息功能
	public void test5() {
		User user = new User();
		user.setUserid("10");
	    user.setUsername("mmmary");
		user.setPassword("123456");
		user.setRealname("Mary");
		user.setStudentid("1510120009");
		user.setPhonenumber("119");
		user.setUsericon("defaulticon.png");
		userAPI.changeUserInfo(user ,new Callback() {

			@Override
			public void onSuccess(String msg) {
				System.out.println(msg);
			}

			@Override
			public void onFail(String msg) {
				System.out.println(msg);

			}
		});
	}

	public void test33() {
		Request(null);
		ReciveMeg();
	}

	private void Request(String json) {
		System.out.println(json);
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream());
			out.println(json);
			out.println("over");
			out.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReciveMeg();
	}

	private void ReciveMeg() {
		InputStream is;
		try {
			is = s.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			while (true) {
				StringBuilder msg = new StringBuilder();
				String str = null;
				while (!"over".equals(str = in.readLine())) {
					msg.append(str);
				}
				str = msg.toString();
				System.out.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
