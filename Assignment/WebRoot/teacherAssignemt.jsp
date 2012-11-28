<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>作业管理</title>

	<link rel="stylesheet" type="text/css" href="css/index.css" />

  </head>
  
  <body>
  <div>
      <s:include value="teacherHeader.jsp"></s:include> 
       </div>
  
  <div class="main">
  
   <div class="content">
   
    <table>
  
  <s:form action="sethmwk" method="post">
   <tr><td>作业名：</td><td><s:textfield name="Name"></s:textfield>${errors.Name[0]}</td></tr>

    <tr><td> 开始时间：</td><td><s:textfield name="Start"></s:textfield>${errors.Start[0]}</td></tr>
    <tr><td>结束时间：</td><td><s:textfield name="End"></s:textfield>${errors.End[0]}</td></tr>
    <tr><td> 作业号：</td><td><s:textfield name="Submitcount"></s:textfield>${errors.Submitcount[0]}</td></tr>
    <tr><td>作业：</td><td><s:textfield name="hmwk"></s:textfield>${errors.hmwk[0]}</td></tr>
    <tr><td><s:submit value="提交"></s:submit></td><td><s:reset value="重置"></s:reset></td></tr>
  </s:form>
  </table>
   
   </div>
   
   <div class="studentlist">
   <p>学生列表</p>
   </div>
   
   </div>
 

  </body>
</html>
