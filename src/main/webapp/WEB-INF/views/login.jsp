<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Billing System</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
 	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h1>Welcome!</h1>
            <p>Please check your data again.</p>
          </div>
        </div>
        <form:form action="createlogin" method="post"  modelAttribute="login">
          <form:input type="text" placeholder="User Email" path="email"/>
          <form:input type="password" placeholder="Password" path="password"/>
          <button>login</button>
          
        </form:form>
      </div>
    </div>
        
</body>
</html>