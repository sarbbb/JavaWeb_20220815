package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LottoService;

@WebServlet("/servlet/lotto")
public class LottoServlet extends HttpServlet{
	
	private LottoService lottoService = new LottoService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得表單傳來的使用者姓名
		String username = req.getParameter("username");
		// 透過 lottoService 取得 lotto 號碼
		List<Integer> nums = lottoService.getLotto();
		List<List<Integer>> lottos = lottoService.getLottos();
		
		// 透過分派器將資料傳遞給 /WEB-INF/view/lotto_result.jsp 來呈現資訊
		RequestDispatcher rd = req.getRequestDispatcher("../WEB-INF/view/lotto_result.jsp");
		// 準備要傳送給 lotto_result.jsp 來呈現的資料
		req.setAttribute("username", username);
		req.setAttribute("nums", nums);
		req.setAttribute("lottos", lottos);
		// 執行內部重導
		rd.forward(req,resp); //執行內部重導 (重導到 /WEB-INF/view/lotto_result.jsp)
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mode = req.getParameter("mode")+""; // 在String mode宣告時，後面+"(空字串)"，這樣，走到switch時才不會出錯，加了空字串後，就算前面的mode Parameter是null，String mode也會變成"" 
		int index = 0;
		
		// 模式運行
		switch(mode) {  // switch裡面不能放null，會拋exception  // 解決方法可以在switch外面加一層if判斷，或是在String mode宣告時，後面+"(空字串)"
			case "update":    // 修改模式
				index = Integer.parseInt(req.getParameter("index")); // 取得index
				lottoService.updateLotto(index);  // 進行修改
				break;
			case "delete":    // 刪除模式
				index = Integer.parseInt(req.getParameter("index")); // 取得index
				lottoService.deleteLotto(index); // 進行刪除
				break;
		}
		// 透過分派器將資料傳遞給 /form/lotto_form.jsp 來呈現資訊
		RequestDispatcher rd = req.getRequestDispatcher("../WEB-INF/view/lotto_form.jsp");
		// 準備要傳送給 lotto_result.jsp 來呈現的資料
		List<List<Integer>> lottos = lottoService.getLottos();
		req.setAttribute("lottos", lottos);
		// 執行內部重導
		rd.forward(req,resp); //執行內部重導 (重導到 /form/lotto_form.jsp)
		
	}
	
	
	
}
