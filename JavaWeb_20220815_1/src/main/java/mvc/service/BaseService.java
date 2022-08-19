package mvc.service;

import java.security.MessageDigest;

public class BaseService {
	protected String path;
	protected MessageDigest md5;
	protected EncryptDESService des;
	
	public BaseService() {
		path = "src/main/java/mvc/service/user.key";  //密鑰位置
		des = new EncryptDESService(); //建立 DES 加密服務
		
		try {
			des.genKey(path);
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
