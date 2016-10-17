#----------------------------------
# Empty Cucumber .feature file
#----------------------------------
    
Feature: User Login
As a user, I should be able to log into my account, so that 
I can see my account status. 

	Scenario: Login with correct username and password
		Given a correct username and a correct password
                When I try to login with those credentials
                Then I should login successfully

        Scenario: Login with correct username and incorrect password
		Given a correct username and an incorrect password
                When I try to login with correct username and incorrect password
                Then I should see an error message

#         Scenario: Login with incorrect username and correct password
# 		Given an incorrect username and an correct password
#                 When I try to login with incorrect username and correct password
#                 Then I should see an error message again


   
