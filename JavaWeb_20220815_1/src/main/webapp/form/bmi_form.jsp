<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			function checkData() {
				var h = document.getElementById('height');
				var w = document.getElementById('weight');
				console.log(h.value);
				console.log(isNaN(h.value));
				if(h.value.trim().length ==0){
					alert('請輸入身高!');
					h.focus();
					return false;
				}
				if(w.value.trim().length ==0){
					alert('請輸入體重!');
					w.focus();
					return false;
				}
				return true;
			}
			
			function update(value, tagName) {
				document.getElementById(tagName).innerText = value;
			}
		</script>
	</head>
	<boty style="padding:15px">
	<body>
		<form class="pure-form" method = "post" onsubmit="return checkData()"
			  action="/JavaWeb_20220815_1/servlet/bmi"
			  enctype="application/x-www-form-urlencoded" >
			<fieldset>
				<legend>BMI form1</legend>
				身高：<input type="number" id="height" name="height" placeholder="請輸入身高" value="170"><p />
				<!-- 也可以在input裡加上參數required="required" -->
				<!--身高：<input type="number" id="height" name="height" placeholder="請輸入身高" value="170" required="required">-->
				體重：<input type="number" id="weight" name="weight" placeholder="請輸入體重" value="60"><p />
				<!--<button type="reset">清除</button>  -->
				<button type="submit">計算</button>
			</fieldset>
		</form>
		
		<p/>
		
		<form method = "post" 
			  action="/JavaWeb_20220815_1/servlet/bmi" >
			<fieldset>
				<legend>BMI form2</legend>
				身高：<input type="number" id="height" name="height" placeholder="請輸入身高" required="required"><p />
				體重：<input type="number" id="weight" name="weight" placeholder="請輸入體重" required="required"><p />
				<button type="reset" class="pure-button pure-button">清除</button>
				<button type="submit" class="pure-button pure-button-primary">計算</button>
			</fieldset>
		</form>
		
		<p/>
		
		<form method="post" action="/JavaWeb_20220815_1/servlet/bmi">
			<fieldset>
				<legend>BMI Form 3</legend>
				身高: <input type="range" id="height" name="height" min="1" max="300" onmousemove="update(this.value, 'height_value')" > <span id="height_value"></span><p />
				體重: <input type="range" id="weight" name="weight" min="1" max="300" onmousemove="update(this.value, 'weight_value')" onchange="update(this.value, 'weight_value')"> <span id="weight_value"></span><p />
				<button type="submit">計算</button>
			</fieldset>
		</form>
		
	</body>
</html>