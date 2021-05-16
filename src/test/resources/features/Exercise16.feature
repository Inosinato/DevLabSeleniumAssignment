Feature: Exercise 16

@Base
  Scenario: Login and click on Admin menu
    Given I am in OrangeHR Application
    Then I login to Application
    When The dashboard page is available
    And I click on admin menu
