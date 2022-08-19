package mvc.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import mvc.dao.UserDao;
import mvc.entity.User;

public class UserService extends BaseService{
	private UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	// 新增 User
	public int add(String username, String password, String salary) throws Exception{
        User user = new User();
        
        // 1. 放入明文 username
		user.setUsername(username);
		
		// 2.放入加密過後的 password
		byte[] result = md5.digest(password.getBytes());
		String encryptPassword = String.format("%032X",new BigInteger(result));
		user.setPassword(encryptPassword);
		
		// 3. 放入加密過後的 salary
		byte[] encryptSalary = des.encrytor(salary); 
		user.setSalary(encryptSalary);
		
		// 4. 放入到資料庫中
		UserDao userDao = new UserDao();
		int rowcount = userDao.add(user);
		return rowcount;
	}
	
	// 查詢所有user
	public List<User> queryAll(){
		List<User> users = userDao.queryAll();
		
		// 將 salary 內容解密
		for(User user : users){
			try {
				byte[] decrypt= des.decryptor(user.getSalary());  // 解密
				user.setSalaryDecrypt(new String(decrypt));   // 轉字串設定
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return users;
	}

}
