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
		//取得表單傳來的使用者姓名
		String username = req.getParameter("username");
		//透過 lottoService 取得 lotto 號碼
		List<Integer> nums = lottoService.getLotto();
		
		RequestDispatcher rd = req.getRequestDispatcher("../WEB-INF/view/lotto_result.jsp");
		req.setAttribute("username", username);
		req.setAttribute("nums", nums);
		rd.forward(req,resp);
		
	}
	

	
}
