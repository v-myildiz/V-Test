@profile
Feature: Profile Settings Check After Changes n2

  Scenario: Check Profile Settings After Changes
    Given Login to the website as an User(n2).
    Then  The user changes the Full Name "Tester01" and check.
    Then  The user changes the Show Cookie Preferences and check.
