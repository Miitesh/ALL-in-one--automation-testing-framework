#Author: Mitesh Mishra

@UITest
Feature: Title of your feature
  I want to use this template for my feature file

  
  Scenario: to verify the title of the website
    Given user has a valid URL
    |URL|
    |http://demo.guru99.com/test/newtours/index.php|
    When user goes to Mercury Tours' homepage
    Then verify the title of the website
   
Scenario: to verify the title of the website
    Given user on Mercury Tours' homepage
    When user goes to flight section and enter flight details to search
    Then verify the result of search is displayed
 