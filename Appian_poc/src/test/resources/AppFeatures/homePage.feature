Feature: To verify the functionality on the Amazon Application

  Background: 
    Given I launch Chrome Browser

  Scenario: Login to Application
    Given user is on Login page
    When User Enter UserName
    And I click on continue button
    And User Enter Password
    And I click on signin button
    Then I should see Home Page 
    When I search product 
    Then I verfiy List of product 
    When I click on List of product
    Then I verify The product selected
    When I click on buynow
    Then I should see address details screen
  
