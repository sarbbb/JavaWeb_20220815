package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.entity.User;
import mvc.service.UserService;

@WebServlet("/mvc/user/password")
public class ChangePasswordController extends HttpServlet {
	
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// QueryString (?id=xxx) 傳來的資料
		String id=req.getParameter("id");
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/change_password.jsp");
		req.setAttribute("id", id);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Form(表單) 傳來的資料
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String new_password = req.getParameter("new_password");
		// 變更密碼
		int rowcount = userService.changePassword(id,password,new_password);
		if(rowcount ==1) {
			 String contextName = req.getServletContext().getServletContextName();
			 resp.sendRedirect("/" + contextName + "/mvc/user/");  // 重導到首頁
		} else {
			throw new ServletException("密碼修改錯誤：舊密碼輸入不正確");
		}
	}

	
}
