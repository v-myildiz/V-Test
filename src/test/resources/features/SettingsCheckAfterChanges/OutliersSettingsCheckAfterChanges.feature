@outliers
Feature: Outliers Settings Check After Changes n2

  Scenario: Check Outliers Settings After Changes
    Given Login to the website as an User(n3).
    Then  The user changes the PR Outliers Title "Test" and check.
    Then  The user changes the PR Outliers Label "test" and check.
    Then  The user changes the Commit Outliers "bug" and check.
    Then  The user changes the File Count "1" and check.