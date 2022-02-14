@Navigation
Feature: Navigation Menu
  @Vehicle
  Scenario: Navigating fleet to vehicle
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Fleet, Vehicle
    Then the title should be Vehicles

  @Campaigns
  Scenario: Navigating marketing to campaigns
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Marketing, Campaigns
    Then the title should be Campaigns

  @Calendar
  Scenario: Navigating  Activities to Calendar Events
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Activities , Calendar Events
    Then the title should be Calendar Events