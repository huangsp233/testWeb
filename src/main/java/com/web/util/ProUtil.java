package com.web.util;


import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 配置文件读取类，支持多个配置文件，相同的key以后面的覆盖
 */
public class ProUtil {

    private static final String DEFAULT_SPLIT_CHAR = ",";

    private Map<String, String> configMap;

    /**
     * 默认构造函数
     */
    public ProUtil() {
        configMap = new HashMap();
    }

    /**
     * 构造函数并传入配置文件
     */
    public ProUtil(String configFileName) {
        configMap = new HashMap();
        updateConfigMap(configFileName);
    }

    /**
     * 获取字符串类型的值
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return configMap.get(key).toString();
    }


    private void updateConfigMap(String configFileName) {
        Properties properties = null;

        if (isAbsoluteFile(configFileName)) {
            File file = new File(configFileName);
            if (file.exists()) {
                try(InputStream is = new FileInputStream(file);) {
                    properties = new Properties();
                    properties.load(is);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(configFileName);
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            if (is != null) {
                properties = new Properties();
                try {
                    properties.load(bf);
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
        }

        if (properties != null) {
            Iterator<Object> it = properties.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next().toString();

                String value = properties.get(key).toString();
                configMap.put(key, value);
            }
        }
    }

    private boolean isAbsoluteFile(String configFileName) {
        return configFileName.contains("/") || configFileName.contains("\\");
    }

    public Map<String, String> getConfigMap() {
        return configMap;
    }

    public static void main(String[] args){
        ProUtil config = new ProUtil("element.properties");
        System.out.println(config.getString("username"));
    }
}
