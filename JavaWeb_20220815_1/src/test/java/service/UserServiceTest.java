package service;

import org.junit.Test;

import mvc.service.UserService;

public class UserServiceTest {
	
	@Test
	public void test() throws Exception{
		UserService userService = new UserService();
		int rouwcount = userService.add("TEST","1234","72000");
		if(rouwcount==1) {
			System.out.println("新增成功");
		}else {
			throw new RuntimeException("新增失敗");
		}
	}

}
