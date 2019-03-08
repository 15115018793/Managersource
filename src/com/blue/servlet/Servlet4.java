package com.blue.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.bean.Bean_admin;
import com.blue.dao.Dao;
import com.blue.util.Util;

public class Servlet4 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String infoname=req.getParameter("infoname");
		String infopass=req.getParameter("infopass");
		
		long infoid=Long.parseLong(req.getParameter("infoid"));
		
		String infoaddress=req.getParameter("text_address");
		String infotel=req.getParameter("text_tel");
		long infosel=new Integer(req.getParameter("text_sal"));
		Bean_admin ba=new Bean_admin();
		ba.setName(infoname);
		ba.setId(infoid);
		ba.setPassword(infopass);
		ba.setAddress(infoaddress);
		ba.setTel(infotel);
		ba.setSel(infosel);
		String arr[]=req.getParameterValues("level");
		for(int i=0;i<arr.length;i++){
			if("1".equals(arr[i])){
				ba.setQuanx("信息录入员");
				
			}
			
			if("2".equals(arr[i])){
				ba.setQuanx("一般管理员");
				
			}
			if("3".equals(arr[i])){
				ba.setQuanx("超级管理员");
				
			}
		}
		
		
		Util u=new Util();
	Connection conn=u.getConn();
		Dao dao=new Dao(conn);
		int a=dao.Updata_admin_id(ba);
		System.out.println(a);
		if(a==1){
			resp.getWriter().println("修改成功");
		}else{
			resp.getWriter().println("修改失败");
			
		}
	
	}
}
