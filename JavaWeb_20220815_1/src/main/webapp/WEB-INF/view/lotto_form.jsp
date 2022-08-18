<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>

	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Lotto Form</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="post" action="${ pageContext.request.contextPath }/servlet/lotto">
			<fieldset>
				<legend>Lotto Form</legend>
				姓名：<input type="text" id="username" name="username" value="John" required="required"/>
				<p/>
				<button type="submit" class="pure-button pure-button-primary">電腦選號</button>
			
			</fieldset>
		</form>
		
		
	    <form class = "pure-form">
		  <fieldset>
				<legend>Lotto list【用c:的標籤語法】</legend>				
				原始資料：${ lottos }<p/>
			  <table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>序號</th>
							<th>號碼</th>
						</tr>			
					</thead>
					<tbody>
						<c:forEach varStatus="status" var="num" items="${ lottos }">
							<tr>
								<td>${ status.index }</td>
								<td>${ num }</td>
							</tr>		
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</form>
	</body>
	
	


</html>