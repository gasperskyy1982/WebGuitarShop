<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/include/Header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<link href="./styles/style.css" rel="stylesheet" />
<title>Authorizated</title>
</head>
<body>
	<table align="center">
		<tr>
			<td width="100px" align='center'><a href='./auth?logOut=ok'> LOGOUT</a></td>
			<td width="100px" align='center'><a href='./correct'>CORRECT</a></td>
		</tr>

		<tr>
			<td align="center">Hello!
				<h1>${authUser.name}</h1> <br />
				<div>You are ${auth}</div>
				<br />
				<div>${authUser.login}</div>
				<br />
				<div>${authUser.password}</div>
				<br />
				<div>${authUser.name}</div>
				<br />
				<div>${authUser.region}</div>
				<br />
				<div>${authUser.gender}</div>
				<br />
				<div>${authUser.comment}</div>
				<br />
			</td>
		</tr>
	</table>
</body>
</html>

<%@ include file="/WEB-INF/include/Footer.jsp"%>