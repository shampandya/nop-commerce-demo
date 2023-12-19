Feature: ComputerPage Feature
  In Order to perform successful shopping experience
  As a User
  I should able to buy desiered computer
@smoke @sanity @regression
  Scenario: User should navigate to Computer page successfully
    Given I am on homepage
    When I click on Computer link
    Then I verify text "Computers"

  @smoke @regression
  Scenario: User should navigate to Desktops page successfully
    Given I am on homepage
    When I click on Computer link
    And I click on Desktop link
    Then I verify "Desktops"

  @regression
  Scenario Outline: Verify That User Should Build You Own Computer And Add Them To Cart Successfully
    Given   I am on homepage
    When    I click on Computer link
    And     I click on Desktop link
    And     I Click on product name "Build your own computer"
    And     I select processoe "<processor>"
    And     I select RAM "<ram>"
    And     I select HDD "<hdd>"
    And     I select OS "<os>"
    And     I select Software "<software>"
    And     I click on Add to Cart Button
    Then    I Verify message "The product has been added to your shopping cart"

    Examples:
      | processor                                       | ram           | hdd               | os                      | software                    |
      | 2.2 GHz Intel Pentium Dual-Core E2200           | 2 GB          | 320 GB            | Vista Home [+$50.00]    |  Microsoft Office [+$50.00] |
      | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 4GB [+$20.00] | 400 GB [+$100.00] | Vista Premium [+$60.00] | Acrobat Reader [+$10.00]    |
      | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 8GB [+$60.00] | 320 GB            | Vista  Home [+$50.00]   | Total Commander [+$5.00]    |
