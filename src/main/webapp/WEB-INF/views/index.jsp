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
	<h1>Hello World!</h1>
	<h3>${name}</h3>
	<h3>${backNumber}</h3>
	<!-- c:if는 jsp문법(jstl문법)
		if는 있고 else는 없음
	 -->
	 <!-- jsp if문 -->
	 <!-- 숫자비교 -->
	<c:if test="${backNumber == 7}">
		<h4>대한민국 만세!</h4>	
	</c:if>
	<!-- 문자비교 -->
	<c:if test="${name.equals('손흥민')}">
		<h4>코리아 만세!</h4>
	</c:if>
	
	<!-- if else를 구현하고 싶을 때 -->
	<c:choose>
		<c:when test="${size < 100}">
			<h4>사이즈는 100 입니다.</h4>
		</c:when>
		<c:when test="${size < 200 && size >= 100}">
			<h4>사이즈는 200 미만입니다.</h4>
		</c:when>
		<c:otherwise>
			<h4>사이즈는 200 이상입니다.</h4>
		</c:otherwise>
	</c:choose>
	
	<!-- JSP 반복문 -->
	<!-- String str : wsgList -->
	<c:forEach items="${wsgList}" var="str">
		<h4>${str}</h4>
	</c:forEach>
	
	<c:forEach items="${actorList}" var="Actor">
		<h4>이름 : ${Actor.name}, 나이 :  ${Actor.age}</h4>
	</c:forEach>
	
	<c:forEach items="${mapList}" var="item">
		<h4>${item.no}</h4>
	</c:forEach>
		<h1>${mapList[0].no}</h3>
	
	
</body>
</html>