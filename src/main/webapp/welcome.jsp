<%-- 
    Document   : welcome
    Created on : 27 Mar 2023, 12:16:29 pm
    Author     : Vincent
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
 
        
        
        
         <jsp:useBean id="test" class="ict.bean.UserInfo" scope="session" />
      
      
         <jsp.getProperty name="userInfo" property="username" />
        <b> Hello ,</b>
        <p>Welcome to the ICT</p>

        <form method="post" action="main">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="logout" name="logoutButton">
        </form>
        <hr />
        <a href="brandController?action=list">getAllBrands</a><br/>
    </body>
</html>
