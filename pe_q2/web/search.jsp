<%-- 
    Document   : search
    Created on : Oct 31, 2022, 9:06:49 PM
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
        <form action="search" method="post">
            Name <input type="text" name="name"> <input type="submit" value="Search" name="search">
        </form>
       
        <c:if test= "${students!=null}" >
            <div>
                <table >
                    <thead>
                        <tr>
                            <th>sid</th>
                            <th>name</th>
                            <th>gender</th>
                            <th>dob</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${students}" var="s">
                            <tr>
                                <td>${s.stuid}</td>
                                <td>${s.stuname}</td>
                                <td>${s.stugender}</td>
                                <td>${s.studob}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
    </c:if>
    </body>
</html>
