<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>助教首页</title>
    
	<style type="text/css">
body{
}
.header{
height:70px;
width:atuo;
 background-color:lightblue;
 

     }
.navigation{
     height:atuo;
     width:atuo;
     margin-left:30px;
     }
 .navigation table td{
     width:90px;
     background-color:lightgreen;
     height:30px;
     }
.content{
position:absolute;
 width:700px;
 height:600px;
 background-color:pink;
 margin-left:30px;
 }
 
 
 .studentlist{
float:right;
 width:300px;
 height:600px;
 background-color:pink;


 }
 .main{
 width:1200px;
 margin-top:20px;}
 .headinfor{
float:right;
 right:11px;
 top:50px;
 margin-top:45px;
 margin-right:20px;
 }
 .headinfor  a{
  text-decoration:none;
  color:black;
 }
 .navigation a{
  text-decoration:none;
  color:black;
 }
 .search{
 float:right;
 margin-right:20px;}
</style>
</head>

<body>
  <div class="header">
    <div class="headinfor"> 
     ${userName }
    <a href="url">个人中心</a>
    <a href="url">退出</a>
    
    </div>
   </div>
      <div class="navigation"> 
        <table >
        <tr>
         <td><a href="managerPlatform.jsp">首页</a></td>
        
         <td>
         <a href="<s:url action="studentlist"/>"> 学生管理 </a>
         </td>
         
         <td><a href="url">留言板</a></td>
         
        </tr>
        <div class="search">
        <input></input><button class="searchbutton">搜索</button>
        
        </div>
        </table>
        </div>
  
  <div class="main">
   <div class="content">
   </div>
   <div class="studentlist">
   <p>学生列表</p>
   </div>
   </div>

</body>
</html>
