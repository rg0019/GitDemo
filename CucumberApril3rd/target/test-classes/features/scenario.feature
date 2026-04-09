Feature: Feature file for login functionality

@login
Scenario: Valid Login Scenario
Given User is on the login page
When User enters credentials
Then User is on the home page


@automation
Scenario: User searches for an item
Given User is on the Automation Practice Home Page
When User searches for an item
Then Results are displayed on the screen


