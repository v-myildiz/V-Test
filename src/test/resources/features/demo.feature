@deneme
Feature: Issue Link Insights Test n2

  Scenario: "Insight Warning" check of the person not involved in a project with an "Issue Repo" not attached.
    Given Login to the website as an User(n2).
    When The user selects company "Bahce" and goes to page "Contributors".
    Then The user selects a contributor who involved in a project with an Issue Repo not attached.
    Then The user checks that Issue Insights Warning is not Displayed in Contributor Insights.





