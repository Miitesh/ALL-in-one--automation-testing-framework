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
@Rest 
Feature: Test Rest API

 
  Scenario: to verify the response of Rest API
    Given User has valid API url and request details
    |Method|RequestBody|URL|
    |PATCH|globalcustomername.json|https://cs37.salesforce.com/services/apexrest/v1/accounts|
    When User send request to GlobalCustomerName API
    Then Verify the response status code is 200 Ok

Scenario:CaseAPI_002: Verify getcase api call in CaseAPI
    Given User have valid end point for API
    |CaseAPI|
    |getCase|
    When User makes a call to API with following parameter
    |ssoName|caseNum|
    |rhn-support-kmashalk|02470917|
    Then verify status code is 200 OK 
    And verify fields in response body
    |caseNumber|accountNumber|product|version|status|owner|origin|contactName|description|

  