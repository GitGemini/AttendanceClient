package com.henu.utils;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketUtil {	
	private static String IPAdress = "127.0.0.1";
//	private static String IPAdress = "192.168.43.62";	
//	private static String IPAdress = "10.248.65.35";	
	private static final int PORT = 52068;
	
	private Socket socket;	
	public static void setIPAdress(String ip) {
		IPAdress = ip;
	}
	
	private static class SocketHolder {
        private static final SocketUtil INSTANCE = new SocketUtil();
    }
	
    public static final SocketUtil getInstance() {
        return SocketHolder.INSTANCE;
    }
	
	private SocketUtil() {
		try {
			socket = new Socket(IPAdress, PORT);			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}
}
