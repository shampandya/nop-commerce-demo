Feature: Register Feature
  In Order to perform successful Registration
  As a User
  I have to enter correct details on given fields

  @smoke @sanity @regression
  Scenario: User should navigate to Register page successfully
  Given I am on homepage
  When I click on Register link
  Then I verify "Register" text

  @smoke @regression
  Scenario: verify that FirstName LastName Email Password And ConfirmPassword Fields Are Mandatory
    Given I am on homepage
    When I click on Register button
    Then I get Validation Error Message For Field ("FirstName", "LastName", "Email","Password", "ConfirmPassword" )

  @regression
  Scenario: Verify that user should create account successfully
    Given I am on homepage
    When I click on Register link
    And I select gender "Female"
    And I enter firstname "vilapp"
    And I enter lastname "vani"
    And I enter date of birth  "Day", "Month", "Year"
    And I enter email "Dhyan@grr.la"
    And I enter password "yaniU@123"
    And I enter confirm Password "yaniU@123"
    And I click on Register button
    Then I should see the message "Your registration completed"

