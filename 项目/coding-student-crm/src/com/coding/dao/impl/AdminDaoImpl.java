package com.coding.dao.impl;

import com.coding.dao.AdminDao;
import com.coding.domain.Admin;
import com.coding.utils.DbUtils;
import com.coding.utils.SqlUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    private DataSource ds=DbUtils.getDataSource();
    private QueryRunner qr=new QueryRunner(ds);
    @Override
    public Admin findAdminByNameOrPwd(String adminName, String adminPwd) {
        try {
            return qr.query(SqlUtils.getSql("findAdminByNameOrPwd"),new BeanHandler<>(Admin.class),adminName,adminPwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertAdmin(Admin admin) {
        Object[] params={admin.getAdminName(),admin.getAdminPwd()
                ,admin.getAdminRealName(),admin.getAdminSex()
                ,admin.getAdminAge(),admin.getAdminBirthday()
                ,admin.getAdminAddress(),admin.getAdminPhone()
                ,admin.getAdminHead(),admin.getAdminType()};
        try {
            return qr.update(SqlUtils.getSql("insertAdmin"),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
