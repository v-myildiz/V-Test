@caseInSensitive               # ATLAS - 1983
Feature: Case-Insensitive Search Test n2

  Scenario: Case-Insensitive Search in Atlas Pages
    Given Login to the website as an User "n2".
    When The user selects company "V-Test" and goes to page "Insights".
    Then The user searches the Insights Page and ensures that all results are Case-Insensitive.
    Then The user searches the DORA Page and ensures that all results are Case-Insensitive.
    Then The user searches the Resource Distribution Page and ensures that all results are Case-Insensitive.
    Then The user searches the Sprint Page and ensures that all results are Case-Insensitive.
    Then The user searches the Contributors Page and ensures that all results are Case-Insensitive.
    Then The user searches the Projects Page and ensures that all results are Case-Insensitive.
    Then The user searches the Automations Page and ensures that all results are Case-Insensitive.
    Then The user searches the Settings Page and ensures that all results are Case-Insensitive.
    Then The user searches the User Management Page and ensures that all results are Case-Insensitive.


