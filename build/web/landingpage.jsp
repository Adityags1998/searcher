<%-- 
    Document   : landingpage
    Created on : 12 Jul, 2018, 10:01:49 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="container">
  <div class="jumbotron">
    <h2>Search By Individual</h2> 
    <p>Possible Searches are Search by Exception,date,errors,logid</p> 
    <a href="index.jsp"><Button type="submit" class="btn-btn-default">Go Search</button></a>
  </div>           
</div>
        <div class="container">
  <div class="jumbotron">
    <h2>Search by Combinations</h2> 
    <p>Possible searches are Search between timestamp,exception and timestamp,id and timestamp,error and id,Group by exception</p> 
    <a href="combination.jsp"><Button type="submit" class="btn-btn-default">Go Search</button></a>
  </div>   
</div>
        <div class="container">
  <div class="jumbotron">
    <h2>Stack trace</h2> 
    <p>Possible searches is Tracing the stack by exception and its N'th position</p> 
    <a href="index2.jsp"><Button type="submit" value="9" name="btn" class="btn-btn-default">Stack trace</button></a>
  </div>
 </div>
    </body>
</html>
