<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>注册</title>

	<link rel="stylesheet" type="text/css" href="css/yezi.css" />

  </head>
  
  <body>
  <div class="box">
  
  <div class="header">
 
  </div>
  
  <div class="main">
  <table>
  
  <s:form action="register" method="post">
   <tr><td>用户名：</td><td><s:textfield name="userName"></s:textfield>${errors.userNamereg[0]}</td></tr>

    <tr><td> 密码：</td><td><s:password name="password1"></s:password>${errors.password1reg[0]}</td></tr>
    <tr><td>确认密码：</td><td><s:password name="password2"></s:password>${errors.password2reg[0]}</td></tr>
    <tr><td> 邮箱：</td><td><s:textfield name="email"></s:textfield>${errors.emailreg[0]}</td></tr>
    <tr><td>真实姓名：</td><td><s:textfield name="realName"></s:textfield>${errors.realNamereg[0]}</td></tr>
    <tr><td>工号：</td><td><s:textfield name="studentId"></s:textfield>${errors.studentIdreg[0]}</td></tr>
    <tr><td>验证码：</td><td><img src="checkCode.jsp"></td></tr>
    <tr><td>输入验证码：</td><td><s:textfield name="code"></s:textfield>${errors.codereg[0]}</td></tr>
    <tr><td><s:submit value="提交"></s:submit></td><td><s:reset value="重置"></s:reset></td></tr>
  </s:form>
  </table>
  </div>
  
  
  <div class="footer">
  </div>
  
  </div>
  </body>
</html>
