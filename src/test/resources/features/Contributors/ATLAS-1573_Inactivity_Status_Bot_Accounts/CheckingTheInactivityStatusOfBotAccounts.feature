@[bot]                # ATLAS- 1573
Feature: [bot] Contributors Passive Test n2

  Scenario: Check When First Project Added [bot] Contributors Are Passive.
    Given Login to the website as an User(n2).
    When The user selects company "V-Test" and goes to page "Contributors".
    Then The user selects a project "[bot] Action GH Release".
    Then The user clicks Manage Contributors Button.
    Then The user writes "jack" into the search box.
    Then The user checks [bot] contributors who were passive.
    Then The user changes [bot] contributors as an active.
    Then The user checks [bot] contributors are active.
