<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Goal</title>

<style>
<!--  an error and errorblock class  that the error forms are gonna use 
	it s a standard error output, we can tweak it, or put it in a global CSS that you 
	can import, doesn t have to be defined per page 
-->
.error {
	color: #ff0000;
}
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>

	<form:form commandName="goal">
	<!-- Putting an * in the path value , means I want any error to trigger the error display -->
	<!-- The cssClass = "errorblock" is the class that we defined above -->
	<!-- The error for minutes appear here in errorblock cssClass style cause we set it to trigger for all error -->
	<form:errors path="*" cssClass="errorblock" element="div" />

		<table>
			<tr>

				<td>Enter Minutes</td>
<!-- There is an variable inside of goal named minutes, it has get/setters for it -->
				<!-- The input tag has also is own error class -->
				<td><form:input path="minutes" cssErrorClass="error"/></td>
				<!-- So this is an error form for minutes, under the annotation range and inside of Goal
				so in the messages.properties we can set a message in Range.goal.minutes= Our message -->
				<!-- The error apper in error cssClass style --> 
				<td><form:errors path="minutes" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit"
					value="Enter Goal Minutes" /></td>
			</tr>

		</table>
	</form:form>

</body>
</html>