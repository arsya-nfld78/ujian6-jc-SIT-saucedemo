package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Class ProductToCartPage berisi arahan home page dan cart page yang disatukan
public class ProductToCartPage {
    private WebDriver driver;

    public ProductToCartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    // mengambil elemen home page
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement btnAddTShirt;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement btnAddBikeLight;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement btnCart;

    //logout
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menuTab;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogout;

    //Assertion home page
    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtProductTitle;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement txtCartBadge;

    // mengambil elemen cart page
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement btnCheckout;

    //Assertion cart page
    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtCartTitle;

    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Bike Light']")
    private WebElement txtBikeLight;

    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Bolt T-Shirt']")
    private WebElement txtTShirt;

    // method untuk home page
    public void addBothProducts(){
        btnAddBikeLight.click();
        btnAddTShirt.click();
    }

    public void setBtnCart(){
        btnCart.click();
    }

    public void logout(){
        menuTab.click();
        btnLogout.click();
    }

    //cek jumlah produk
    public String getTxtCartBadge(){ return txtCartBadge.getText(); }

    //Assertion home page
    public String getTxtProductTitle(){
        return txtProductTitle.getText();
    }

    // method untuk cart page
    public void setBtnCheckout(){
        btnCheckout.click();
    }

    //assertion cart page
    public String getTxtCartTitle (){ return txtCartTitle.getText(); }
    public String getTxtBikeLight (){ return txtBikeLight.getText(); }
    public String getTxtTShirt (){ return txtTShirt.getText(); }
}
