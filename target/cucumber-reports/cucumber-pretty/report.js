$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("EmailTest.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "This feature file is to test all email related scenarios",
  "description": "",
  "id": "this-feature-file-is-to-test-all-email-related-scenarios",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@tag1"
    }
  ]
});
formatter.before({
  "duration": 4355490,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "to verify Fromaddress in email generated from case update to customer.",
  "description": "",
  "id": "this-feature-file-is-to-test-all-email-related-scenarios;to-verify-fromaddress-in-email-generated-from-case-update-to-customer.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "User has a valid SFDC credential",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ],
      "line": 25
    },
    {
      "cells": [
        "rhn-support-kmashalk",
        "redhat"
      ],
      "line": 26
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "User perform action on case such as case comment",
  "rows": [
    {
      "cells": [
        "CaseNumber"
      ],
      "line": 28
    },
    {
      "cells": [
        "02470917"
      ],
      "line": 29
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "Verify the from address in email which the customer receive",
  "rows": [
    {
      "cells": [
        "support.pilot@redhat.com"
      ],
      "line": 31
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "EmailTest.user_has_a_valid_SFDC_credential(DataTable)"
});
formatter.result({
  "duration": 38417462678,
  "status": "passed"
});
formatter.match({
  "location": "EmailTest.user_perform_action_on_case_such_as_case_comment(DataTable)"
});
formatter.result({
  "duration": 70293640012,
  "status": "passed"
});
formatter.match({
  "location": "EmailTest.verify_the_from_address_in_email_which_the_customer_receive(DataTable)"
});
formatter.result({
  "duration": 3035401496,
  "status": "passed"
});
formatter.after({
  "duration": 18973,
  "status": "passed"
});
formatter.before({
  "duration": 1234305,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "to verify Fromaddress in email sent to customer when case is closed",
  "description": "",
  "id": "this-feature-file-is-to-test-all-email-related-scenarios;to-verify-fromaddress-in-email-sent-to-customer-when-case-is-closed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 34,
  "name": "User is on the same case page",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "User closes the case",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "Verify that from address in email which the customer receive on case closure",
  "rows": [
    {
      "cells": [
        "support.pilot@redhat.com"
      ],
      "line": 37
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "EmailTest.user_is_on_case_page()"
});
formatter.result({
  "duration": 3058624333,
  "status": "passed"
});
formatter.match({
  "location": "EmailTest.user_closes_the_case()"
});
formatter.result({
  "duration": 4512374762,
  "status": "passed"
});
formatter.match({
  "location": "EmailTest.verify_the_from_address_in_survey_email_which_the_customer_receive(DataTable)"
});
formatter.result({
  "duration": 1361261415,
  "status": "passed"
});
formatter.after({
  "duration": 16036,
  "status": "passed"
});
});