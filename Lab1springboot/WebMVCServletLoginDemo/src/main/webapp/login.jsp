<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Login Page</title>
   <link href="main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
   <h1>Login to the FPT System</h1> 
   <%
        String err = request.getParameter("err");
        if("1".equals(err)){
        	 out.print("<h4 style=\"color: red;\">Login Fail</h4>");
        } 
   %>
   <form name="myForm" action="LoginController" method="POST"> 
      <table border="0">
      <tbody> 
         <tr>
             <td>User Name: </td>
             <td><input type="text" name="username" value="" size="50"/></td>
         </tr> 
         <tr>
             <td>Password: </td>
             <td><input type="text" name="password" value="" size="50"/></td>
         </tr>
       </tbody> 
       </table>
       <hr>
       <input type="submit" value="Login" name="submit"/>
    </form>
</body>
</html>