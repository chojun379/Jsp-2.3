<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose 태그</title>
</head>
<body>

<ul>
<c:choose>
	<c:when test="${param.name == 'cwj'}">
		<li> 당신의 이름은 ${param.name}
	</c:when>
	<c:when test="${20 < param.age}">
		<li> 당신은 20세 이상입니다.
	</c:when>
	<c:otherwise>
		<li> 당신은 'cwj'가 아니고 20세 이상이 아닙니다.
	</c:otherwise>
</c:choose>
</ul>

</body>
</html>