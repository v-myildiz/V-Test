@dora
Feature: DORA Settings Check After Changes n2

  Scenario: Check DORA Settings After Changes
    Given Login to the website as an User(n3).
    Then  The user changes the Release Detection Merge Pull Request "pullrequest1.*" and check.
    Then  The user changes the Failure Detection Issue Title "issue1.*" and check.
    Then  The user changes the Recover Detection Destination Branch "branch1.*" and check.
