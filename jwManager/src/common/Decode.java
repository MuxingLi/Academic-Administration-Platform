package common;

import java.io.UnsupportedEncodingException;

public class Decode {
	public static String decode(String s) {
		try {
			return new String(s.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
}
