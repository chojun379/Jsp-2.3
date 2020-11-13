<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="member" scope="request" class="chap08.member.MemberInfo"/>
<%
	member.setId("cwj");
	member.setName("최원준");
%>
<jsp:forward page="/chap08/useObject.jsp"/>