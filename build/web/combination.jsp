<%-- 
    Document   : combination
    Created on : 12 Jul, 2018, 10:28:48 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form class="container" style="margin-top: 100px;" action="testing">
            <img src="lucene.png" style="margin-left: 300px; margin-top: 0px;" class="img-rounded" alt="Cinque Terre">
            <div class="form-group" style="margin-left:270px;margin-right: 200px;margin-top: 5px;">
<!--      <label  style="margin-left: 100px;margin-top: 50px;">Exception:</label>-->
      <div >
          <input type="text" style="margin-left:90px;height:30px;width:70%;" class="form-control" id="email" placeholder="Enter time1(dd-mm-yyyyhh:mm:ss)" name="time1">
      </div>       <br>    
<div>
    <input type="text" style="margin-left:90px;height:30px;width:70%;" class="form-control" id="email" placeholder="Enter time2(dd-mm-yyyyhh:mm:ss)" name="time2">
</div>            <br>
<div>
        <input type="text" style="margin-left:90px;height:30px;width:70%;" class="form-control" id="email" placeholder="Enter data(*optional)" name="exception">
</div></div>
<div class="btn-group" style="margin-left: 350px;margin-top: 50px;">

        <button type="submit" name="btn" value="5" class="btn btn-default">Between Timestamp</button>
  

        <button type="submit" name="btn" value="6" class="btn btn-default">Exception and timestamp</button>
    

        <button type="submit" name="btn" value="7" class="btn btn-default">Id and Timestamp</button>
   

        <button type="submit" name="btn" value="8" class="btn btn-default">Error and timestamp</button>
        
        <button type="submit" name="btn" value="9" class="btn btn-default">Group by Exception</button>
        
</div></div>
            
        </form>
    </body>
</html>
