<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <style type="text/css">
   div
{
height:200;
width:400;
position: absolute;
top:50%;
left: 50%;
margin-top: -100px;
margin-left: -130px;
}
   </style>

  </head>
  
  <body>
  <div>
   SUCCESSFULLY CHANGED YOUR PASSWORD <br>
   </div>
  </body>
</html>
