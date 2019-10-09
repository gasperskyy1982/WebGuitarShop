<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/include/Header.jsp"%>


<h1>Product page</h1>
<div style="color: white">
	<c:forEach var="product" items="${requestScope.productList}">
		<table>
			<tr>
				<td width="200">${product.name}</td>
				<td width="400"></td>
			</tr>
			<tr>
				<td><img src="./productImage/${product.id}.jpg" height="200" weight="200"></td>
				<td>${product.description}</td>
			</tr>
			<tr>
				<td>price:${product.price}</td>
				<td>
				<form action = "./cart" method = "post"><input type = "hidden" name ="productToBuy" value ="${product.id}" /> 
				<input type="submit" value="buy" />
				
			</form></td></tr>
		</table>
		<br>
		<br>
	</c:forEach>
</div>
<%@ include file="/WEB-INF/include/Footer.jsp"%>