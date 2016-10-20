# QA_Deliverable3_David

IS2545 - DELIVERABLE 3: System Testing

This assignment is for system testing on a given web site: http://store.demoqa.com/. I use Cucumber & Selenium framework to drive my testing. Cucumber is a very cool tool which allows tester to define the steps of test in a user perspective.

In this assignment, I was able to learn how system testing looks like. The user story and sceanrios for each of them describe the features in a user level thus enable users to understand as the testing process goes.

The issues I encountered in this assignment are as follows,

1. The Geckodriver for mac is different from that on windows system. In order to fulfill this requirement, I download the Geckodriver from https://github.com/mozilla/geckodriver/releases and change the System.setProperty in the code accordingly, and then the code can work properly.

2. In the UserSearch test, I tried to test if user can search items in the search engine on the web pages. I need to clear the hiden words "Search Products" in the textbox before input any search to make sure the search box is receiving correct input. And because there is no button to click for search after your input, I need to use Return button. The code for this piece is as below: 
        
        WebElement search = driver.findElement(By.xpath("//input[contains(@value, 'Search Products')]"));
        search.clear();
        search.sendKeys("iPhone 5");
        search.sendKeys(Keys.RETURN);      
   
3. In the web site system test, there are lots of places I need to use findelement(By.id) or (By.xpath). Some of the xpath are little bit difficult to define due to the deep depth of the element I want to find. However, the xpath by attribute selector and by text() are convenient for this. Such as, 

  By.xpath("//input[contains(@value, 'Search Products')]")
  
  By.xpath("//*[text()='Sorry, but nothing matched your search criteria. Please try again with some different keywords.']" 
  
  Although there are wonderful tool in Chrome to generate xpath automatically, I decide to get the xpath by myself in order to learn how to use it.

4. The scenario 4 for UserSelectItem feature got fail. When the user click remove button in the shopping cart, the store should delete the item and if there was only one item in it before, the web site should show "Oops, there is nothing in your cart." However, in my test for this, the test returns that this item is in the shopping cart even though the web page is shown nothing in the shopping cart. This occurs when I select an element via the webdriver (either by findElement or some other method) and then after I've selected the element the website updates the element. Now the element I selected and the actual element displayed in the browser are out of sync. To fix this, I used the WebDriverWait to wait until the element is completely done rendering.

After adding the following line, it can work:

wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//div[contains(@class, 'entry-content')]")).getText().equals("Oops, there is nothing in your cart."));
