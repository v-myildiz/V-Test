@teams
Feature: Teams Settings Check After Changes n2

  Scenario: Check Teams Settings After Changes
    Given Login to the website as an User(n2).
    Then  The user imports the Team From Repositories "core" and check.
    Then  The user creates the New Team "Team1" and check.
