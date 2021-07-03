/**
 * purpose : To write code for different feature of Bookswagon
 * Author : Samiksha Shende
 * Date : 08/06/21020
 */

package com.bridgelabz.bookswagon.pages;

import org.apache.xmlbeans.impl.schema.SchemaDependencies;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    public static AddressForm addressForm;
    public static Checkout checkout;
    public static Payment payment;

    @FindBy(xpath = "//label[@id='ctl00_lblTotalCartItems']")
    WebElement selectCart;

    @FindBy(xpath = "//div[@id='cboxClose']")
    WebElement closeWindow;

    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
    WebElement searchBox;

    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
    WebElement searchButton;

//    @FindBy(xpath = "//a[text()='Wings of Fire']")
//    WebElement check;

    @FindBy(xpath = "//a[text()='The Rose Code']")
    WebElement book;

    @FindBy(xpath = "//input[@value='Buy Now']")
    WebElement addToCart;

    @FindBy(xpath = "//input[@value='Add to Wishlist']")
    WebElement addToWishlist;

    @FindBy(xpath = "//a[@href='https://www.bookswagon.com/book/wings-fire-au-apj-abdul/9788173711466']")
    WebElement checkBook;

    @FindBy(xpath = "/html/body/form/div[3]/div[2]/div/div/div[4]/table/tbody/tr/td[3]/input")
    WebElement placeOrder;

    @FindBy(className = "btn-red")
    WebElement continueButton;

    @FindBy(xpath = "//a[text()='New Arrivals']")
    WebElement newArrivalButton;

    @FindBy(id="ctl00_cpBody_imgSaveNew")
    WebElement saveAndContinue;

    @FindBy(xpath = "//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[1]/a[1]/span[1]")
    static WebElement menuButton;

    @FindBy(id = "ctl00_lnkbtnLogout")
    static WebElement logoutButton;

    @FindBy(xpath = "//label[text()='My Wishlist']")
    WebElement checkWishlist;

    @FindBy(xpath = "//a[text()='Login']")
    static WebElement login;

    @FindBy(id="BookCart_lvCart_ctrl0_txtQty")
    WebElement quantity;

    @FindBy(id="BookCart_lvCart_ctrl0_rngQty")
    WebElement errorMessage;

    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //method to place an order for available book
    public Boolean placeOrderForBookAvailable(WebDriver webdriver, String bookName) throws InterruptedException {
        addressForm = new AddressForm(webdriver);
        checkout = new Checkout(webdriver);
        payment = new Payment(webdriver);
        searchBox.sendKeys(bookName);
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("arguments[0].click()", searchButton);
        WebElement check = webdriver.findElement(By.xpath("//a[text()='" + bookName + "']"));
        if (check.isDisplayed()) {
                check.click();
                Thread.sleep(1000);
                addToCart.click();
                Thread.sleep(500);
                closeWindow.click();
                Thread.sleep(500);
                selectCart.click();
                Thread.sleep(3000);
                webdriver.switchTo().frame(1);
                Thread.sleep(3000);
                placeOrder.click();
                webdriver.switchTo().parentFrame();
                Thread.sleep(1000);
                continueButton.click();
                addressForm.FillAddressDetails();
                checkout.checkOutFromCart();
                payment.makePayment();
                return true;
            }else return false;
    }

    //method to place an order for book for not in stalk
    public Boolean placeOrderForNotInStackBook(WebDriver webdriver, String bookName) {
        searchBox.sendKeys(bookName);
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("arguments[0].click()", searchButton);
        WebElement checkBook = webdriver.findElement(By.xpath("//span[text()='"+bookName+"']"));
        try {
            if(checkBook.isDisplayed()) {
                addToWishlist.click();
            }
            return checkWishlist.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return checkWishlist.isDisplayed();
        }
    }

    //method to place an order for book in new arrival
    public Boolean placeOrderForNewArrival(WebDriver webdriver) {
        addressForm = new AddressForm(webdriver);
        checkout = new Checkout(webdriver);
        payment = new Payment(webdriver);
         try {
            newArrivalButton.click();
            book.click();
            Thread.sleep(500);
            addToCart.click();
            Thread.sleep(500);
            closeWindow.click();
            Thread.sleep(500);
            selectCart.click();
            Thread.sleep(3000);
            webdriver.switchTo().frame(1);
            Thread.sleep(3000);
            placeOrder.click();
            Thread.sleep(500);
            webdriver.switchTo().parentFrame();
            Thread.sleep(1000);
            continueButton.click();
            addressForm.FillAddressDetails();
            checkout.checkOutFromCart();
            payment.makePayment();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //method to place an order for book in new arrival with invalid quantity
    public Boolean placeOrderForNewArrivalWithInvalidQuantity(WebDriver webdriver) {
        addressForm = new AddressForm(webdriver);
        checkout = new Checkout(webdriver);
        payment = new Payment(webdriver);
        try {
            newArrivalButton.click();
            book.click();
            Thread.sleep(500);
            addToCart.click();
            Thread.sleep(500);
            closeWindow.click();
            Thread.sleep(500);
            selectCart.click();
            Thread.sleep(3000);
            webdriver.switchTo().frame(1);
            Thread.sleep(3000);
            quantity.clear();
            quantity.sendKeys("0");
            placeOrder.click();
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return errorMessage.isDisplayed();
        }
    }
        //method to logout from account
        public static Boolean logoutFromAccount() {
            try {
                menuButton.click();
                logoutButton.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return login.isDisplayed();
        }
    }
