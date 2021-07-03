package com.bridgelabz.bookswagon.pages;

import com.bridgelabz.bookswagon.utility.Constants;
import com.bridgelabz.bookswagon.utility.Library;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Payment implements Constants {

    @FindBy(id="ctl00_cpBody_btnCCAvenue")
    WebElement CCAvenue;

    @FindBy(id="creditCardNumber")
    WebElement creditCardNumber;

    @FindBy(id="expiryMonthCreditCard")
    WebElement month;

    @FindBy(id="expiryYearCreditCard")
    WebElement year;

    @FindBy(id="CVVNumberCreditCard")
    WebElement cvv;

    @FindBy(linkText = "Make Payment")
    WebElement makePayment;

    @FindBy(xpath = "//input[@value='Continue Shopping']")
    WebElement continueShopping;

    public Payment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void makePayment() throws InterruptedException {
        CCAvenue.click();
        creditCardNumber.sendKeys(Library.getProperty(CONFIG_PATH, "credit"));
        month.click();
        Select select = new Select(month);
        select.selectByVisibleText(Library.getProperty(CONFIG_PATH, "expiryDate"));
        Thread.sleep(1000);
        year.click();
        Select select2 = new Select(year);
        select2.selectByVisibleText(Library.getProperty(CONFIG_PATH, "year"));
        Thread.sleep(1000);
        cvv.sendKeys(Library.getProperty(CONFIG_PATH, "verificationNo"));
        makePayment.click();
        continueShopping.click();
    }
}
