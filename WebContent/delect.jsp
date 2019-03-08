<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ page import="com.blue.util.Util" %>
  <%@ page import="java.sql.Connection" %>
  <%@ page import="com.blue.dao.Dao" %>
  <%@ page import="java.util.*" %>
  <%@ page import="com.blue.bean.Bean_admin" %>
  <%@ page errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String name=request.getParameter("name");

	Util u=new Util();
	Connection conn=u.getConn();
	Dao dao=new Dao(conn);
	int rs=	dao.delectinfo(Long.parseLong(name));
	if(rs==1){
		response.getWriter().print("删除成功");
		response.sendRedirect("/BlueSystem/main_list.jsp");
		
	}
%>

</body>
</html>