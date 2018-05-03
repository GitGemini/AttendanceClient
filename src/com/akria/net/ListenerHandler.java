package com.akria.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.akria.domain.SocketMessage;
import com.henu.utils.MessageManager;
import com.henu.utils.SocketUtil;

public class ListenerHandler implements Runnable {

	private Socket s = SocketUtil.getInstance().getSocket();
	
	@Override
	public void run() {
		System.out.println("开始监听服务器消息推送");
		try {			
			InputStream is = s.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			while (true) {
				sb.setLength(0);
				String msg = null;
				while (!"over".equals(msg = in.readLine())) {
					sb.append(msg);
				}
				msg = sb.toString();

				SocketMessage message = SocketMessage.parseJson(msg);
				if (SocketMessage.TYPE_SIGN == message.getType()) {// 签到消息
					// 发送广播
					System.out.println("Push---收到一条签到消息\n" + msg);
				} else {
					SocketMessage sm = SocketMessage.parseJson(msg);
					MessageManager.putMessage(sm);
					
//					System.out.println("收到一条普通消息\n"+sm);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
