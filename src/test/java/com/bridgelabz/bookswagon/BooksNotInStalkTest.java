package com.bridgelabz.bookswagon;

import com.bridgelabz.bookswagon.base.Base;
import com.bridgelabz.bookswagon.pages.Dashboard;
import com.bridgelabz.bookswagon.pages.Login;
import com.bridgelabz.bookswagon.utility.Utility;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BooksNotInStalkTest extends Base {
    Login login;
    Dashboard dashboard;

    static Logger log = Logger.getLogger(BooksWagonTest.class.getName());

    //test to check functionality for login
    @Test(priority = 1)
    public void login_Into_Account() throws InterruptedException, IOException {
        login = new Login(webdriver);
        dashboard = new Dashboard(webdriver);
        Boolean check = login.loginIntoAccount("shende.samiksha@rediffmail.com", "BookswagonSamiksha");
        if (check) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("loginPage")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("loginPage")));
        }
        Assert.assertTrue(check);
        log.info("Test case to check the login functionality");
    }

    //test to check add to wishlist feature functionality
    @Test(priority = 2)
    public void place_An_Order() throws InterruptedException, IOException {
        dashboard = new Dashboard(webdriver);
        Boolean check = dashboard.placeOrderForNotInStackBook(webdriver, "Dragon Ball: A Visual History");
        Thread.sleep(3000);
        if (check) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("orderPage")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("orderPage")));
        }
        Assert.assertTrue(check);
        log.info("Test case to check the search button functionality");
    }

    //test to check the functionality for logout
    @Test(priority = 3)
    public void logout_From_Account() throws IOException {
    Boolean check = Dashboard.logoutFromAccount();
        if (check) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("Logout Page")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("Logout Page")));
        }
        Assert.assertTrue(check);
        log.info("Test case to check the logout button functionality");
    }
}
