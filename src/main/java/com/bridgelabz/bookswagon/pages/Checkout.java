package com.bridgelabz.bookswagon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

    @FindBy(id="ctl00_cpBody_ShoppingCart_lvCart_txtGiftMessage")
    WebElement giftMessage;

    @FindBy(id="ctl00_cpBody_ShoppingCart_lvCart_txtInstruction")
    WebElement specialInstruction;

    @FindBy(id="ctl00_cpBody_ShoppingCart_lvCart_savecontinue")
    WebElement saveAndContinue;

    public Checkout(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkOutFromCart(){
        giftMessage.sendKeys("Happy Birthday");
        specialInstruction.sendKeys("Please Wrap Gift In Red Paper");
        saveAndContinue.click();
    }
}
