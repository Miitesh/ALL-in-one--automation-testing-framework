$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PerformanceTest.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Mitesh Mishra"
    }
  ],
  "line": 3,
  "name": "To verify the case flow in SFDC",
  "description": "",
  "id": "to-verify-the-case-flow-in-sfdc",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@PerTest"
    }
  ]
});
formatter.before({
  "duration": 6870344,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "caseflow_001: find the time taken to search flights",
  "description": "",
  "id": "to-verify-the-case-flow-in-sfdc;caseflow-001:-find-the-time-taken-to-search-flights",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "user has a valid URL and is on Mercury Tours\u0027 homepage",
  "rows": [
    {
      "cells": [
        "URL"
      ],
      "line": 7
    },
    {
      "cells": [
        "http://demo.guru99.com/test/newtours/index.php"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user goes to flight section and enter flight details to hit search",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Print the time taken to perform search",
  "keyword": "Then "
});
formatter.match({
  "location": "PerformanceTest.user_has_a_valid_URL_and_is_on_Mercury_Tours_homepage(DataTable)"
});
formatter.write("Time Taken to open website");
formatter.write("\n");
formatter.write("6");
formatter.result({
  "duration": 8733827295,
  "status": "passed"
});
formatter.match({
  "location": "PerformanceTest.user_goes_to_flight_section_and_enter_flight_details_to_hit_search()"
});
formatter.result({
  "duration": 1514484374,
  "status": "passed"
});
formatter.match({
  "location": "PerformanceTest.print_the_time_taken_to_perform_search()"
});
formatter.write("Time Taken to go to Flight section");
formatter.write("1");
formatter.result({
  "duration": 110121639,
  "status": "passed"
});
formatter.after({
  "duration": 114271,
  "status": "passed"
});
});