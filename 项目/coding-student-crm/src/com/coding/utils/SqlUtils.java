package com.coding.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SqlUtils {
    private static final String fileName="sql.properties";
    private static Properties p=new Properties();
    static{
        try {
            InputStream is = SqlUtils.class.getClassLoader().getResourceAsStream(fileName);
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getSql(String sqlKey){
        return p.getProperty(sqlKey);
    }

}
