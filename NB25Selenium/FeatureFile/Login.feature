
Feature: As a user I want to provide valid credential so that I can login to my account home page.

@smoke @regression
Scenario: User provide valid credentials
  Given User opens the application in chrome browser
  When  User clicks on sign in button
  And 	Enter valid credentials and click Sign in button
  Then 	User is successfully logged in to my account home page 
 
@regression   
Scenario Outline: User provide invalid credentials
  Given User opens the application in chrome browser
 	When 	User clicks on sign in button
 	And 	Enter invalid userName<"userName"> and password <"password">
 	And 	Click sign in button
  Then 	Verify the user is given error

  Examples: 
      | userName  			| password |
      | abc@test.com 		| inavlid1 |
      | valid@test.com 	| inavlid2 |
      | invalid@test.com| validPass|
