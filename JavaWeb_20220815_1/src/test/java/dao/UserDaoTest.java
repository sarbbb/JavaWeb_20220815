package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import mvc.dao.UserDao;
import mvc.entity.User;
import mvc.service.EncryptDESService;

public class UserDaoTest {
	@Test
	public void test() throws Exception {
		User user = new User();
		user.setUsername("Andy");
		// 放入加密過後的 password
		String password = "3333";
		MessageDigest md5 = MessageDigest.getInstance("MD5");  
		byte[] result = md5.digest(password.getBytes());
		String encryptPassword = String.format("%032X",new BigInteger(result));
		user.setPassword(encryptPassword);
		
		// 放入加密過後的 salary
		String salary = "72000";
		String path = "src/main/java/mvc/service/user.key";  //密鑰位置
		EncryptDESService des = new EncryptDESService(); //建立 DES 加密服務
		des.genKey(path); 
		byte[] encryptSalary = des.encrytor(salary); 
		user.setSalary(encryptSalary);
		
		UserDao userDao = new UserDao();
		int rowcount = userDao.add(user);
		if(rowcount == 1) {
			System.out.println("新增成功");
		}else {
			throw new RuntimeException("新增失敗");
		}
	}
	
}
