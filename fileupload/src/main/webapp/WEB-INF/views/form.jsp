<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
<h1>파일 업로드 예제</h1>
<form method="post" action="upload" enctype="multipart/form-data">
	<label for="email">email:</label>
	<input type="text" id="email" name="email" value="kickscar@gmail.com">
<%--	<input type="text" id="email" name="email" value="kickscar@gmail.com">--%>
	<br><br>

	<label for="file">파일:</label>
	<input type="file" id="file" name="file">
	<br><br>

	<br>
	<input type="submit" value="upload">
</form>
</body>
</html>