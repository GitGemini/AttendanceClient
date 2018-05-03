package junit.test;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class UserTest {
	private SocketClient client = new SocketClient();

	@Test
	public void testRegister() {
		client.test1();
		while (true) {

		}
	}

	@Test
	public void test2() {
		client.test2();
		while (true) {

		}
	}

	@Test
	public void test3() {
		client.test3();
	}

	@Test
	public void test4() {
		client.test4();
	}

	@Test
	public void test5() {
		client.test5();
	}

	@Test
	public void test6() {
		client.test6();
	}

	@Test
	public void test33() {
		JSONObject json = new JSONObject();
		json.put("name", "abc");
		json.put("name", "qwe");
		System.out.println(json.toJSONString());
	}
}
