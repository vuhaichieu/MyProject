<%-- 
    Document   : Login
    Created on : Nov 7, 2022, 10:05:57 AM
    Author     : vuhai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginController" method="post">
        username: <input type="text" name="username"/><br>
        password: <input type="text" name="password"/><br>
        save in session:  <input  type="checkbox" name="remember" /><br>
        <input type="submit" value="login"/>
        </form>
        <c:if test="${sessionScope.accounts eq null}">
            ${messages}
        </c:if><br>
        ${message}
    </body>
</html>
