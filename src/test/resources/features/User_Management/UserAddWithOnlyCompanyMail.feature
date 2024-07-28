@userAdd
Feature: User Add Only via Company Mail Test n2

  Scenario: Check User Add Only via Company Mail
    Given Login to the website as an User(n2).
    When The user selects company "V-Test" and goes to page "User Management".
    Then The user shouldn't add a new user "Test-01" with a constant patter email "valven@mailinator.com".
    Then The user shouldn't add a new user "Test-02" with a free email "valven@gmail.com".
    Then The user should add a new user "Test-03" with an email that may be a company email "valven@gmailvalven.com".


