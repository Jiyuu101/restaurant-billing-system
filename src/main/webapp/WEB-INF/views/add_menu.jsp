<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div class="container">
	
		
	<form:form action="/restaurant_billing_system/addmenu" method="post" modelAttribute="menuItem">
		
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
				<form:select path='menu_item_type_id' >
					<form:option value='0'>Select Category</form:option>
					<c:forEach var='menuItemType' items='${selected_categories}'>
						<form:option value='${menuItemType.id}'>${menuItemType.type}</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<form:errors path='menu_item_type_id' cssClass='text-danger'></form:errors>
		
		<div class="mb-4">
			<input type="submit" value="AddMenu" class="btn btn-primary">

		</div>
		
	</form:form>
	</div>
</body>
</html>