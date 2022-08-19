package mvc.service;

import java.math.BigInteger;
import java.security.MessageDigest;


public class MD5DigestService {
	// 取得加密資料
	public static String getEncryptString(String input)  {
		
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] result = md5.digest(input.getBytes());
			// 16 進位字串格式(32個字不足補0)
			String output = String.format("%032X",new BigInteger(result));  //大寫「X」是指16進位
			return output;
		} catch (Exception e) {
			e.printStackTrace();
		}    //加密技術除了MD5之外，還有SHA1
		return null;
	}
	
	// 比對加密資料
	public static boolean equals(String input, String encryptString) {
		String inputEncryptString = getEncryptString(input);
		return inputEncryptString.equals(encryptString);
	}
			
	

}
