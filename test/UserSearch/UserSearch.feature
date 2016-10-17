#----------------------------------
# Cucumber .feature file
#----------------------------------
   
Feature: User Search
   As a user, I should be able to search items, so that 
   I can see the information on the items. 

      Scenario: Search iPhone 5
      Given users go to the store
      When they search for "iPhone 5"
      Then the store should return results of "iPhone 5"

      Scenario: Search not exsiting item
      Given users going to the store 
      When they search for "pen"
      Then the store should return "Sorry, but nothing matched your search criteria. Please try again with some different keywords."
   
      Scenario: Search Nothing but press return directly
      Given I go to the store
      When I input nothing in the search textbox
      Then the store should return all kinds of items in the store

      Scenario: Search Category
      Given I going to the store
      When I would like to input "ipad" in the search textbox
      Then the store should return all ipads in the store