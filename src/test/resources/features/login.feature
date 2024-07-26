Feature: Test login functionality on demoblaze.com

  Scenario: Correct username and password in login
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be logged in successfully

  Scenario: Incorrect username and password in login
    Given the user is on the login page
    When the user enters invalid credentials
    Then an error message should be displayed