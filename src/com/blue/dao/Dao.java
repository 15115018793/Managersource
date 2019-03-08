package com.blue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.blue.bean.Bean;
import com.blue.bean.Bean_admin;
import com.blue.util.Util;

public class Dao {
	
	ResultSet rs=null;
	PreparedStatement ps=null;
	Connection conn;
	
	public Dao(Connection conn){
		this.conn=conn;
		
	}
	
	//查询表中数据
	public ArrayList Select_user(){
		String sql="select username,userpass from user_db";
			ArrayList al=null;
		try {
	ps=conn.prepareStatement(sql);
			 rs=ps.executeQuery();
			al=new ArrayList();
			while(rs.next()){
				String username=rs.getString("username");
				String userpass=rs.getString("userpass");
				Bean b=new Bean();
				b.setUsername(username);
				b.setUserpass(userpass);
				al.add(b);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		close();
		return al;
		
		
		
	}
	
	//查询admin表中的数据
	public ArrayList Select_admin(){
		String sql="select * from admin_db";
			ArrayList al=null;
		try {
	ps=conn.prepareStatement(sql);
			 rs=ps.executeQuery();
			al=new ArrayList();
			while(rs.next()){
				Bean_admin ba=new Bean_admin();
				ba.setId(rs.getLong(1));
				ba.setName(rs.getString(2));
				ba.setPassword(rs.getString(3));
				ba.setQuanx(rs.getString(4));
				ba.setAddress(rs.getString(5));
				ba.setTel(rs.getString(6));
				ba.setSel(rs.getLong(7));
				
			
				al.add(ba);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		close();
		return al;
		
		
		
	}
	
	//添加表中数据
	public int Updata_admin(Bean_admin ba){
		
		String sql="insert into admin_db (name,password,quanx,address,tel,sel) value(?,?,?,?,?,?) ";
		int a=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, ba.getName());
			ps.setString(2, ba.getPassword());
			ps.setString(3, ba.getQuanx());
			ps.setString(4, ba.getAddress());
			ps.setString(5, ba.getTel());
			ps.setLong(6, ba.getSel());
			System.out.println(ba.getAddress());
			a=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return a;
		
	}
	//编辑
	public ArrayList select_admin_id(long id){
		String sql="select * from admin_db where id="+id+"";
		ArrayList al=null;
		try {
		 ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			 al=new ArrayList();
			while(rs.next()){
				Bean_admin ba=new Bean_admin();
				
				ba.setId(rs.getLong(1));
				ba.setName(rs.getString(2));
				ba.setPassword(rs.getString(3));
				ba.setQuanx(rs.getString(4));
				ba.setAddress(rs.getString(5));
				ba.setTel(rs.getString(6));
				ba.setSel(rs.getLong(7));
				al.add(ba);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close();
		return al;
		
	}
	
	//查询对应idname	输入框查询
		public ArrayList select_admin_id(String name){
			String sql="select * from admin_db where name='"+name+"'";
			ArrayList al=null;
			try {
			 ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				 al=new ArrayList();
				while(rs.next()){
					Bean_admin ba=new Bean_admin();
					
					ba.setId(rs.getLong(1));
					ba.setName(rs.getString(2));
					ba.setPassword(rs.getString(3));
					ba.setQuanx(rs.getString(4));
					ba.setAddress(rs.getString(5));
					ba.setTel(rs.getString(6));
					ba.setSel(rs.getLong(7));
					al.add(ba);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			close();
			return al;
			
		}
	
	//修改表中数据
	public int Updata_admin_id(Bean_admin ba){
		
		String sql="update admin_db set name=?,password=?,quanx=?,address=?,tel=?,sel=? where id=?";
		int a=0;
		try {
			 ps=conn.prepareStatement(sql);
			ps.setString(1, ba.getName());
			ps.setString(2, ba.getPassword());
			ps.setString(3, ba.getQuanx());
			ps.setString(4, ba.getAddress());
			ps.setString(5, ba.getTel());
			ps.setLong(6, ba.getSel());
			ps.setLong(7, ba.getId());
			//System.out.println(sql);
			
			 a=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return a;
		
		
	}
	public int delectinfo(long id){
			
		String sql="delete from admin_db where id="+id+"";
		int rs=0;
		try {
		 ps=conn.prepareStatement(sql);
			 rs=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close();
		return rs;
		
	}
	
	
	public void close(){
		if(rs!=null){

			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;
	}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=null;
			
			
	
		}
	}
}