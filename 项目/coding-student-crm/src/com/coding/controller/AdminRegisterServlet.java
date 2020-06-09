package com.coding.controller;

import com.coding.biz.AdminBiz;
import com.coding.biz.impl.AdminBizImpl;
import com.coding.domain.Admin;
import com.coding.utils.DateUtils;
import com.coding.utils.MD5;
import com.coding.utils.PathUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@WebServlet("/AdminRegisterServlet")
public class AdminRegisterServlet extends HttpServlet {
    private final String imagePathKey="IMAGE_SERVER_PATH";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //需要通过FileUpload获取请求信息文本+图片资源
        //1.创建文件上传工厂
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //2.创建文件上传对象
        ServletFileUpload upload=new ServletFileUpload(factory);
        //3.通过文件上传对象转化请求对象
        Map<String,String> map=new HashMap<>();
        try {
            List<FileItem> itemList = upload.parseRequest(request);
            for (FileItem item:itemList) {
                if (item.isFormField()){
                    //输入框字段
                    String value=item.getString();
                    value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
                    map.put(item.getFieldName(),value);
                }else{
                    //文件--图片头像
                    String name=item.getName();
                    String newName=UUID.randomUUID().toString().replaceAll("-","");//文件的新名字
                    String ext=name.substring(name.lastIndexOf("."));//文件的后缀名
                    newName=newName+ext;
                    InputStream is= item.getInputStream();
                    File file=new File(PathUtils.getPath(imagePathKey),newName);
                    OutputStream out=new FileOutputStream(file);
                    IOUtils.copy(is,out);
                    map.put(item.getFieldName(),newName);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Admin admin=new Admin();
        for (String key: map.keySet()) {
            switch (key){
                case "adminName":
                    admin.setAdminName(map.get(key));
                    break;
                case "adminRealName":
                    admin.setAdminRealName(map.get(key));
                    break;
                case "adminPwd":
                    admin.setAdminPwd(MD5.getMD5PassWord(map.get(key)));
                    break;
                case "adminPhone":
                    admin.setAdminPhone(map.get(key));
                    break;
                case "adminAddress":
                    admin.setAdminAddress(map.get(key));
                    break;
                case "adminBirthday":
                    admin.setAdminBirthday(DateUtils.getStringToDate(map.get(key)));
                    admin.setAdminAge((new Date().getYear()-admin.getAdminBirthday().getYear())+1);
                    break;
                case "adminType":
                    admin.setAdminType(Integer.parseInt(map.get(key)));
                    break;
                case "adminHead":
                    admin.setAdminHead(map.get(key));
                    break;
                case "adminSex":
                    admin.setAdminSex(map.get(key));
                    break;

            }

        }
        AdminBiz adminBiz=new AdminBizImpl();
       boolean boo= adminBiz.registerAdmin(admin);
        if(boo){//注册成功跳转到列表页
            response.sendRedirect("admin_add.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}