package com.web.runcase;

import java.io.File;

public class DelFiles {
    public static void main(String[] args) {
        String imgPath = System.getProperty("user.dir")+File.separator+"img";
        refreshFileList(imgPath);
    }

    public static void refreshFileList(String strPath) {
        System.out.println("strpath_____"+strPath);
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("该目录下没有文件");
            return;
        }
        int count = 0;
        for(int i = 0;i<files.length;i++){
            files[i].delete();
            System.out.println("删除成功" );
        }
    }
}