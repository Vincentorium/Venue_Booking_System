<%-- 
    Document   : brands
    Created on : 27 Mar 2023, 2:07:06 pm
    Author     : Vincent
--%>

 

<%@page import="ict.bean.*,java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> <title>Phone List</title> </head>
    <body>  
   
     
     <jsp:useBean id="phoneList" scope="request" class="java.util.ArrayList<ict.bean.Phone>" />
        
        <%
        
    
          out.println("<table border='1'>");
          
           for(int i =0; i<phoneList.size(); i++){
            
             Phone b = phoneList.get(i);
             
             
    
             out.println("<tr><td>"+b.getName()+  "</td>");
             out.println("<td>"+b.getImg()+  "</td>");
             out.println("<td>"+b.getPrice()+  "</td></tr>");
            
            }
        
          out.println("</table");
        
        %>
        
        <hr/>
        <a href="brandController?action=list" >Show Brands </a> <br>
        
    </a>
    </body>
</html>
