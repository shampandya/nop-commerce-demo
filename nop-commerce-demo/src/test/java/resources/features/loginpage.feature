
Feature: Login Feature
  In Order to perform successful login
  As a User
  I have to enter correct username and password

  @smoke @sanity @regression
  Scenario: User should navigate to login page successfully
    Given I am on homepage
    When I click on login link
    Then I verify the message "Welcome, Please Sign In!"

  @smoke @regression
  Scenario: Verify the error message with invalid credentials
    Given I am on homepage
    When I click on login link
    And I enter email "sita@gmail.com"
    And I enter password "123456@sita"
    And I click on login button
    Then I should see the error message "Login was unsuccessful."


  @regression
  Scenario: User should log in successfully with valid credentials
    Given I am on homepage
    When I click on login link
    And I enter email "sitagita@gmail.com"
    And I enter password "12345@sita"
    And I click on login button
    Then I should log in successfully
    And verify its display "Log out" link


  @regression
  Scenario: Verify That User Should LogOut SuccessFully
    Given I am on homepage
    When I click on login link
    And I enter email "sitagita@gmail.com"
    And I enter password "12345@sita"
    And I click on login button
    Then Click on LogOut Link
    And verify its display loginLink "Log in"
