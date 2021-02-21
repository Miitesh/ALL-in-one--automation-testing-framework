#Author: Mitesh Mishra
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>

@APITest 
Feature: Test Rest API

 
Scenario: to verify the response of Rest API
    Given User has valid API url and request details
    |Method|URL|
    |GET|https://api.covid19tracker.ca/summary|
    When User send request to canandianCovid-19 sumaary API
    Then Verify the response status code is 200 Ok


  