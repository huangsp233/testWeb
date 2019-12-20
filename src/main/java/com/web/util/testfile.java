package com.web.util;

import java.io.*;
import java.util.Properties;

public class testfile {
    public  Properties Pro;
    public testfile(String FilePath) {
        Pro = RedProperties(FilePath);
    }


    private Properties RedProperties(String filePath) {
        try {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            if (is != null) {
                Pro = new Properties();
                try {
                    Pro.load(bf);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        is.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Pro;

    }


    public String GetPro(String key) {
        String value;
        if (Pro.containsKey(key)) {
            value = Pro.getProperty(key);
            return value;
        }else {
            return "";
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //String FilePath;
        String filePath = "element.properties";
        testfile testFile  = new testfile(filePath);
        System.out.println(testFile.GetPro("username"));
    }
}