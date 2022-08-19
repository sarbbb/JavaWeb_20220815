package security;

import org.junit.Test;

import mvc.service.MD5DigestService;

public class MD5DigestServiceTest {
	@Test
	public void test() {
		String input = "12345";  // 使用者輸入的密碼
		// 假設 encryptString 是存放在資料欄位中的密碼
		String encryptString = "202CB962AC59075B964B07152D234B70";
		// 資料比對
		if(MD5DigestService.equals(input,encryptString)) {
			System.out.println("驗證通過");
		}else {
			throw new RuntimeException("驗證不通過");
		}
		
	}

}
