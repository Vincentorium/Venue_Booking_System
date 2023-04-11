<%-- 
    Document   : brands
    Created on : 27 Mar 2023, 2:07:06 pm
    Author     : Vincent
--%>


<%@page import="ict.bean.*,java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All brands</title>
    </head>
    <body>
        <jsp:useBean id="brands" scope="request" class="java.util.ArrayList<ict.bean.Brand>" />
        
        <%
        
           for(int i =0; i<brands.size(); i++){
            
             Brand b = brands.get(i);
             out.println("<a href=\"getPhones?action=list&brand=" + b.getName()
             + "\">" + b.getName()+"</a><br/>");
            
            }
        
        
        %>
        
        <hr/>
        <a href="brandForm.jsp" >Create Brand </a> <br>
        
   
        
    </body>
</html>
