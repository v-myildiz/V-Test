@connectedApps              # ATLAS - 1205
Feature: Connected Apps Disconnect Test n2

  Scenario: Check disconnection of connected applications.
    Given Login to the website as an User(n2).
    When The user selects company "V-Test" and goes to page "Connected Applications".
    Then If GitHub loses connection, the user should be able to disconnect.
    Then If GitHub Enterprise loses connection, the user should be able to disconnect.
    Then If Bitbucket Cloud loses connection, the user should be able to disconnect.
    Then If Bitbucket Server loses connection, the user should be able to disconnect.
    Then If GitLab loses connection, the user should be able to disconnect.
    Then If GitLab Server loses connection, the user should be able to disconnect.
    Then If Azure Repos loses connection, the user should be able to disconnect.
    Then If Jira Cloud loses connection, the user should be able to disconnect.
    Then If Jira Server loses connection, the user should be able to disconnect.
    Then If YouTrack Server loses connection, the user should be able to disconnect.
    Then If Linear loses connection, the user should be able to disconnect.
    Then If ClickUp loses connection, the user should be able to disconnect.
    Then If Jenkins loses connection, the user should be able to disconnect.
    Then If Travis CI loses connection, the user should be able to disconnect.
    Then If Circle CI loses connection, the user should be able to disconnect.
    Then If Azure Pipelines loses connection, the user should be able to disconnect.
    Then If Slack loses connection, the user should be able to disconnect.


