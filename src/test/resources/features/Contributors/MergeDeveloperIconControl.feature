@mergeDeveloper
Feature: Merge Developer Icon Test Test n2

  Scenario: Check Merge Developer Icon
    Given Login to the website as an User(n2).
    When The user selects company "V-Test" and goes to page "Contributors".
    Then The user clicks Manage Contributors Button.
    Then The user hovers over the Show Suggestions Button and displays the Merge Icon.
    Then The user clicks the Show Suggestions Button and displays the Loading Icon or Suggestion Table during installation.


