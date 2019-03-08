<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="com.blue.util.Util" %>
  <%@ page import="java.sql.Connection" %>
  <%@ page import="com.blue.dao.Dao" %>
  <%@ page import="java.util.*" %>
  <%@ page import="com.blue.bean.Bean_admin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />

<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
</style>
</head>
<body>
<!--main_top-->

<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：用户管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="./selcetinfo">
	         <span>管理员：</span>
	         <input type="text" name="text_name" value="" class="text-word">
	         <input name="select_id" type="submit" value="查询" class="text-but">
	         </form>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="/BlueSystem/main_info.jsp" target="mainFrame" onFocus="this.blur()" class="add">新增管理员</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">系统编号</th>
        <th align="center" valign="middle" class="borderright">用户帐号</th>
        <th align="center" valign="middle" class="borderright">登录密码</th>
        <th align="center" valign="middle" class="borderright">管理权限</th>
        <th align="center" valign="middle" class="borderright">家庭地址</th>
         <th align="center" valign="middle" class="borderright">联系电话</th>
        <th align="center" valign="middle"  class="borderright">薪资水平（月）</th>
        <th align="center" valign="middle"  class="borderright">操作信息</th>
      </tr>
  
      
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
          
      <%
	Util u=new Util();
Connection conn=u.getConn();
	Dao dao=new Dao(conn);
	ArrayList al=dao.Select_admin();

	for(int i=0;i<al.size();i++){
		Bean_admin ba=(Bean_admin)al.get(i);
		long id=ba.getId();
		String name=ba.getName();
		String pass=ba.getPassword();
		String	quanx=ba.getQuanx();
		String address=ba.getAddress();
		String tel=ba.getTel();
		long sel=ba.getSel();
		%>
		 <td align="center" valign="middle" class="borderright borderbottom"><%=id %></td>
	        <td align="center" valign="middle" class="borderright borderbottom"><%=name %></td>
	        <td align="center" valign="middle" class="borderright borderbottom"><%=pass %></td>
	        <td align="center" valign="middle" class="borderright borderbottom"><%=quanx %></td>
	        <td align="center" valign="middle" class="borderright borderbottom"><%=address %></td>
	        <td align="center" valign="middle" class="borderright borderbottom"><%=tel %></td>
	        <td align="center" valign="middle" class="borderright borderbottom"><%=sel+"￥" %></td>

			<td align="center" valign="middle" class="borderbottom"><a href="/BlueSystem/edit.jsp?name=<%=ba.getId() %>" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="/BlueSystem/delect.jsp?name=<%=ba.getId() %>" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
	 </tr>
	<%	
	}
%>
     
     
     
   
    </table></td>
    </tr>
  <tr>
    <td align="left" valign="top" class="fenye">11 条数据 1/1 页&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">尾页</a></td>
  </tr>
</table>


</body>
</html>