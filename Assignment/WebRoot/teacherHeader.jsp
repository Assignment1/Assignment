<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title></title>
    
	
	<link rel="stylesheet" type="text/css" href="css/index.css">

  </head>
  
  <body>
    <div class="header">
    <div class="headinfor"> 
     <s:property value="#session.user"/>
    <a href="url">个人中心</a>
    <a href="url">退出</a>
    
    </div>
   </div>
      <div class="navigation"> 
        <table >
        <tr>
         <td><a href="">首页</a></td>
         <td><a href="teacherAssignemt.jsp">作业管理</a></td>
         <td><a href="managerList.action">助教管理</a></td >
         <td><a href="url">留言板</a></td>
        <td><input type="text"></td>
        
        </table>
        </div>
  </body>
</html>
