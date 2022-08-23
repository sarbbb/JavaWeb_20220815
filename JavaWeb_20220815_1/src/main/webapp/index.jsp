<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	現在時刻： <%=new Date() %>
	<br>
	<br>
	<br>
	context path: ${ pageContext.request.contextPath }
	<ul>
		<li><a href="${ pageContext.request.contextPath }/servlet/hello">HelloServlet</a></li>
		<li><a href="${ pageContext.request.contextPath }/servlet/welcome">WelcomeServlet (配合 Insomnia 操作)</a></li>
		<li><a href="${ pageContext.request.contextPath }/form/bmi_form.jsp">bmi_form</a></li>
		<li><a href="${ pageContext.request.contextPath }/form/program_form.jsp">program_form</a></li>
		<li><a href="${ pageContext.request.contextPath }/servlet/image?name=f18">IcontextPamageServlet</a></li>
		<li><a href="${ pageContext.request.contextPath }/form/exchange_form.jsp">exchange_form.jsp</a></li>
		<li><a href="${ pageContext.request.contextPath }/servlet/lotto">/servlet/lotto (MVC版)</a></li>
		<hr/>
		<li><a href="${ pageContext.request.contextPath }/mvc/user/">/mvc/user (JDBC)</a></li>
		<li><a href="${ pageContext.request.contextPath }/mvc/book/">/mvc/product (REST/JDBC)</a></li>
		<li><a href="${ pageContext.request.contextPath }/mvc/cart/">/mvc/cart (REST/JPA)</a></li>
		<li><a href="${ pageContext.request.contextPath }/mvc/chat/">/mvc/chat (WebSocket)</a></li>
	
	</ul>
</body>
</html>