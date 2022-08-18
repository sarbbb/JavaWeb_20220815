<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Lotto Result</title>
	</head>
	<body style="padding: 15px">
		<form class = "pure-form" action = "${ pageContext.request.contextPath }/form/lotto_form.jsp">
			<fieldset>
				<legend>Lotto Result 【JSP EL語法】</legend>				
				姓名：${ username }
				<p/>
				號碼：${ nums }
				<p/>
				<button type="submit" class="pure-button">返回</button>
			</fieldset>
		</form>
		
		<form class = "pure-form" action = "${ pageContext.request.contextPath }/form/lotto_form.jsp">
			<fieldset>
				<legend>Lotto Result【傳統JSP語法】</legend>				
				姓名：<% out.println(request.getAttribute("username")); %>
				<p/>
				號碼：${ nums }
				<p/>
				<button type="submit" class="pure-button">返回</button>
			</fieldset>
		</form>
		
		<form class = "pure-form" action = "${ pageContext.request.contextPath }/form/lotto_form.jsp">
			<fieldset>
				<legend>Lotto Result【傳統JSP語法(用=取代Out.println)】</legend>				
				姓名：<%= request.getAttribute("username") %>
				<p/>
				號碼：${ nums }
				<p/>
				<button type="submit" class="pure-button">返回</button>
			</fieldset>
		</form>
	</body>
</html>