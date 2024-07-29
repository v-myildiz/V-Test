                        # ATLAS - 1527

Feature: Data Access Permission Test n3

Scenario: User Company Permission: (View Only) Help & Feedback Button Display
Given Login to the website as an User(n3).
Then The user should be able to display the Help & Feedback button on all pages in the sidebar.
Then The user should click the Help & Feedback button and display the content on all pages without permission switch.