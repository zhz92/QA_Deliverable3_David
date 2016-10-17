/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserSearch;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static junit.framework.Assert.assertEquals;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author davidzhang
 */
public class StepDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String HOME_PAGE = "http://store.demoqa.com/";

    /**
     * *
     * Scenario 1
     **
     */
    @Given("users go to the store")
    public void HomePage() {
        System.setProperty("webdriver.gecko.driver", "/Users/davidzhang/NetBeansProjects/QA_Deliverable3_David/libs/geckodriver");
        driver = new FirefoxDriver();
        driver.get(HOME_PAGE);
        wait = new WebDriverWait(driver, 30);

    }

    @When("they search for \"iPhone 5\"")
    public void searchiPhone5() {
        WebElement search = driver.findElement(By.xpath("//input[contains(@value, 'Search Products')]"));
        search.clear();
        search.sendKeys("iPhone 5");
        search.sendKeys(Keys.RETURN);

    }

    @Then("the store should return results of \"iPhone 5\"")
    public void result() {
        WebElement result = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class, 'prodtitle')]")));
        assertEquals("iPhone 5", result.getText());
//       System.out.println("---------->"+result.getText());
    }

    /**
     * *
     * Scenario 2
     **
     */
    @Given("users going to the store")
    public void HomePageAgain() {
        System.setProperty("webdriver.gecko.driver", "/Users/davidzhang/NetBeansProjects/QA_Deliverable3_David/libs/geckodriver");
        driver = new FirefoxDriver();
        driver.get(HOME_PAGE);

    }

    @When("they search for \"pen\"")
    public void searchNoneExitItem() {

        WebElement search = driver.findElement(By.xpath("//input[contains(@value, 'Search Products')]"));
        search.clear();
        search.sendKeys("pen");
        search.sendKeys(Keys.RETURN);

    }

    @Then("the store should return \"Sorry, but nothing matched your search criteria. Please try again with some different keywords.\"")
    public void notExitItem() {
        WebElement result = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sorry, but nothing matched your search criteria. Please try again with some different keywords.']")));
        assertEquals("Sorry, but nothing matched your search criteria. Please try again with some different keywords.", result.getText());

    }
    
    /**
     * *
     * Scenario 3
     **
     */
    @Given("I go to the store")
    public void Start() {
        System.setProperty("webdriver.gecko.driver", "/Users/davidzhang/NetBeansProjects/QA_Deliverable3_David/libs/geckodriver");
        driver = new FirefoxDriver();
        driver.get(HOME_PAGE);

    }

    @When("I input nothing in the search textbox")
    public void searchNothing() {
        WebElement search = driver.findElement(By.xpath("//input[contains(@value, 'Search Products')]"));
        search.clear();
        search.sendKeys(Keys.RETURN);

    }

    @Then("the store should return all kinds of items in the store")
    public void seeAllItems() {
        WebElement result = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("grid_view_products_page_container")));
        Assert.assertTrue(result.getText().contains("iPhone"));

    }
    
    /**
     * *
     * Scenario 4
     **
     */
    @Given("I going to the store")
    public void openStore() {
        System.setProperty("webdriver.gecko.driver", "/Users/davidzhang/NetBeansProjects/QA_Deliverable3_David/libs/geckodriver");
        driver = new FirefoxDriver();
        driver.get(HOME_PAGE);

    }

    @When("I would like to input \"ipad\" in the search textbox")
    public void searchCategory() {
        WebElement search = driver.findElement(By.xpath("//input[contains(@value, 'Search Products')]"));
        search.clear();
        search.sendKeys("ipad");
        search.sendKeys(Keys.RETURN);

    }

    @Then("the store should return all ipads in the store")
    public void seeAllItemsInCategory() {
        WebElement result = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("grid_view_products_page_container")));
        Assert.assertTrue(result.getText().contains("iPad 2"));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    
}
