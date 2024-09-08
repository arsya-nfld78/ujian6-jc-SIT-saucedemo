package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductToCartPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CheckoutTest {

    private  WebDriver driver;
    private ProductToCartPage productToCartPage = new ProductToCartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private LoginPage loginPage = new LoginPage();
    private ExtentTest extentTest;

    public CheckoutTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    //TCC 0006
    @Given("I proceeds to checkout")
    public void i_proceeds_to_checkout(){
        DriverSingleton.delay(3);
        productToCartPage.setBtnCheckout();
        extentTest.log(LogStatus.PASS,"I proceeds to checkout");
    }

    @When("I enters users information")
    public void i_enters_users_information(){
        DriverSingleton.delay(3);
        checkoutPage.userInfo("jane","doe","1234");
        extentTest.log(LogStatus.PASS,"I enters users information");
    }

    @And("I click continue")
    public void i_click_continue(){
        DriverSingleton.delay(3);
        checkoutPage.setBtnContinue();
        extentTest.log(LogStatus.PASS,"I click continue");
    }

    @Then("I should be redirected to the overview page and click finish")
    public void i_should_be_redirected_to_the_overview_page_and_click_finish(){
        DriverSingleton.delay(3);
        checkoutPage.setBtnFinish();
        extentTest.log(LogStatus.PASS,"I should be redirected to the overview page and click finish");
    }

    @And("I should see a message THANK YOU FOR YOUR ORDER")
    public void i_should_see_a_message_thank_you_for_your_order(){
        DriverSingleton.delay(3);
        Assert.assertEquals(checkoutPage.getTxtCheckoutComplete(),"Thank you for your order!");
        productToCartPage.logout();
        extentTest.log(LogStatus.PASS,"I should see a message THANK YOU FOR YOUR ORDER");
    }
}
