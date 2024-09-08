package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement btnFinish;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtInvalid;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement txtCheckoutComplete;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement btnBackToHome;

    public void userInfo(String firstName, String lastName, String postalCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
    }

    public void setBtnFinish() {
        btnFinish.click();
    }

    public void setBtnContinue() {
        btnContinue.click();
    }

    public void setBtnBackToHome() {
        btnBackToHome.click();
    }

    //assertion positif
    public String getTxtCheckoutComplete(){ return txtCheckoutComplete.getText(); }

    //assertion negatif
    public String getTxtInvalid(){ return txtInvalid.getText(); }
}
