<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Using Form</title>
</head>
<body>
	<h1>Using Form</h1>
	<%
	String firstName = request.getParameter("txtFName");
	String lastName = request.getParameter("txtLName");
	String email = request.getParameter("txtEmail");
	String gender = request.getParameter("gender");
	String dob = request.getParameter("txtDob");
	%>
	<table border="1">
		<tbody>
			<tr>
				<td>First Name:</td>
				<td><%=firstName%></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><%=lastName%></td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td><%=email%></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><%=gender%></td>
			</tr>
			<tr>
				<td>Date of birth:</td>
				<td><%=dob%></td>
			</tr>
		</tbody>
	</table>
</body>
</html>