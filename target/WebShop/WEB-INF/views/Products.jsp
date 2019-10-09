<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/include/Header.jsp"%>


<ul id="gallery">
		<li><a href="images/classical_01.jpg"><img src="./images/classical_01.jpg" title="Classical guitars" alt="" /></a></li>
		<li><a href="images/stage_01.jpg"><img src="./images/stage_01.jpg" title="Classical guitars" alt="" /></a></li>
		<li><a href="images/electrical_01.jpg"><img src="./images/electrical_01.jpg" title="Classical guitars" alt="" /></a></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	<br class="clear" />
	<script type="text/javascript">
		$('#gallery').poptrox();
		</script>
		

<%@ include file="/WEB-INF/include/Footer.jsp"%>