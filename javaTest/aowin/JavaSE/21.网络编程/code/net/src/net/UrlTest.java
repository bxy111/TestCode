package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlTest {

	public static void main(String[] args)throws Exception {
		//URL url = new URL("http://192.168.0.101:8080/baidu/font.html");
		URL url = new URL("http://192.168.0.101:8080/baidu/person.xml");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.getInputStream();
//		conn.getOutputStream();
		
		InputStream inStream = conn.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inStream,"gbk"));
		String line = reader.readLine();
		while(line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		
		reader.close();
	}

}
