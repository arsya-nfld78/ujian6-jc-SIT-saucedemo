package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductToCartPage;
import com.juaracoding.utils.Constans;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage = new LoginPage();
    private ProductToCartPage productToCartPage = new ProductToCartPage();
    private ExtentTest extentTest;

    public LoginTest(){

        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    //TCC 0001
    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        driver.get(Constans.URL);
        extentTest.log(LogStatus.PASS,"I am on the login page");
    }

    @When("I enters username and password validly")
    public void i_enters_username_and_password_validly(){
        DriverSingleton.delay(3);
        loginPage.login("standard_user","secret_sauce");
        extentTest.log(LogStatus.PASS,"I enters username and password validly");
    }

    @And("I click the login button")
    public void i_click_the_login_button(){
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS,"I click the login button");
    }

    @Then("I should be redirected to the products page")
    public void i_should_be_redirected_to_the_products_page(){
        Assert.assertEquals(productToCartPage.getTxtProductTitle(),"Products");
        DriverSingleton.delay(3);
        productToCartPage.logout();
        extentTest.log(LogStatus.PASS,"I should be redirected to the products page");
    }

    //TCC 0002
    @When("I enters username validly and password invalidly")
    public void i_enters_username_validly_and_password_invalidly(){
        DriverSingleton.delay(3);
        loginPage.login("standard_user","secret12sauce");
        extentTest.log(LogStatus.PASS,"I enters username validly and password invalidly");

    }

    @Then("I should see an error displayed")
    public void i_should_see_an_error_displayed(){
        DriverSingleton.delay(3);
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(),"Epic sadface: Username and password do not match any user in this service");
        extentTest.log(LogStatus.PASS,"I should see an error displayed");
    }

    //TCC 0003
    @And("I enters username invalidly and password validly")
    public void i_enters_username_invalidly_and_password_validly(){
        loginPage.login("standard","secret_sauce");
        DriverSingleton.delay(3);
        extentTest.log(LogStatus.PASS,"I enters username invalidly and password validly");

    }

    //TCC 0004
    @And("I leaves username and password fields empty")
    public void i_leaves_username_and_password_fields_empty(){
        loginPage.login("","");
        DriverSingleton.delay(3);
        extentTest.log(LogStatus.PASS,"I leaves username and password fields empty");

    }
    @Then("an error message Username is required should be displayed")
    public void an_error_message_username_is_required_should_be_displayed(){
        Assert.assertEquals(loginPage.getTxtRequired(),"Epic sadface: Username is required");
        extentTest.log(LogStatus.PASS,"an error message Username is required should be displayed");
    }
}
