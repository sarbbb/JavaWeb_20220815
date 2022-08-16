package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmi")
public class BMIServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//支援中文
		req.setCharacterEncoding("utf-8");  //請求是用utf-8
		resp.setCharacterEncoding("utf-8");  //回應是用utf-8
		resp.setContentType("text/html;charset=utf-8");    //回應文件 utf-8 編碼  (給前端browser使用)
		
		//取得表單資料
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");		
		
		double bmi = 0;
		String errorMessage = "";
		
		//資料檢查
		if(height !=null && !height.isBlank() && weight !=null && !weight.isBlank() ) {
			//資料整理
			double h = Double.parseDouble(height);
			double w = Double.parseDouble(weight);
			//商業邏輯處理(計算bmi值)
			bmi = w / Math.pow(h/100,2);
		}else {
			errorMessage="請輸入正確的身高與體重";
		}

		//回應結果
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("BMI 計算結果：");
		out.println(String.format("%.2f", bmi));
		out.println(errorMessage);
		out.println("</html>");
	}
}
