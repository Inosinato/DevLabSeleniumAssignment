Feature: Exercise 17

Background: 
	Given I am login in OrangeHR Application

  @Base
  Scenario: Validate job name
    Given I click on Admin link
    Then I click on Job
    And validate text "Content Specialist"