<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="image/jpeg" import="com.controller.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'checkCode.jsp' starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);

RandImgCreater rc = new RandImgCreater(response);
String rand = rc.createRandImage();
session.setAttribute("rand",rand);
out.clear();  
out=pageContext.pushBody(); 
%>
  </body>
</html>
