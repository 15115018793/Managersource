package com.blue.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.bean.Bean_admin;
import com.blue.dao.Dao;
import com.blue.util.Util;

public class Servlet3 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String name= req.getParameter("text_name");
		//输入框查询
		System.out.println(name);
		Util u=new Util();
		Connection conn=u.getConn();
		Dao dao=new Dao(conn);
	ArrayList al=dao.select_admin_id(name);
		req.setAttribute("ArrayList",al);
		System.out.println(al);
		req.getRequestDispatcher("/main_selectinfo.jsp").forward(req, resp);
	}
	
}
