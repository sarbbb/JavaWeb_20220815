package security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5DigestDemo {
	
	// MD5 加密(不可逆) 
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String input = "123";
		MessageDigest md5 = MessageDigest.getInstance("MD5");    //加密技術除了MD5之外，還有SHA1
		byte[] result = md5.digest(input.getBytes());
		// 印出 byte[] result
		System.out.println(Arrays.toString(result));
		// 印出 new BigInteger(result) 10 進位
		System.out.println(new BigInteger(result));
		//印出 16 進位字串格式(32個字不足補0)
		String output = String.format("%032X",new BigInteger(result));  //大寫「X」是指16進位
		System.out.println(output);
	}

}
