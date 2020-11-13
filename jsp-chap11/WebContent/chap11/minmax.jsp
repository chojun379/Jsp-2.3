<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="chap11.Member, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL min, max</title>
</head>
<body>

${ vals = [20, 17, 30, 2, 9, 23] ; '' }
${ vals.stream().min().get() }
<hr>
<%
	List<Member> memberList = Arrays.asList(
			new Member("홍길동", 20), new Member("이순신", 54),
			new Member("유관순", 19), new Member("왕건", 42) );
	request.setAttribute("members",	memberList);
%>
${ maxAgeMemOpt = members.stream().max((m1, m2) -> m1.age.compareTo(m2.age)) ; '' }
${ maxAgeMemOpt.get().name } (${ maxAgeMemOpt.get().age }세)

</body>
</html>