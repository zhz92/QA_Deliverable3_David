/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserSelectItem;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
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

    /**
     * *
     * Scenario 1
     */
    @Given("customers looking at iPhones")
    public void HomePage() {
        String iPhone_PAGE = "http://store.demoqa.com/?s=iphone&post_type=wpsc-product";
        System.setProperty("webdriver.gecko.driver", "/Users/davidzhang/NetBeansProjects/QA_Deliverable3_David/libs/geckodriver");
        driver = new FirefoxDriver();
        driver.get(iPhone_PAGE);
        wait = new WebDriverWait(driver, 30);

    }

    @When("they  add \"iPhone 4S\" to cart")
    public void addiPhone4S() {
        WebElement addToCart = driver.findElement(By.xpath("//input[contains(@value, 'Add To Cart')]"));
        addToCart.submit();

    }

    @And("they choose to go to checkout")
    public void Checkout() {
        WebElement goToCheckout = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to Checkout")));
        goToCheckout.click();
    }

    @Then("the shopping cart should have this item")
    public void result() {
        WebElement itemInCart = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_page_container")));
        Assert.assertTrue(itemInCart.getText().contains("iPhone 4S"));
    }

    /**
     * *
     * Scenario 2
     */
    @Given("there is one iPhone 4S in the cart")
    public void shoppingCart() {
        String shoppingCart_PAGE = "http://store.demoqa.com/?s=iphone&post_type=wpsc-product";
        System.setProperty("webdriver.gecko.driver", "/Users/davidzhang/NetBeansProjects/QA_Deliverable3_David/libs/geckodriver");
        driver = new FirefoxDriver();
        driver.get(shoppingCart_PAGE);
        wait = new WebDriverWait(driver, 30);
        WebElement addToCart = driver.findElement(By.xpath("//input[contains(@value, 'Add To Cart')]"));
        addToCart.submit();
        WebElement goToCheckout = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to Checkout")));
        goToCheckout.click();

    }

    @When("user update the quantity to three")
    public void updateQuantity() {
        WebElement currentQuantity = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name, 'quantity')]")));
        currentQuantity.clear();
        currentQuantity.sendKeys("3");
        WebElement updateQuantity = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@value, 'Update')]")));
        updateQuantity.click();
    }

    @Then("there should be three items in the cart")
    public void resultForQuantity() {
        WebElement resultForQuantity = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name, 'quantity')]")));
        assertEquals("3", resultForQuantity.getAttribute("value"));
    }

    /**
     * *
     * Scenario 3
     */
    @Given("I have added iPhone 4S to shopping cart")
    public void addiPhone4SForStart() {
        String iPhone_PAGE = "http://store.demoqa.com/?s=iphone&post_type=wpsc-product";
        System.setProperty("webdriver.gecko.driver", "/Users/davidzhang/NetBeansProjects/QA_Deliverable3_David/libs/geckodriver");
        driver = new FirefoxDriver();
        driver.get(iPhone_PAGE);
        wait = new WebDriverWait(driver, 30);
        WebElement addToCart = driver.findElement(By.xpath("//input[contains(@value, 'Add To Cart')]"));
        addToCart.submit();

    }

    @When("I choose to continue shopping")
    public void continueShopping() {
        WebElement continueShopping = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Continue Shopping")));
        continueShopping.click();

    }

    @And("I add iPhone 5 into shopping cart")
    public void addiPhone5() {
        WebElement addToCart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@value, 'Add To Cart')])[3]")));
        addToCart.submit();
    }

    @Then("the store should have both the two items")
    public void resultForThis() {
        WebElement goToCheckout = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to Checkout")));
        goToCheckout.click();
        WebElement itemInCart = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_page_container")));
        Assert.assertTrue(itemInCart.getText().contains("iPhone 5"));
        WebElement subTotal = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_page_container")));
        Assert.assertTrue(subTotal.getText().contains("$282.00"));

    }

    /**
     * *
     * Scenario 4
     */
    @Given("There is one iPhone 4S in the shopping cart")
    public void prepareToDelete() {
        String shoppingCart_PAGE = "http://store.demoqa.com/?s=iphone&post_type=wpsc-product";
        System.setProperty("webdriver.gecko.driver", "/Users/davidzhang/NetBeansProjects/QA_Deliverable3_David/libs/geckodriver");
        driver = new FirefoxDriver();
        driver.get(shoppingCart_PAGE);
        wait = new WebDriverWait(driver, 30);
        
        WebElement addToCart = driver.findElement(By.xpath("//input[contains(@value, 'Add To Cart')]"));
        addToCart.submit();

        WebElement goToCheckout = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Go to Checkout")));
        goToCheckout.click();

    }

    @When("I would like to remove this item")
    public void removeItem() {
        
        WebElement removeItem = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@value, 'Remove')]")));
        removeItem.click();
    }

    @Then("the store should delete the item in the shopping cart")
    public void resultForRemove() {
//        WebElement resultForRemove = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_page_container")));
        WebElement resultForRemove = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'entry-content')]")));
//        System.out.print("------->" + resultForRemove.getText());
//        assertEquals("Oops, there is nothing in your cart.", resultForRemove.getText());
        Assert.assertTrue(resultForRemove.getText().contains("Oops, there is nothing in your cart."));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

}
