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
	
	<form action="/UpdateServlet" method="post">
		ID : <input type="text" name="id" value="${dto.id}" readonly><br>
		PASSWORD : <input type="text" name="password" value="${dto.password}"><br>
		NAME : <input type="text" name="name" value="${dto.name}"><br>
		ADDRESS : <input type="text" name="address" value="${dto.address}"><br>
		<input type="submit" value="정보수정">
	</form>
</body>
</html>