<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="/doLogin" method="post">
    <p>
        <label for="login">Username</label>
        <input type="text" id="login" name="login"/>
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>
    </p>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <button type="submit" class="btn">Log in</button>
</form>


</body>
</html>
