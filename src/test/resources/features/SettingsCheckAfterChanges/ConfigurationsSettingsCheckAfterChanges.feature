@configurations
Feature: Configurations Settings Check After Changes n2

  Scenario: Check Configurations Settings After Changes
    Given Login to the website as an User(n2).
    Then  The user edits Bug Mapping and check.
    Then  The user edits Feature Mapping and check.
    Then  The user edits Improvement Mapping and check.
    Then  The user edits Task Mapping and check.
    Then  The user edits Epic Mapping and check.
    Then  The user edits Open Mapping and check.
    Then  The user edits In Progress Mapping and check.
    Then  The user edits Closed Mapping and check.
    Then  The user edits Analysis Mapping and check.
    Then  The user edits UX/UI Mapping and check.
    Then  The user edits Development Mapping and check.
    Then  The user edits Review Mapping and check.
    Then  The user edits QA Mapping and check.
    Then  The user edits CI/CD Mapping and check.

