package com.bridgelabz.bookswagon;

import com.bridgelabz.bookswagon.base.Base;
import com.bridgelabz.bookswagon.pages.Dashboard;
import com.bridgelabz.bookswagon.pages.Login;
import com.bridgelabz.bookswagon.utility.Constants;
import com.bridgelabz.bookswagon.utility.Library;
import com.bridgelabz.bookswagon.utility.TestNgListener;
import com.bridgelabz.bookswagon.utility.Utility;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestNgListener.class)
public class InvalidLogin extends Base implements Constants {
    Login login;
    Dashboard dashboard;

    static Logger log = Logger.getLogger(BooksWagonTest.class.getName());

    //test to check functionality for login
    @Test
    public void login_Into_Account() throws InterruptedException, IOException {
        login = new Login(webdriver);
        dashboard = new Dashboard(webdriver);
        Boolean check = login.loginIntoAccountForInvalidData(Library.getProperty(CONFIG_PATH, "EmailID"), Library.getProperty(CONFIG_PATH, "Pass"));
        if (check) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("loginPage")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("loginPage")));
        }
        Assert.assertTrue(check);
        log.info("Test case to check the login functionality");
    }
}
