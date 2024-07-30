@issueTest          # ATLAS - 1943
Feature: Issue Link Insights Test n2

  Scenario: Check Issue Link Insights with Git/Issue Repo
    Given Login to the website as an User(n2).
    When The user selects company "V-Test" and goes to page "Insights".
    Then The user selects a project with Git and Issue repos Issue Link Insight Test with Git/Issue Repo.
    Then The user checks that Issue Insights Warning is Displayed in Dev. Behaviors.

  Scenario: Check Issue Link Insights with Git without Issue Repo
    Given Login to the website as an User(n2).
    When The user selects company "V-Test" and goes to page "Insights".
    Then The user selects a project with Git and without Issue repos Issue Link Insight Test with Git without Issue Repo.
    Then The user checks that Issue Insights Warning is not Displayed in Dev. Behaviors.

  Scenario: Check "Contributor Insights Warning" who involved project with "Issue Repo"
    Given Login to the website as an User(n2).
    When The user selects company "V-Test" and goes to page "Contributors".
    Then The user selects a contributor who involved in a project with an Issue Repo attached.
    Then The user checks that Issue Insights Warning is Displayed in Contributor Insights.

  Scenario: Check "Contributor Insights Warning" who involved project without "Issue Repo"
    Given Login to the website as an User(n2).
    When The user selects company "Bahce" and goes to page "Contributors".
    Then The user selects a contributor who involved in a project with an Issue Repo not attached.
    Then The user checks that Issue Insights Warning is not Displayed in Contributor Insights.


