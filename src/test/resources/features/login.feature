Feature: Test login functionality on demoblaze.com

  Scenario Outline: User login
    Given user data is loaded
    And the user is on the login page
    When the user logs in with "<type>"
    Then the user should be logged in successfully

    Examples:
      | type   |
      | valid  |
      | invalid|
