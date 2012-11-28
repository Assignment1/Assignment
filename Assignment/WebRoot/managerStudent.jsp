<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

	  <link rel="stylesheet" type="text/css" href="css/studentManage.css" />

<script language="javascript" type="text/javascript">

function nonveStudentOP(operation){

   var objs = document.getElementsByName('nonvestudentValue');
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
             nonveStudent.action="nonvestudentOP.action?operation=1";
          }
      }
      else
      { 
          var c2 = confirm("确定所选拒绝申请吗？");
          if(c2==true)
          {
             nonveStudent.action="nonvestudentOP.action?operation=2";
          }
      }
      nonveStudent.submit();
   }
}


function veStudentOP(operation){
   var objs = document.getElementsByName('vestudentValue');
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
             veStudent.action="vestudentOP.action?operation=1";
          }
      }
      else
      { 
          var c2 = confirm("确定所选删除助教吗？");
          if(c2==true)
          {
             veStudent.action="vestudentOP.action?operation=2";
          }
      }
      veStudent.submit();
   }
}

</script>
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
        <td><a href="<s:url action="studentlist"/>">学生管理</a></td>
        <td><a href="url">留言板</a>
        </td>
       </tr>
        <div class="search">
        <input></input><button class="searchbutton">搜索</button>
        </div>
        </table>
        </div>
        
 <div class="notConfrimedStu">
  <s:form method="post" name="nonveStudent">
   <p>未通过验证的学生 </p>
  <table>
     <tr>
   <td>
   <input type="button" value="通过验证" onclick="nonveStudentOP(1)"></td>
   <td>
   <input type="button" value="拒绝申请" onclick="nonveStudentOP(2)">
   </td>
   </tr>
   <s:iterator value="nonveList" var="studentBean">
   <tr>
      <td><s:checkbox name="nonvestudentValue" fieldValue="%{#studentBean.Id}"></s:checkbox>
      <td><s:property value="%{#studentBean.userName}"/></td>
      <td><s:property value="%{#studentBean.realName}"/></td>
      
  </tr>
 
   </s:iterator>
  
   </table>
   </s:form>
    </div>
        
        
        
        <div class="confrimedStu">
             <s:form method="post" name="veStudent">
             <p>通过验证的学生 </p>
             <table>
              <tr>
   <td>
   <input type="button" value="取消验证" onclick="veStudentOP(1)"></td>
   <td>
   <input type="button" value="删除学生" onclick="veStudentOP(2)">
   </td>
   </tr>
  <s:iterator value="veList" var="studentBean">
   <tr>
      <td><s:checkbox name="vestudentValue" fieldValue="%{#studentBean.Id}"></s:checkbox>
      <td><s:property value="%{#studentBean.userName}"/></td>
      <td><s:property value="%{#studentBean.realName}"/></td>

    </tr>
   </s:iterator>
   
   </s:form>
   </table></div>
  </body>
</html>
