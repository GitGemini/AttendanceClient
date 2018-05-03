package junit.test;

import org.junit.Test;

import com.akria.api.Callback;
import com.akria.api.IGroupAPI;
import com.akria.domain.Group;
import com.akria.domain.GroupAPI;
import com.akria.domain.User;

public class GroupTest {
	private IGroupAPI groupAPI = new GroupAPI();
	
	@Test
	public void testCreateGroup() {
		Group group = new Group();
		group.setGname("你好，世界");
		group.setGowner("2");
		groupAPI.createGroup(group, new Callback() {
			
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
	
	@Test
	public void testUpdateGroup() {
		Group group = new Group();
		group.setGid("5");
		group.setGname("计算机引论");
		group.setGowner("2");
		group.setGicon("aaaa");
		groupAPI.updateGroup(group, new Callback() {
			
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
	
	@Test
	public void testDissGroup() {
		groupAPI.dissGroup("5", new Callback() {
			
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
	
	@Test
	public void testJoinGroup() {
		groupAPI.joinGroup("5", "9", new Callback() {
			
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
	
	@Test
	public void testExitGroup() {
		groupAPI.exitGroup("5", "10", new Callback() {
			
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
	
	@Test
	public void testGetGroup() {
		groupAPI.getGroup("5", new Callback() {
			
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
	
	@Test
	public void testGetGroupList() {
		groupAPI.getGroupList(new Callback() {
			
			@Override
			public void onSuccess(String msg) {
				System.out.println(msg);
				int n = Group.parseJsonArray(msg).size();
				System.out.println(n);
			}
			
			@Override
			public void onFail(String msg) {
				System.out.println(msg);
			}
		});
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testGetGroupMember() {
		groupAPI.getGroupMember("5", new Callback() {
			
			@Override
			public void onSuccess(String msg) {
				System.out.println(msg);
				int n = User.parseJsonArray(msg).size();
				System.out.println(n);		
			}
			
			@Override
			public void onFail(String msg) {
				System.out.println(msg);
			}
		});
	}
	
	@Test
	public void testGetOwnGroup() {
		groupAPI.getOwnGroups("2", new Callback() {
			
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
	
	@Test
	public void testGetInGroups() {
		groupAPI.getInGroups("6", new Callback() {
			
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
}
