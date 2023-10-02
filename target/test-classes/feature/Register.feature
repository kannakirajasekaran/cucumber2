@all
Feature: User Registeration Functionallity

Background:
Given User navigate to Register page

@register @mandatoryfields @smoke @regression
Scenario: Register with mandatory fields
When User enters the below details
|FirstName      	|prabhu|
|LastName       	|kanna|
|phone          	|1234567890|
|password					|12345|
And Select Privacy Policy field
And Click on continue button
Then User account should created successfully

@register @allfields @smoke @regression
Scenario: Register with all fields
When User enters the below details
|FirstName      	|prabhu|
|LastName       	|kanna|
|phone          	|1234567890|
|password					|12345|
And Select the Yes option in Newsletter
And Select Privacy Policy field
And Click on continue button
Then User account should created successfully

@register @nofields @regression
Scenario: Register without providing any fields
When User dont enter details into any fields
And Click on continue button
Then User should get proper warning message for every mandatory field

@register @duplicateEmail @regression
Scenario: Register with duplicate email address
When User enters the below details with duplicated email address
|FirstName      	|kandiyar           			|
|LastName       	|kids        							|
|email          	|amootoricap1@gmail.com	|
|phone          	|1234567891       			|
|password					|12345            			|
And Select the Yes option in Newsletter
And Select Privacy Policy field
And Click on continue button
Then Warning message about duplicate email address 
