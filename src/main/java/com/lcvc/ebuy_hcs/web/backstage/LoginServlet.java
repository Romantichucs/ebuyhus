package com.lcvc.ebuy_hcs.web.backstage;


import com.lcvc.ebuy_hcs.dao.AdminDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet(urlPatterns="/backstage/login")
public class LoginServlet extends HttpServlet {
	AdminDao adminDao=new AdminDao();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		//获取登录页面的账户名表单数据
		String username=request.getParameter("username");
		//获取登录页面的密码表单数据
		String password=request.getParameter("password");	
		//根据账户名和密码判断是否登录成功
		if(adminDao.login(username, password)){
			resp.sendRedirect(basePath+"jsp/backstage/main.html");
		}else{
			resp.sendRedirect(basePath+"/jsp/backstage/login.jsp");
		}	
		
	}
}
