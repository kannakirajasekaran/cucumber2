@all
Feature: User Login
Registered User should be able to login to access account details

#below background gherkin keyword is execute before each scenario
Background:
Given User navigates to Login page

@login @validcredentials @smoke @regression
Scenario Outline: Login with valid credentials
When User enters valid email address <username> into email field
And Enter valid password <password> into password field
And Click on Login button
Then User should login successfully
Examples:
|username 						 |password|
|amotooricap3@gmail.com|12345		|
|amotooricap2@gmail.com|12345		|
|amotooricap1@gmail.com|12345		|

@login @invalidcredentials @smoke @regression @dev
Scenario: Login with invalid credentials
When User enters invalid email address into email field
And Enter invalid password "123455678" into password field
And Click on Login button
Then User should get a proper warning message about credentials mismatch

@login @invalidemailaddress @regression @wip
Scenario: Login with invalid email address and valid password
When User enters invalid email address into email field
And Enter valid password "12345" into password field
And Click on Login button
Then User should get a proper warning message about credentials mismatch

@login @invalidpassword @regression @ignore
Scenario: Login with valid email address and invalid password
When User enters valid email address "amotooricap3@gmail.com" into email field
And Enter invalid password "123455678" into password field
And Click on Login button
Then User should get a proper warning message about credentials mismatch

@login @nocredentials @regression
Scenario: Login without providing any credentials
When User donot enters email address into email field 
And User donot enters password into password field 
And Click on Login button
Then User should get a proper warning message about credentials mismatch