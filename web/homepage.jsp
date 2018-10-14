<%-- 
    Document   : homepage
    Created on : 10 Jul, 2018, 6:46:40 PM
    Author     : Administrator
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="jquery/dataTables.bootstrap.min.css" />
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"/>
        
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
       <h3> LogFile Information </h3>
      <%  ArrayList itemsArray = (ArrayList) request.getAttribute("data");
      String Group=request.getAttribute("group").toString();
            if(itemsArray.size()<1){ out.println("nothing found");}%>
            <%if(itemsArray.size()>1){%> <%if(Group=="1"){%><a href="index2.jsp">Do you want to stack Trace</a><%}%>
       <table id="mytable" class="table table-striped" >
         <thead> <tr> <th>date </th>
           <th>Time</th>
           <th>Error</th>
           <th>Logid</th>
           <th>Exception</th>
           <%if(Group=="1"){%><th>Count</th><%}%>
             </tr></thead> <tbody>
<%
   
   if (request.getAttribute("data") != null) {
	   
	    for (int i=0; i < itemsArray.size(); i++) {
                %><tr><td><% out.println(itemsArray.get(i)); %></td>
               <td><% out.println(itemsArray.get(++i)); %></td>
               <td><% out.println(itemsArray.get(++i)); %></td>
               <td><% out.println(itemsArray.get(++i)); %></td>
               <td><% out.println(itemsArray.get(++i)); %></td>
         <%if(Group=="1"){%><td><a href="index2.jsp" name="btn"><% out.println(itemsArray.get(++i)); %></a></td><%}%>
              
               <%
	    }
   }
               %></tbody></table>
              <% }%></div>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
      $(document).ready(function() {
          $('#mytable').dataTable({"aaSorting": [],searching: false});
        $('#mytable').DataTable();
      });
    </script>
    
</html>
