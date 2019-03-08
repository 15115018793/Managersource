package com.blue.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.bean.Bean;
import com.blue.dao.Dao;
import com.blue.util.Util;

public class Servlet1 extends HttpServlet{

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String username=req.getParameter("username");
	
			String userpass=req.getParameter("pwd");
			Util ut=new Util();
			Connection conn=ut.getConn();
			Dao dao=new Dao(conn);
			ArrayList al=dao.Select_user();
			for(int i=0;i<al.size();i++){
				Bean b=(Bean)al.get(i);
				if(username.equals(b.getUsername()) && userpass.equals(b.getUserpass())){
					resp.sendRedirect("index.html");
				}
					
					
				
				
			}
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().println("密码或账号错误");
			
	}
	
}
