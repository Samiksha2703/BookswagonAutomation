/**
 * purpose : To check the functionality of login feature for Bookswagon
 * Author : Samiksha Shende
 * Date : 08/06/21020
 */

package com.bridgelabz.bookswagon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy(xpath = "//a[text()='Login']")
    WebElement login;

    @FindBy(name = "ctl00$phBody$SignIn$txtEmail")
    WebElement emailId;

    @FindBy(name = "ctl00$phBody$SignIn$txtPassword")
    WebElement password;

    @FindBy(name = "ctl00$phBody$SignIn$btnLogin")
    WebElement loginAccount;

    @FindBy(xpath = "//h1[text()='My Account']")
    WebElement checkAccount;

    @FindBy(id = "ctl00_phBody_SignIn_lblmsg")
    WebElement errorMessage;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean loginIntoAccount(String username, String password) throws InterruptedException {
        try {
            login.click();
            Thread.sleep(1000);
            emailId.sendKeys(username);
            Thread.sleep(1000);
            this.password.sendKeys(password);
            Thread.sleep(1000);
            loginAccount.click();
            Thread.sleep(1000);
            return checkAccount.isDisplayed();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return checkAccount.isDisplayed();
        }
    }

    public boolean loginIntoAccountForInvalidData(String username, String password) throws InterruptedException {
        try {
            login.click();
            Thread.sleep(1000);
            emailId.sendKeys(username);
            Thread.sleep(1000);
            this.password.sendKeys(password);
            Thread.sleep(1000);
            loginAccount.click();
            Thread.sleep(1000);
            return errorMessage.isDisplayed();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return errorMessage.isDisplayed();
        }
    }
}
