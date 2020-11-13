<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext 기본 객체</title>
</head>
<body>

<%
	HttpServletRequest httpRequesst = (HttpServletRequest)pageContext.getRequest();
%>

request 기본 객체와 pageContext.getRequest()의 동일여부 :
<%= request == httpRequesst %>
<br>

pageContext.getOut() 메서드를 사용한 데이터 출력 : 
<% pageContext.getOut().println("안녕하세요!"); %>

</body>
</html>