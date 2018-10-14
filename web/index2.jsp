<%-- 
    Document   : index2
    Created on : 12 Jul, 2018, 2:12:37 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
          <title>Lucene Search</title>
    </head>
    <body>
        <form class="container" style="margin-top: 100px;" action="testing">
            <img src="lucene.png" style="margin-left: 300px; margin-top: 0px;" class="img-rounded" alt="Cinque Terre">
            <div class="form-group" style="margin-left:270px;margin-right: 200px;margin-top: 20px;">
<!--      <label  style="margin-left: 100px;margin-top: 50px;">Exception:</label>-->
      <div >
          <input type="text" style="margin-left:90px;height:30px;width:70%;" class="form-control" id="email" placeholder="Enter Exception" name="exception">
      </div>       <br>    
<div>
    <input type="text" style="margin-left:90px;height:30px;width:70%;" class="form-control" id="email" placeholder="Enter N of the exception" name="position">
</div>            <br>
</div>
<div class="btn-group" style="margin-left: 350px;margin-top: 0px;">

        <button type="submit" name="btn" value="10" class="btn btn-default">Trace</button> 
</div></div>
            
        </form>
    </body>
</html>
