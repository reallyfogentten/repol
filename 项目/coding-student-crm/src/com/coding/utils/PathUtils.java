package com.coding.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PathUtils {
    private static final String fileName="path.properties";
    private static Properties p=new Properties();
    static{
        try {
            InputStream is = PathUtils.class.getClassLoader().getResourceAsStream(fileName);
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getPath(String pathKey){
        return p.getProperty(pathKey);
    }

}
