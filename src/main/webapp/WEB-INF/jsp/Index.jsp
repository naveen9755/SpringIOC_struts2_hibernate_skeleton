<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User management</title>
</head>
<body>

	<h2>Add a user</h2>

	<s:form action="addUser" namespace="/">
		<s:textfield label="First name" name="firstName" />
		<s:textfield label="Last name" name="lastName" />
		<s:submit type="button" label="Add user" />
	</s:form>

	<h2>List of users</h2>
	
	<table border="1">
		<tr>
			<th>User id</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Delete user</th>
		</tr>
		<s:iterator value="usersList">
			<tr>
				<td><s:property value="userId" /></td>
				<td><s:property value="firstName" /></td>
				<td><s:property value="lastname" /></td>
				<td><a href="deleteUser?userId=<s:property value="userId" />">delete</a></td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>