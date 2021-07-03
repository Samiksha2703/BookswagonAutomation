package com.bridgelabz.bookswagon.pages;

import com.bridgelabz.bookswagon.utility.Constants;
import com.bridgelabz.bookswagon.utility.Library;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressForm implements Constants {
    @FindBy(id = "ctl00_cpBody_txtNewRecipientName")
    WebElement recipientName;

    @FindBy(id = "ctl00_cpBody_txtNewCompanyName")
    WebElement companyName;

    @FindBy(id = "ctl00_cpBody_txtNewAddress")
    WebElement address;

    @FindBy(id = "ctl00_cpBody_txtNewLandmark")
    WebElement landmark;

    @FindBy(id = "ctl00_cpBody_ddlNewCountry")
    WebElement country;

    @FindBy(id = "ctl00_cpBody_ddlNewState")
    WebElement state;

    @FindBy(id = "ctl00_cpBody_ddlNewCities")
    WebElement city;

    @FindBy(id = "ctl00_cpBody_txtNewPincode")
    WebElement zipCode;

    @FindBy(id = "ctl00_cpBody_txtNewMobile")
    WebElement phone;

    @FindBy(id = "ctl00_cpBody_imgSaveNew")
    WebElement saveButton;

    public AddressForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void FillAddressDetails() throws InterruptedException {
        recipientName.sendKeys(Library.getProperty(CONFIG_PATH, "recipient"));
        companyName.sendKeys(Library.getProperty(CONFIG_PATH, "recipientComp"));
        address.sendKeys(Library.getProperty(CONFIG_PATH, "recipientAdd"));
        landmark.sendKeys(Library.getProperty(CONFIG_PATH, "land"));
        Thread.sleep(500);
        country.click();
        Select select = new Select(country);
        select.selectByVisibleText(Library.getProperty(CONFIG_PATH, "recipientCountry"));
        Thread.sleep(500);
        state.click();
        Select select2 = new Select(state);
        select2.selectByVisibleText(Library.getProperty(CONFIG_PATH, "recipientState"));
        Thread.sleep(500);
        city.click();
        Select select3 = new Select(city);
        select3.selectByVisibleText(Library.getProperty(CONFIG_PATH, "recipientCity"));
        Thread.sleep(500);
        zipCode.sendKeys(Library.getProperty(CONFIG_PATH, "recipientPin"));
        phone.sendKeys(Library.getProperty(CONFIG_PATH, "recipientPhone"));
        saveButton.click();
    }
}
