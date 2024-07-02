<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="admin_display.jsp"></jsp:include>

		<div class="container">
		<a href="/restaurant_billing_system/addmenu">Create New</a>
		<div class="row">
			<div class="col">Name</div>
            <div class="col">Description</div>
            <div class="col">Price</div>
            <div class="col">Category</div>
			
		</div>
		<c:forEach var="menuItem" items="${menuItems}">
			<div class="row">
			
			<div class="col">${menuItem.name}</div>
			<div class="col">${menuItem.description}</div>
			<div class="col">${menuItem.price}</div>
			<div class="col">${menuItem.menu_item_type_name}</div>
			
			<div class="col">
				<a href="editmenu/${menuItem.id}">Edit</a>|
				<a href="deletemenu/${menuItem.id}">Delete</a>
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>