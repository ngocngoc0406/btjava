<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Echoing HTML Request Parameters</title>
</head>
<body>
     <h3>Choose an author:</h3> 
     <form method="GET">
       <input type="checkbox" name="author" value="Tan Ah Teck Nguyen">Tan Nguyen 
       <input type="checkbox" name="author" value="Mohd Ali Hoag">Ali Hoang
       <input type="checkbox" name="author" value="Kumar Van">Kumar Van
       <input type="submit" value="Query">
     </form>
     <%
       String[]authors = request.getParameterValues("author"); 
       if(authors != null) {
     %>  
     <h3>You have selected author(s):</h3> 
     <ul>
       <%
         for (int i = 0; i < authors.length; ++i) {
       %>
       <li><%= authors[i]%></li>
         <% 
           } 
         %>
     </ul>
     <a href="<%= request.getRequestURI()%>">BACK</a>
     <% 
        } 
     %>
</body>
</html>