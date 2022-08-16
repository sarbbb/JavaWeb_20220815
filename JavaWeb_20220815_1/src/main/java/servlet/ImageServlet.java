package servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 將存放在C:\Users\MB-207\Pictures\f18.jpg 的圖片透過 ImageServlet 顯示給前端
 * 將存放在C:\Users\MB-207\Pictures\f16.jpg 的圖片透過 ImageServlet 顯示給前端
 * 
 * 瀏覽可以透過 http://../servlet/image?name=f18 路徑得到此圖
 * 瀏覽可以透過 http://../servlet/image?name=f16 路徑得到此圖
 * 
 */
@WebServlet("/servlet/image")
public class ImageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//先設定回傳的格式
		resp.setContentType("image/jpg"); 
		
		String name = req.getParameter("name");
		if(name == null || name.trim().length() ==0 ) {
			name = "f18";  //沒填預設f18
		}
		
		String imagePath = "C:\\Users\\MB-207\\Pictures\\%s.jpg";
		imagePath = String.format(imagePath, name);
		
		Path path = Paths.get(imagePath);
		ServletOutputStream out = resp.getOutputStream();
		Files.copy(path,out);
		out.close();
	}
	

}
