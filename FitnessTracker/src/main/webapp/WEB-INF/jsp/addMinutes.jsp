<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Minutes Page</title>
<!-- here the line where we add JQuery  -->
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<!-- Let's do some Jquery 
$(document).ready() means that when the doc is ready, the dom available, fire  this.
Our function gonna build our options for us on the fly 
data, is the data that comme back from the above line.
$('#activities').html(html);   : #activities is the element created down below with the id="activities"
the .html(html) select the element out of the dom and say replace the html you had with this html i'm gonna give you right now.
$.getJSON('http://localhost:9999/FitnesTracker/activities.json', { : we don't want hardcode url in our .jsp espacially the parts
with localhos:9999 on it so we replace it with a spring:url tag  '<spring:url value="activities.json"/>' 
 -->
<script type="text/javascript">
	$(document).ready(
		function() {
			$.getJSON('<spring:url value="activities.json"/>', {
				ajax :'true'
			}, function(data){
				var html = '<option value="">--Please select one--</option>';
				var len= data.length;
				for (var i = 0; i < len; i++){
					html += '<option value="'  + data[i].desc + '">'
					+ data[i].desc + '</option>';
				}
				html += '</option>';
				
				$('#activities').html(html);
			});
			
	});

</script>
</head>
<body>
<h1>Add Minutes Exercised</h1>

Language : <a href="?language=en">English</a> | <a href="?language=es">Spanish</a>
<form:form commandName="exercise">
	<table>
	<tr>
	<!-- exemple of String externalisation to avoid hardcoding string the app -->
		<td><spring:message code="goal.text" /></td>
		<td><form:input path="minutes"/></td>
		<!--  Remember we have commandName= "exercise" above that refer to the object Exercise in our model
		and now we have path="activity" nested below so the Exercise object must have a attribute activity with is get/setter ready and defined
		 -->
		<td>
			<form:select id="activities" path="activity"></form:select>
		</td>
	</tr>	
	<tr>
		<td colspan="3">
			<input type="submit" value="Enter Exercise">
			</td>
	</tr>
	</table>
</form:form>
<h1>Our goal for the day is: ${goal.minutes}</h1>

</body>
</html>