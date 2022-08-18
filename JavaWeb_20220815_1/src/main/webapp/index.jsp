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
	<ul>
		<li><a href="servlet/hello">HelloServlet</a></li>
		<li><a href="servlet/welcome">WelcomeServlet (配合 Insomnia 操作)</a></li>
		<li><a href="form/bmi_form.jsp">bmi_form</a></li>
		<li><a href="form/program_form.jsp">program_form</a></li>
		<li><a href="servlet/image?name=f18">ImageServlet</a></li>
		<li><a href="form/exchange_form.jsp">exchange_form.jsp</a></li>
	
	</ul>
</body>
</html>