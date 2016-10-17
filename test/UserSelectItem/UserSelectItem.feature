#----------------------------------
# Empty Cucumber .feature file
#----------------------------------

Feature: User Search
   As a user, I would like to select items, so that 
   I can purchase. 

      Scenario: Select iPhone 4S and add to cart
      Given customers looking at iPhones
      When they  add "iPhone 4S" to cart 
      And they choose to go to checkout
      Then the shopping cart should have this item

      Scenario: Update item quantity in the cart
      Given there is one iPhone 4S in the cart 
      When user update the quantity to three
      Then there should be three items in the cart
   
      Scenario: Continuing shopping
      Given I have added iPhone 4S to shopping cart
      When I choose to continue shopping
      And I add iPhone 5 into shopping cart
      Then the store should have both the two items

      Scenario: Remove Item
      Given There is one iPhone 4S in the shopping cart
      When I would like to remove this item
      Then the store should delete the item in the shopping cart
    

   
