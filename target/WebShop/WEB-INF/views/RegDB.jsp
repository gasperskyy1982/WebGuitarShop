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
<title>Insert title here</title>
</head>
<body>


<c:choose>
<c:when test = "${showForm == 'true'}">

	<form id="registerForm" action="./register" method="post">
		<table border="0" align="center">
			<tr>
				<td>
					<table>
						<div class="field">
							<label>Login</label>
							<div class="input">
								<input type="text" name="Login" placeholder="Enter your login"
									title="name@adress" required="required" value=
										<c:choose>
								 			<c:when test = "${login != null}">
								 			${login}
											</c:when>
											<c:otherwise>
											''
											</c:otherwise>
										</c:choose>
									 id="Login" />
							</div>
						</div>
						<div class="field">
							<label>Password</label>
							<div class="input">
								<input type="password" name="Password"
									placeholder="min 8 symbols" required="required" value=
										<c:choose>
								 			<c:when test = "${password != null}">
								 			${password}
											</c:when>
											<c:otherwise>
											''
											</c:otherwise>
										</c:choose>
									id="Password" />
							</div>
						</div>


						<div class="field">
							<label>Re-type Password</label>
							<div class="input">
								<input type="password" name="Re_Password"
									placeholder="min 8 symbols" required="required" value=
										<c:choose>
								 			<c:when test = "${re_password != null}">
								 			${re_password}
											</c:when>
											<c:otherwise>
											''
											</c:otherwise>
										</c:choose>
									id="Re_Password" />
							</div>
						</div>

						<div class="field">
							<label>Name</label>
							<div class="input">
								<input type="text" name="Name" value=
									<c:choose>
								 		<c:when test = "${name != null}">
								 		${name}
										</c:when>
										<c:otherwise>
										''
										</c:otherwise>
									</c:choose>
								 id="Name" />
							</div>
						</div>


						<div class="field">
									<label>Region</label>
									<div class="input">
										<select name="Region" />
										<option value="DNR"
											<c:choose>
								 				<c:when test = "${region eq 'DNR'}">
								 				selected
												</c:when>
												<c:otherwise>
												""
												</c:otherwise>
											</c:choose>
											>DNR</option>
										<option value="LNR"
											<c:choose>
												 <c:when test = "${region eq 'LNR'}">
								 				selected
												</c:when>
												<c:otherwise>
												""
												</c:otherwise>
												</c:choose>
											>LNR</option>
										<option value="Crimea"
											<c:choose>
								 				<c:when test = "${region eq 'Crimea'}">
								 				selected
												</c:when>
												<c:otherwise>
												""
												</c:otherwise>
												</c:choose>
											>Crimea</option>
										</select>
									</div>
								</div>


						<div class="gender">
									<label>Gender</label>
									<div>
										<label id="gender"> Male <input type="radio"
											width="10px" name="Gender" value="true"
												<c:choose>
								 					<c:when test = "${gender == 'true'}">
								 					checked
													</c:when>
													<c:otherwise>
													""
													</c:otherwise>
												</c:choose>
											/>
										</label>
										 <label
											id="gender"> Female <input type="radio" name="Gender"
											value="false"
												<c:choose>
								 					<c:when test = "${gender == 'false'}">
									 				checked
													</c:when>
													<c:otherwise>
													""
													</c:otherwise>
												</c:choose>	
											 />
										</label>
									</div>
								</div>


								<div class="field">
									<label>Comment</label>
									<div class="input">
										<textarea name="Comment" cols="20" raws="10"
											value=
											
											<c:choose>
								 					<c:when test = "${comment != null}">
								 					${comment}
													</c:when>
													<c:otherwise>
													''
													</c:otherwise>
												</c:choose>
										> </textarea>
									</div>
								</div>

						<div class="submit">
							<button type="submit" value="Register" />
							Register
							</button>
							<label id="agree">I agree <input name="Agree" input
							 type="checkbox" 
							 	<c:choose>
									<c:when test = "${agree != null}">
									checked
									</c:when>
									<c:otherwise>
									''
									</c:otherwise>
								</c:choose>
							 /></label>
						</div>
					</table>
				</td>

				<td align=center>
				${error}</td>
			</tr>
		</table>
	</form>
</c:when>

<c:otherwise>
<h1 align = 'center'>You are registered </h1>
</c:otherwise>
</c:choose>

</body>
</html>

<%@ include file="/WEB-INF/include/Footer.jsp"%>