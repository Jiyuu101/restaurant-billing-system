<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
     <style>
        body {
            background-color: cadetblue;
        }

        .content {
            background-color: white;
            width: 400px;
            margin: auto;
            margin-top: 100px;
            border-radius: 8px;
        }

        .title {
            font-size: 30px;
            color: cadetblue;
            text-align: center;
            padding-top: 30px;
            padding-bottom: 20px;
            
        }

        label {
            display: block;
            margin: 0px 20px;
            margin-top: 20px;
            margin-bottom: 5px ;
        }

        .user-input{
            width: 80%;
            padding: 10px 15px;
            margin: 0px 20px;
            border: 1px solid cadetblue;
            border-radius: 5px;
        }

        .register-btn {
            width: 89%;
            margin: 0px 20px;
            border: none;
            background-color: cadetblue;
            color: white;
            padding: 10px 15px;
            margin-top: 15px;
            border-radius: 5px;
        }
        
         .footer-text {
            text-align: center;
            padding: 20px 20px ;
        }
         
    </style>
</head>
<body>
	<div class="content">
		<div class="title">WELCOME</div>
   		<form:form method="POST" action="login" modelAttribute="loginBean">
   	 	<div class="input-group">
            <form:label path="email">Email:</form:label>
        	<form:input class="user-input" path="email" id="email" />
        </div>
        
        <br>
        
        <div class="input-group">
            <form:label path="password">Password:</form:label>
        	<form:password class="user-input" path="password" id="password" />
        </div>
        
        <br>
        
        <div class="button-group">
            <button class="register-btn" type="submit">Login</button>
        </div>
        
        <div class="footer-text">
            Please check your email and password carefully! 
        </div>
        
    </form:form>
    
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
	</div>

</body>
</html>
