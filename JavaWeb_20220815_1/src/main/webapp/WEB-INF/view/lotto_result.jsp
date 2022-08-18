<%@page import="org.apache.catalina.ant.ListTask"%>
<%@page import="java.util.List"%>
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
	
		<br>
		context path: ${ pageContext.request.contextPath }
	
		<form class = "pure-form" action = "${ pageContext.request.contextPath }/form/lotto_form.jsp">
			<fieldset>
				<legend>Lotto Result 【JSP EL語法】</legend>				
				姓名：${ username }
				<p/>
				號碼：${ nums }
				<button type="submit" class="pure-button">返回</button>
			</fieldset>
		</form>
		
		<form class = "pure-form">
			<fieldset>
				<legend>Lotto list</legend>				
				原始資料：${ lottos }<p/>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>序號</th>
							<th>號碼</th>
						</tr>			
					</thead>
					<tbody>
						<% List<List<Integer>> list = (List<List<Integer>>)request.getAttribute("lottos");%>
						<% for(int i=0; i<list.size(); i++){ %>
							<tr>
								<td><%= i %></td>
								<td><%= list.get(i) %></td>
							</tr>
						<% } %>
					</tbody>
				
				
				
				</table>
			</fieldset>
		</form>
		<br>
		<br>
		<br>
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