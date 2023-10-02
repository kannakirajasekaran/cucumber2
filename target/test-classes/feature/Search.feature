@all
Feature: Search funtionality

Background:
Given User open the application

@search @validproduct @smoke @regression
Scenario: Search for valid product
When User enters the valid product "HP" in search field
And Click on search button
Then Valid product should get displayed in the search result 

@search @nonexsitingproduct @regression
Scenario: Search for non-exsiting product
When User enters non existing product "honda" in search field
And Click on search button
Then Proper text informing there is no product that matches ur search criteria 

@search @noproduct @regression
Scenario: Search without providing any product
When User dont enters product in search field
And Click on search button
Then Proper text informing there is no product that matches ur search criteria 