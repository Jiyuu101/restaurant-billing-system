<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	
	<div class="text-danger">${error_msg}</div>
	<form:form action="/restaurant_billing_system/addcategory" method="post" modelAttribute="menuItemType">
		
		<div class="mb-4">
			<form:label path='type' class="form-lable">Name</form:label>
			<div class="col-sm-5">
				<form:input type="text" class="form-control" path='type'></form:input>
			</div>
		</div>
		<form:errors path='type' cssClass='text-danger'></form:errors>
		
		<div class="mb-4">
			<form:label path='is_available' class="form-lable">Available</form:label>
			<div class="col-sm-5">
				<form:input type="boolean" class="form-control" path='is_available'></form:input>
			</div>
		</div>
		<form:errors path='is_available' cssClass='text-danger'></form:errors>
		
		<div class="mb-4">
			<input type="submit" value="AddCategory" class="btn btn-primary">

		</div>
		
	</form:form>
	</div>
</body>
</html>