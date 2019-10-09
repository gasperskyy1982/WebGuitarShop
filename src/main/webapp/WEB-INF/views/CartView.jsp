<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/include/Header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
</head>

<h1>Cart Page</h1>
<div style="color: white">
<form action="./cart" method="post">
	<table border='1' width = "300">
	
			<c:forEach var="product" items="${productMap.entrySet()}">
				<tr align='center'>
					<td width = "30"><img src="./productImage/${product.getKey().id}.jpg"
						height="25"></td>
					<td width="80"><input type="hidden" name="productToBuy"
						value="${product.getKey().id}" /> ${product.getKey().name}</td>
					<td width="20">${product.getKey().price}</td>
					<td width="20"><input type="hidden" name="productToBuy"
						value="" /> ${product.getValue()}</td>
			<!-- 		<td width="20"><input id="increment${product.getKey().id}" type="submit"
						name="submit" value="+" /></td>
					<td width="20"><input id="decrement${product.getKey().id}" type="submit"
						name="submit" value="-" /></td> -->
					<c:set var = "Summ" value = "${Summ + (product.getValue() * product.getKey().price)}" />
					<td width="30">${product.getValue() * product.getKey().price}</td>
			</c:forEach>
	</table>	
	<table border='1' width = "300">
	<tr>
				<td align = "center"><input type="hidden" name="ClearCart" value="Ok" /> <input
					type="submit" value="ClearCart" /></td>
				<td width = "75" align = "center"> Final Summ: </td>
				<td width = "45" align = "center"> ${Summ} </td>
			</tr>
	</table>
</form>
</div>

</html>


<%@ include file="/WEB-INF/include/Footer.jsp"%>