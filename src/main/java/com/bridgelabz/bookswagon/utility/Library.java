/*
 * purpose : To read properties from application.properties file
 * Author : Samiksha Shende
 * Date : 09/06/2021
 */


package com.bridgelabz.bookswagon.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Library implements Constants {

    //method to get the property from application.properties file
    public static String getProperty(String CONFIG_PATH, String key) {
        String property = "";
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(CONFIG_PATH));
            property = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}

