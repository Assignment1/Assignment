<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>助教管理</title>
    
	
	<link rel="stylesheet" type="text/css" href="css/index.css">
<script language="javascript" type="text/javascript">

function nonveManagerOP(operation){
   var objs = document.getElementsByName('nonvemanagerValue');
   var isSelect = false;
   for(var i=0;i<objs.length;i++)
   {
      if(objs[i].checked==true)
      {
          isSelect = true;
          break;
      }
   }
   if(isSelect==false)
   {
   alert("选中项不能为空");
   }
   else{
      if(operation==1)
      {
          var c1 = confirm("确定所选通过验证吗？");
          if(c1==true)
          {
             nonveManager.action="nonvemanagerOP.action?operation=1";
          }
      }
      else
      { 
          var c2 = confirm("确定所选拒绝申请吗？");
          if(c2==true)
          {
             nonveManager.action="nonvemanagerOP.action?operation=2";
          }
      }
      nonveManager.submit();
   }
}

function veManagerOP(operation){
   var objs = document.getElementsByName('vemanagerValue');
   var isSelect = false;
   for(var i=0;i<objs.length;i++)
   {
      if(objs[i].checked==true)
      {
          isSelect = true;
          break;
      }
   }
   if(isSelect==false)
   {
   alert("选中项不能为空");
   }
   else{
      if(operation==1)
      {
          var c1 = confirm("确定所选取消验证吗？");
          if(c1==true)
          {
             veManager.action="vemanagerOP.action?operation=1";
          }
      }
      else
      { 
          var c2 = confirm("确定所选删除助教吗？");
          if(c2==true)
          {
             veManager.action="vemanagerOP.action?operation=2";
          }
      }
      veManager.submit();
   }
}

</script>

  </head>
  
  <body>
    <div> 
      <s:include value="teacherHeader.jsp"></s:include> 
       </div>
  
  <div class="main">
   <div class="content"> 
    
   <table>
   <s:form method="post" name="nonveManager">
   <tr>
   <td><input type="button" value="通过验证" onclick="nonveManagerOP(1)"><input type="button" value="拒绝申请" onclick="nonveManagerOP(2)")></td>
   </tr>
   <s:iterator value="nonveList" var="managerBean">
   <tr>
      <td><s:checkbox name="nonvemanagerValue" fieldValue="%{#managerBean.Id}"></s:checkbox>
      <td><s:property value="%{#managerBean.userName}"/></td>
      <td><s:property value="%{#managerBean.realName}"/></td>
      <td><s:property value="%{#managerBean.email}"/></td>
      <td><s:property value="%{#managerBean.studentId}"/></td>
      <td>
   </tr>
   </s:iterator>
   
   
   </s:form>
   
   <s:form method="post" name="veManager">
   <tr>
   <td><input type="button" value="取消验证" onclick="veManagerOP(1)"><input type="button" value="删除助教" onclick="veManagerOP(2)"></td>
   </tr>
   <s:iterator value="veList" var="managerBean">
   <tr>
      <td><s:checkbox name="vemanagerValue" fieldValue="%{#managerBean.Id}"></s:checkbox>
      <td><s:property value="%{#managerBean.userName}"/></td>
      <td><s:property value="%{#managerBean.realName}"/></td>
      <td><s:property value="%{#managerBean.email}"/></td>
      <td><s:property value="%{#managerBean.studentId}"/></td>
      <td>
   </tr>
   </s:iterator>
   </s:form>

   </table>
   
 </div>
   <div class="studentlist">
   <p>学生列表</p>
   </div>
   </div>
  </body>
</html>
