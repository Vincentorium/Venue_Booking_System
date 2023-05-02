<%-- 
    Document   : loginError
    Created on : 27 Mar 2023, 12:04:12 pm
    Author     : Vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login error</title>
    </head>
    <body>
        <p>Incorrect Password</p>
        <p>
            <% out.println("<a href='login.jsp' >Login again</a>"); %>
        </p>
        <p>
            <% out.println("<a href='signup.jsp' >Sign Up</a>"); %>
        </p>
        <p>
            <% out.println("<a href='mainPage.jsp' >Go to Main Page</a>"); %>
        </p>

    </body>
</html>