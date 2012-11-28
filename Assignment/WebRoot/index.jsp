<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <link rel="stylesheet" type="text/css" href="css/yezi.css" />
    <title>登录</title>
	
  </head>
  
  <body>
   <div class="box">
  
  <div class="header">
 
  </div>
  
  <div class="main">
  <table>
     <s:form action="login" method="post">
     <tr><td>用户名：</td><td><s:textfield name="userName"></s:textfield>${errors.userName[0]}</td></tr>
    <tr><td>密码：</td><td><s:password name="password"></s:password>${errors.password[0]}</td></tr>
    <tr><td>验证码：</td><td><img src="checkCode.jsp"></td></tr>
    <tr><td>输入验证码：</td><td><s:textfield name="code"></s:textfield>${errors.codereg[0]}</td></tr>
    <tr><td><s:submit value="登入"></s:submit></td></tr>
     </s:form>
 </table>
 <a href="regiset.jsp">注册</a>
  </div>
  
  
  <div class="footer">
  </div>
  
  </div>
  </body>
</html>
