package mvc.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import mvc.dao.UserDao;
import mvc.entity.User;

public class UserService extends BaseService{
	
	private UserDao userDao = new UserDao();
	
	public int changePassword(String id, String password, String new_password) {
		
		// 根據 id 得到 user 物件
		User user = get(Integer.parseInt(id));
		if(user == null) return 0;
		// 驗證 password	
		byte[] result = md5.digest(password.getBytes());
		String encryptPassword = String.format("%032X",new BigInteger(result));
		if(!user.getPassword().equals(encryptPassword)) {  // 密碼不相同
			return 0;
		}
		// 將new_password 取代舊有的 password
		result = md5.digest(new_password.getBytes());
		encryptPassword = String.format("%032X",new BigInteger(result));
		return userDao.updatePassword(user.getId(),encryptPassword);
		
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
		int rowcount = userDao.add(user);
		return rowcount;
	}
	
	// 修改 User
	public int update(String id, String username, String salary) throws Exception{
        User user = new User();
        user.setId(Integer.parseInt(id));  // 確認要修改的 id
        // 1. 放入明文 username
		user.setUsername(username);
		
		// 2. 放入加密過後的 salary
		byte[] encryptSalary = des.encrytor(salary); 
		user.setSalary(encryptSalary);
		
		// 3. 修改程序
		int rowcount = userDao.update(user); // 修改
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
	
	// 查詢單筆 user
	public User get(Integer id) {
		User user = userDao.get(id);
		if (user != null) {
			// 將 salary 內容解密
			try {
				byte[] decrypt= des.decryptor(user.getSalary());  // 解密
				user.setSalaryDecrypt(new String(decrypt));   // 轉字串設定
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	// 刪除
	public int delete(Integer id) {
		int rowcount = userDao.delete(id); // 修改
		return rowcount;
	}
	
	// 刪除 overload
	public int delete(String id) {
		int rowcount = delete(Integer.parseInt(id)); // 修改
		return rowcount;
	}
	
	// checkLogin
	public User checkLogin(String username, String password) {
		if(username == null || password == null || username.trim().length() == 0 || password.trim().length() ==0) {
			return null;
		}
		User user = userDao.get(username);
		if(user == null) {
			return null;
		}
		
		// 比對輸入的密碼加密之後是否等於資料表中密碼欄位加密資料
		byte[] result = md5.digest(password.getBytes());
		String encryptPassword = String.format("%032X",new BigInteger(result));

		return encryptPassword.equals(user.getPassword()) ? user : null;
	}
}
