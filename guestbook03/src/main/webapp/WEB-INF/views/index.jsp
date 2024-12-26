<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/add" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4>
					<textarea name="contents" cols=60 rows=5></textarea>
				</td>
			</tr>
			<tr>
				<td colspan=4 align=right>
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>

	<c:forEach items="${list }" var="vo">
		<br>
		<table width=510 border=1>
			<tr>
				<td>[ ${vo.id} ]</td>
				<td>${vo.name}</td>
				<td>${vo.regDate}</td>
				<td><a href="${pageContext.request.contextPath }/delete/${vo.id}">삭제</a></td>
			</tr>
			<tr>
				<c:set var="contents" value="${vo.contents}"/>
				<td colspan=4>
<%--					<p>${fn:replace(contents, "\n", "<br>")}</p>--%>
						${vo.contents}
				</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>