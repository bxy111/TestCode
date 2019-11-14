package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {

	public static void main(String[] args) {
		//本机：localhost      127.0.0.1
		try {
			InetAddress ia = InetAddress.getLocalHost();
			System.out.println(ia);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

	}

}
