package com.coding.biz;

import com.coding.domain.Admin;

public interface AdminBiz {

    public Admin adminLogin(String adminName,String adminPwd);

    boolean registerAdmin(Admin admin);
}
