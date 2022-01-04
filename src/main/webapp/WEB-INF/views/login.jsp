<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
 	<meta name="viewport"	content="width=device-width, initial-scale=1, shrink-to-fit=no">
   
    <meta name="description" content="boot app">
    <meta name="author" content="sushil kumar bhaskar jsr.101.v1">

    <title>Log in Boot with your credentials</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 4px solid #00c853; padding: 10px;}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 15px;
}

span.psw {
    float: left;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
    
   
}
</style>
</head>

<body>

<div class="container">
    <h2 class="form-heading"><span style="color: #FF8800; font-size: 22px; text-align: right;" >Powered By</span> <span style="color:#6db33f;">Boot</span><span class="glyphicon glyphicon-leaf" style="color:#6db33f;"></span>&nbsp;<sup><small><span class="label label-success">JSR101-1.8.5.RELEASE</span></small></sup></h2>
    <form method="POST" action="${contextPath}/login" class="form-signin">
     <sec:csrfInput /> 
     <div class="imgcontainer">
    <img src="images/banner.gif" style="height:120px; width:150px;" alt="Avatar" class="avatar">
  	</div>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span  style="color:#00C851;">${msg}<br></span>
            <label for="uname"><b>Username</b></label>
            <input name="username" type="text" class="form-control" placeholder="Username"  autofocus="autofocus"  required="required"/>
            <label for="psw"><b>Password</b></label>
            <input name="password" type="password" class="form-control" placeholder="Password" required="required"/>
            <span  style="color:#ff4444;">${errorMsg}<br></span>

            <label>
      			<input type="checkbox" checked="checked" name="remember-me" id="remember-me">  Stay Signed In/Remember Me
    		</label>
            <button class="btn btn-lg btn-success btn-block" type="submit">Log In</button><br>
            <span class="psw"><a href="#">Forgot the password?</a></span>
        </div>

    </form>
  <%--  <input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}"/> --%>
     

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<jsp:include page="footer.jsp" />	
</body>
</html>
