package com.coding.dao;

import com.coding.domain.Admin;

public interface AdminDao {
    public Admin findAdminByNameOrPwd(String adminName,String adminPwd);

    int insertAdmin(Admin admin);
}
