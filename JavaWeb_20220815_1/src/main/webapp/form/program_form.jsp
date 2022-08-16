<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Program</title>
	</head>
	<body style = "padding:15px">
		<form class="pure-form" method = "post"
			  action="/JavaWeb_20220815_1/servlet/program">
			<fieldset>
				<legend>BMI form1</legend>
				姓名：<input type="text" id="username" name="username" placeholder="請輸入姓名"><p />
				程式：<input type="checkbox" id="program" name="program" value="C#" />C#
					<input type="checkbox" id="program" name="program" value="VB" />VB
					<input type="checkbox" id="program" name="program" value="JAVA" />JAVA
					<input type="checkbox" id="program" name="program" value="Python" />Python
					<input type="checkbox" id="program" name="program" value="SQL" />SQL

				<button type="reset" class="pure-button pure-button">清除</button>
				<button type="submit" class="pure-button pure-button-primary">送出</button>
			</fieldset>
		</form>
	</body>
</html>