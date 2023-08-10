<%@page import="servlet.model.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>	
<body>
	<h2>회원 정보 수정</h2>
	
	<form action="/update.do" method="post">
		ID : <input type="text" name="id" value="${vo.id}" readonly><br>
		PASSWORD : <input type="password" name="password" value="${vo.password}"><br>
		NAME : <input type="name" name="name" value="${vo.name}"><br>
		ADDRESS : <input type="address" name="address" value="${vo.address}"><br>
		<input type="submit" value="정보수정">
	</form>
</body>
</html>