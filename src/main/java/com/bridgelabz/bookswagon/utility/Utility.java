/**
 * purpose : To perform different functions
 * Author : Samiksha Shende
 * Date : 09/06/2021
 */

package com.bridgelabz.bookswagon.utility;

import com.bridgelabz.bookswagon.base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;ggi

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Utility extends Base {

    //Method to take a screenshot
    public static String screenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\kalam\\IdeaProjects\\BookswagonAutomationProgram\\src\\main\\resources\\Screenshot/" + fileName + System.currentTimeMillis() + ".jpg");
        String filePath = dest.getAbsolutePath();
        FileUtils.copyFile(file, dest);
        System.out.println("Screenshot Taken for " + fileName);
        return filePath;
    }

    //method to check internet connection
    public static void checkConnection(String stringUrl) throws IOException {
        URL url = new URL(stringUrl);
        URLConnection connection = url.openConnection();
        connection.connect();
        System.out.println("Internet is connected");
    }
}
