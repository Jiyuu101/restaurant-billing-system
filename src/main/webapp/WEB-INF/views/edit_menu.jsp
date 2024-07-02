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
	
		<h4>Update Category Info</h4>
		
	<form:form action="/restaurant_billing_system/editmenu" method="post" modelAttribute="menuItem">
		
		<div>
			<form:input type="hidden" class="form-control" path='id'></form:input>
		</div>
		
		<div class="mb-4">
			<form:label path='name' class="form-lable">Name</form:label>
			<div class="col-sm-5">
				<form:input type="text" class="form-control" path='name'></form:input>
			</div>
		</div>
		<form:errors path='name' cssClass='text-danger'></form:errors>
		
		<div class="mb-4">
			<form:label path='description' class="form-lable">Description</form:label>
			<div class="col-sm-5">
				<form:input type="text" class="form-control" path='description'></form:input>
			</div>
		</div>
		<form:errors path='description' cssClass='text-danger'></form:errors>
		
		<div class="mb-4">
			<form:label path='price' class="form-lable">Price</form:label>
			<div class="col-sm-5">
				<form:input type="text" class="form-control" path='price'></form:input>
			</div>
		</div>
		<form:errors path='price' cssClass='text-danger'></form:errors>
		
		<div class="mb-4">
			<form:label path='menu_item_type_id' class="form-lable">Category</form:label>
			<div class="col-sm-5">
				<form:input type="text" class="form-control" path='menu_item_type_id'></form:input>
			</div>
		</div>
		<form:errors path='menu_item_type_id' cssClass='text-danger'></form:errors>
		
		<div class="mb-4">
			<input type="submit" value="EditMenu" class="btn btn-primary">

		</div>
		
	</form:form>
	</div>
</body>
</html>