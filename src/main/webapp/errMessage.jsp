 
<%

String type=(request.getAttribute("imageFileName")).toString();
    String url=(request.getAttribute("url")).toString();

%>
<h1><%= type %> </h1>
<a href=<%= url %>>Try again !!!</a>
