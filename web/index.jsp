<%-- 
    Document   : index
    Created on : 10 Jul, 2018, 3:17:01 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
          <title>Lucene Search</title>
    </head>
    <body>
        <form class="container" style="margin-top: 100px;" action="testing">
            <img src="lucene.png" style="margin-left: 250px; margin-top: 0px;" class="img-rounded" alt="Cinque Terre">
            <div class="form-group">
<!--      <label  style="margin-left: 100px;margin-top: 50px;">Exception:</label>-->
      <div  style="margin-left:270px;margin-right: 200px;margin-top: 80px;">
          <input type="text" class="form-control" id="email" placeholder="Enter data" name="exception" required>
      </div>
<div class="btn-group" style="margin-left: 300px;margin-top: 50px;">

        <button type="submit" name="btn" value="1" class="btn btn-default">By logid</button>
  

        <button type="submit" name="btn" value="2" class="btn btn-default">By Exception</button>
    

        <button type="submit" name="btn" value="3" class="btn btn-default">By date</button>
   

        <button type="submit" name="btn" value="4" class="btn btn-default">By Error</button>
        
</div></div>
            
        </form>
    </body>
</html>
