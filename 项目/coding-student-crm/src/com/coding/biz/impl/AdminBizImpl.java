package com.coding.biz.impl;

import com.coding.biz.AdminBiz;
import com.coding.dao.AdminDao;
import com.coding.dao.impl.AdminDaoImpl;
import com.coding.domain.Admin;

public class AdminBizImpl implements AdminBiz {
    private AdminDao dao=new AdminDaoImpl();
    @Override
    public Admin adminLogin(String adminName, String adminPwd) {
        return dao.findAdminByNameOrPwd(adminName,adminPwd);
    }

    @Override
    public boolean registerAdmin(Admin admin) {
        int code=dao.insertAdmin(admin);
        if(code>0){
            return true;
        }
        return false;
    }
}
