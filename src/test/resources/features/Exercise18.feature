@Base
Feature: Custom Exercise

Background: 
	Given I have log into OrangeHR Application

  @Smoke @Regression
  Scenario: ex1
    When I click on Time menu
    Then Attendance menu is displayed

  @Smoke @Regression
  Scenario: ex2
    When I click on Admin menu
    Then Qualifications menu is displayed
    
    @Smoke @Regression
  Scenario: ex3
    When I click on PIM menu
    Then Employee List menu is displayed
    
    @Smoke @Regression
  Scenario: ex4
    When I click on Time menu
    Then Reports menu is displayed
  