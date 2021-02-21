#Author: Mitesh Mishra
 @PerTest
Feature: To verify the case flow in SFDC

Scenario:caseflow_001: find the time taken to search flights
    Given user has a valid URL and is on Mercury Tours' homepage
    |URL|
    |http://demo.guru99.com/test/newtours/index.php|
    When user goes to flight section and enter flight details to hit search
    Then Print the time taken to perform search

