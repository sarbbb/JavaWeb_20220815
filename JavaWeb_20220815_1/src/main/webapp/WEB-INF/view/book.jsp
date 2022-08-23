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
		<title>Book form</title>
		<script type="text/javascript">
			function submitForm(){
				var id = document.getElementById("id").value;
				if(id == ''){  // 表示是新增模式
					return true;
				}
				// 修改 PUT 需透過 Javascript / Ajax 將資料送到後台
				var name = document.getElementById("name").value;
				var amount = document.getElementById("amount").value;
				var price = document.getElementById("price").value;
				var updateUrl = "${ pageContext.request.contextPath }/mvc/book/" + id;
				var fd = 'id=' + id + '&name=' + name + '&amount=' + amount + '&price=' + price;  
				console.log(fd);
				// 透過 Ajax
				var xhttp = new XMLHttpRequest();
				xhttp.onload = function(){
					window.location.href ='${ pageContext.request.contextPath}/mvc/book/';
				}
				// Send a request
				xhttp.open("PUT", updateUrl);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.send(fd);
				return false;
			}
			
			function deleteBook(id){
				var deleteUrl = '${ pageContext.request.contextPath}/mvc/book/'+ id;
				var xhttp = new XMLHttpRequest();
				xhttp.onload = function(){
					window.location.href = '${pageContext.request.contextPath}/mvc/book/';
				}
				
				// Send a request
				xhttp.open("DELETE", deleteUrl);
				xhttp.setRequestHeader("Context-type", "application/x-www-form-urlencoded");
				xhttp.send();
			}
		</script>
	</head>
	<body style="padding: 15px">
		<form id="bookForm" class="pure-form" onsubmit="return submitForm();" method="post" action="${ pageContext.request.contextPath }/mvc/book/">
			<fieldset>
				<legend>Book form</legend>
				序號：<input type="text" value="${ requestScope.book.id }" id="id" name="id" readonly="readonly"/></p>
				書名：<input type="text" value="${ requestScope.book.name }" id="name" name="name" required="required"/></p>
				數量：<input type="number" value="${ requestScope.book.amount }" id="amount" name="amount" required="required"/></p>
				價格：<input type="number" value="${ requestScope.book.price }" id="price" name="price" required="required"/></p>
				填表人ID：${sessionScope.user.id }<p/>
				填表：${sessionScope.user.username } <p/>
				<button type="submit" class="pure-button pure-button-primary">${ requestScope.buttonName }</button>
			</fieldset>
		</form>
		<form class="pure-form" action="">
			<fieldset>
				<legend>Book List</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>序號</th><th>書名</th><th>數量</th><th>價格</th><th>填表人ID</th><th>刪除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${ requestScope.books }">
							<tr>
								<td><a href= "${ pageContext.request.contextPath }/mvc/book/${ book.id }">
										${ book.id }
									</a>
								</td>
								<td>${ book.name }</td>
								<td>${ book.amount }</td>
								<td>${ book.price }</td>
								<td>${ book.userId }</td>
								<td><a href= "javaScript:deleteBook(${book.id})">
										刪除
									</a>
								</td>
							</tr>
							
						</c:forEach>
					</tbody>
				</table>	
			</fieldset>
		</form>
	</body>
</html>