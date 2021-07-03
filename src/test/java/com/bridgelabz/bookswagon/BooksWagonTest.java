/**
 * purpose : To create test cases for different feature of Bookswagon
 * Author : Samiksha Shende
 * Date : 08/06/2021
 */

package com.bridgelabz.bookswagon;

import com.bridgelabz.bookswagon.base.Base;
import com.bridgelabz.bookswagon.pages.*;
import com.bridgelabz.bookswagon.utility.*;
import com.relevantcodes.extentreports.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(TestNgListener.class)
public class BooksWagonTest extends Base {
    Login login;
    Dashboard dashboard;

    static Logger log = Logger.getLogger(BooksWagonTest.class.getName());

    //test to check functionality for login
    @Test(dataProvider = "testdata")
    public void login_Into_Account(String username, String password) throws InterruptedException, IOException {
        login = new Login(webdriver);
        dashboard = new Dashboard(webdriver);
        Boolean check = login.loginIntoAccount(username, password);
        if (check) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("loginPage")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("loginPage")));
        }
        Assert.assertTrue(check);
        log.info("Test case to check the login functionality");
    }

    //test to check the search feature functionality
    @Test
        public void place_An_Order() throws InterruptedException, IOException {
        dashboard = new Dashboard(webdriver);
        Boolean checkBook = dashboard.placeOrderForBookAvailable(webdriver, "Wings of Fire");
        Thread.sleep(3000);
        if (checkBook) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("orderPage")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("orderPage")));
        }
        Assert.assertTrue(checkBook);
        log.info("Test case to check the search button functionality");
    }

    //data provider for login method
    @DataProvider(name = "testdata")
    public Object[][] testData() {
        ReadFile readFile = new ReadFile("C:\\Users\\kalam\\IdeaProjects\\BookswagonAutomationProgram\\src\\main\\resources\\TestData.xlsx");
        int rows = readFile.getRowCount(0);
        Object[][] sign_in_credentials = new Object[rows][2];
        for (int i = 0; i < rows; i++) {
            sign_in_credentials[i][0] = readFile.getData(0, i, 0);
            sign_in_credentials[i][1] = readFile.getData(0, i, 1);
        }
        return sign_in_credentials;
    }
}
