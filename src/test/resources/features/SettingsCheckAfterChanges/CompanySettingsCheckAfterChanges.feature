@company
Feature: Company Settings Check After Changes n2

  Scenario: Check Company Settings After Changes
    Given Login to the website as an User(n2).
    Then  The user changes the Company Name "V-Test" and check.
    Then  The user changes the Industry "Education" and check.
    Then  The user changes the Timezone "Europe/Berlin" and check.
    Then  The user changes the Working Days "Monday","Tuesday","Wednesday","Thursday","Friday" and check.
    Then  The user changes the Working Hours "11:00" and "13:00" and check.
    Then  The user changes the Average Man Day Cost "100" and check.
    Then  the user changes the Two-Factor Authentication and check.




