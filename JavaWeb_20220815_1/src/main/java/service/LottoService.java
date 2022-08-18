package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoService {
	public List<Integer> getLotto(){
		Random random = new Random();
		List<Integer> nums = new ArrayList<>();
		for(int i=0; i<4; i++)
		{
			nums.add(random.nextInt(10));   //隨機取0~9加入list裡
		}
		return nums;
	}
}
