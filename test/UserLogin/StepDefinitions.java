/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserLogin;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static junit.framework.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private final String LOGIN_PAGE = "http://store.demoqa.com/products-page/your-account/?login=1";
    
    /***
     * Scenario 1
     ***/
    @Given("a correct username and a correct password")
    public void openLoginPage() {
        System.setProperty("webdriver.gecko.driver", "/Users/davidzhang/NetBeansProjects/QA_Deliverable3_David/libs/geckodriver");
        driver = new FirefoxDriver();
        driver.get(LOGIN_PAGE);
        wait = new WebDriverWait(driver, 30);
        assertEquals("Your Account | ONLINE STORE", driver.getTitle());
    }
    
    @When("I try to login with those credentials")
    public void login_with_correct_credentials() {
      WebElement username = driver.findElement(By.id("log"));
      username.sendKeys("david");
      
      WebElement password = driver.findElement(By.id("pwd"));
      password.sendKeys("123456");
      
      WebElement login = driver.findElement(By.id("login"));
      login.submit();
    }
    
    @Then("I should login successfully")
    public void login_success() {
       WebElement welcome = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-admin-bar-my-account")));   
       assertEquals("Howdy, david", welcome.getText());
    }
    
    /***
     * Scenario 2
     ***/
     @Given("a correct username and an incorrect password")
    public void openLoginPageAgain() {
        System.setProperty("webdriver.gecko.driver", "/Users/davidzhang/NetBeansProjects/QA_Deliverable3_David/libs/geckodriver");
        driver = new FirefoxDriver();
        driver.get(LOGIN_PAGE);
        wait = new WebDriverWait(driver, 30);
    }
    
    @When("I try to login with correct username and incorrect password")
    public void login_with_incorrect_password() {
      WebElement username = driver.findElement(By.id("log"));
      username.sendKeys("david");
      
      WebElement password = driver.findElement(By.id("pwd"));
      password.sendKeys("abc");
      
      WebElement login = driver.findElement(By.id("login"));
      login.submit();
    }
    
    @Then("I should see an error message")
    public void login_unsuccessul() {
       WebElement error;   
       error = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='ERROR']")));
       assertEquals("ERROR", error.getText());
    }
    
    @After
    public void cleanUp() {
        driver.quit();
    }
}
