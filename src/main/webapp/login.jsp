<%-- 
    Document   : login
    Created on : 27 Mar 2023, 11:49:40 am
    Author     : Vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="main" method="POST">
            <table>
                <tr>
                    <td>login:</td>
                    <td> <input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>password :</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2">  <input name="action" value="authenticate" hidden>
            <button type="submit">Login</button>
           </td>
                    
                </tr>
            </table>
            
            <br> 
            <br> 
            
            
        </form>
    </body>
</html>
