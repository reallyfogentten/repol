package com.coding.controller;

import com.coding.biz.AdminBiz;
import com.coding.biz.impl.AdminBizImpl;
import com.coding.domain.Admin;
import com.coding.utils.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String adminName = request.getParameter("adminName");
        String adminPwd = request.getParameter("adminPwd");
        String adminPwdMD5=MD5.getMD5PassWord(adminPwd);
        AdminBiz adminBiz=new AdminBizImpl();
        Admin admin=adminBiz.adminLogin(adminName,adminPwdMD5);
        if (admin!=null){
            request.getSession().setAttribute("admin",admin);
            response.sendRedirect("main.html");
        }else{
            response.sendRedirect("login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
