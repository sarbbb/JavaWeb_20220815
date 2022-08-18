package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class LottoService {
	
	// 泛型用List<Integer>表示List裡面還有List
	private static List<List<Integer>> lottos = new CopyOnWriteArrayList<>();  // 這裡宣告成"static"是讓model裡(LottoService)無論在做"讀取"、"修改"、"刪除"時，都是讀同一個List<List<Integer>>
	
	// 四星彩電腦選號
	public List<Integer> getLotto(){
		Random random = new Random();
		List<Integer> nums = new ArrayList<>();
		for(int i=0; i<4; i++)
		{
			nums.add(random.nextInt(10));   // 隨機取0~9加入list裡
		}
		lottos.add(nums); // 將每一次的 nums 放入到 lottos 裡記錄起來
		return nums;
	}
	
	// 取得所有 lotts 記錄
	public List<List<Integer>> getLottos(){
		return lottos;
	}
	
	// 修改 lotto 資料
	public void updateLotto(int index) {
		// 重新產生一組號碼
		Random random = new Random();
		List<Integer> nums = new ArrayList<>();
		for(int i=0; i<4; i++)
		{
			nums.add(random.nextInt(10));   // 隨機取0~9加入list裡
		}
		
		// 置換資料
		// 將lottos 位於index 位置的資料置換成新資料 nums
		lottos.set(index, nums);
	}
	
	// 刪除 lotto 資料
	public void deleteLotto(int index) {
		// 刪除指定位置資料
		lottos.remove(index);
	}
}
