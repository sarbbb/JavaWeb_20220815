import org.junit.Test;

import service.LottoService;

public class TestLottoService {
	@Test
	public void test() {
		LottoService service = new LottoService();
		System.out.println(service.getLotto());
		System.out.println(service.getLotto());
		System.out.println(service.getLotto());
		System.out.println(service.getLotto());
		System.out.println(service.getLotto());
		System.out.println(service.getLottos());
	}
}
