Feature: Sign In

@TS_001
@SmokeTest
Scenario: User able to Sign In with valid credential and verify the home page
Given Users can open any browser
And Users able to enter url as "https://www.zoopla.co.uk/"
When Users able to click Sign In button
And Users enter valid username as "hossain.smarttech2020@gmail.com" and password as "sazzad2020" 
And Users click the Sign In button
Then Users can verify Sign In page
And Users can close the browser
@TS_002
@NegativeTest
Scenario Outline: User able to Sign In with valid credential and verify the home page
Given Users can open any browser
And Users able to enter url as "https://www.zoopla.co.uk/"
When Users able to click Sign In button
And Users enter valid username as "<uname>" and password as "<pwd>" 
And Users click the Sign In button
Then Users can verify Sign In page
And Users can close the browser

Examples:
|uname                          |    pwd   |
|hossain.smarttech2020@gmail.com|sazzad2020|
|hossain.smarttech2020@gmail.com|sazzad2021|
|hossain.smarttech2021@gmail.com|sazzad2020|


@FuntionalTest
Scenario: Users can login to the application, search the location, select the fifth property
Given Users is able to verify login information successfully
When Users can hover over the page on the For Sale module and click on the UK Property for
And Users is able to enter location- "New York, Lincolnshire" in the next box & hit enter
And Users is able to print all value or price of the properties in the console
And Click on the fifth Property from the Properties list
And Users is able to print out the selected property details
Then Users can Verify the price of the selected property
And User is able to logout the application
