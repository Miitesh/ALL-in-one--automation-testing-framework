#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag1
Feature: This feature file is to test all email related scenarios


 Scenario: to verify Fromaddress in email generated from case update to customer.
    Given User has a valid SFDC credential
    |Username|Password|
    |rhn-support-kmashalk|redhat|
    When User perform action on case such as case comment
    |CaseNumber|
    |02470917|
    Then Verify the from address in email which the customer receive
    |support.pilot@redhat.com|
     
 Scenario: to verify Fromaddress in email sent to customer when case is closed
    Given User is on the same case page
    When User closes the case
    Then Verify that from address in email which the customer receive on case closure
    |support.pilot@redhat.com|
    
 