package junit.test;

import java.util.List;

import org.junit.Test;

import com.akria.api.Callback;
import com.akria.api.ISigninAPI;
import com.akria.api.IUserAPI;
import com.akria.domain.Signin;
import com.akria.domain.SigninAPI;
import com.akria.domain.SigninMember;
import com.akria.domain.UserAPI;

public class SigninTest {
	@Test
	public void createSignin() {
		System.out.println(Thread.currentThread().getId());
		IUserAPI userAPI = new UserAPI();
		userAPI.login("18738976628", "89456123", new Callback() {
			
			@Override
			public void onSuccess(String msg) {
				System.out.println("Receive--"+msg);
			}
			
			@Override
			public void onFail(String msg) {
				System.out.println("Receive--"+msg);				
			}
		});		
		
		Signin signin = new Signin();
		signin.setGid(2);
		signin.setOriginator(3);
		signin.setLatitude("22.22");
		signin.setLogintude("33.33");
		signin.setRegion("20");
		ISigninAPI signinAPI = new SigninAPI();
		signinAPI.createSignin(signin, new Callback() {
			
			@Override
			public void onSuccess(String msg) {
				System.out.println("Receive--"+msg);
			}
			
			@Override
			public void onFail(String msg) {
				System.out.println("Receive--"+msg);				
			}
		});
		
		while (true) {
			try {
				Thread.sleep(2000);
//				System.out.println("1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void getSignins() {
		ISigninAPI signinAPI = new SigninAPI();
		signinAPI.findMembers("1", new Callback() {
			
			@Override
			public void onSuccess(String msg) {				
				System.out.println(msg);
				List<SigninMember> mes = SigninMember.parseJsonArray(msg);
				export(mes);
			}
			
			@Override
			public void onFail(String msg) {
				System.out.println(msg);
			}
		});
		
		while (true) {
			try {
				Thread.sleep(2000);
//				System.out.println("1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void signin() {
		ISigninAPI signinAPI = new SigninAPI();
		SigninMember member = new SigninMember();
		member.setGid(2);
		member.setReceiver(3);
		member.setRlatitude("45.32");
		member.setRlogintude("12.32");
//		member.setResult(1);
		signinAPI.signin(member, new Callback() {
			
			@Override
			public void onSuccess(String msg) {				
				System.out.println(msg);	
			}
			
			@Override
			public void onFail(String msg) {
				System.out.println(msg);
			}
		});
		
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void export(List<SigninMember> mes) {
		PoiExcelExport pee = new PoiExcelExport("E:/test.xls","sheet1");   
	      
	    //调用  
	    String titleColumn[] = {"gid","receiver","time","rlogintude","rlatitude","result"};  
	    String titleName[] = {"签到id","签到人id","签到时间","签到经度","签到纬度","签到结果"};    
	    int titleSize[] = {13,13,13,13,13,13};  
	      
	    pee.wirteExcel(titleColumn, titleName, titleSize, mes);
	}

}
