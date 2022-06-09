<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Study!</title>
</head>
<body>
	<input id="userId" type="text" placeholder="아이디를 입력하세요..."/>
	<input id="userPassword" type="password" placeholder="비밀번호를 입력하세요..."/>
	<button type="button" onclick="doLogin()">로그인</button>
</body>
<script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
<script type="text/javascript">
	function doLogin(){
		var userId = document.getElementById('userId').value;
		var userPassword = document.getElementById('userPassword').value;
		
		if(userId !== '' || userPassword !== ''){
			var jsonData = {userId : userId, userPassword : userPassword}
			$.ajax({
		        	 url : "/login",
		        	 type : "POST",
		        	 contentType : "application/json",//서버에 json타입으로 요청
		        	 dataType : "json",//서버결과 json으로요청
		        	 data : JSON.stringify(jsonData),
		        	 success : function(reponse){
		        	    if(reponse){
		        	    	location.href = "/board";
		        	    }
		        	 } //success end
			});//ajax end 
		}//if end
	}
</script>
</html>