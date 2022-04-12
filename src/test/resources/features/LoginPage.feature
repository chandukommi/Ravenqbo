Feature: Login page feature

@Regression
Scenario: Login page title
	Given user is on the login page
	When user gets the title of the page
	And page title should be "Raven - qbo"

@Regression
Scenario: Login with correct credentials
	Given user is on the login page
	When user enters the following credentials for Login
      | username | password      |
      | vinay     |  Admin1  |
  And user click on login button
  Then page should contain "Vinay" text
  Then user gets the title of the page
  And page title should be "Raven - qbo"

