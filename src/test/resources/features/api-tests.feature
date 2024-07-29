Feature: Test signup and login functionality via API

  Scenario Outline: Create and login user
    Given url 'https://api.demoblaze.com/signup'
    And request { "username": "<username>", "password": "<password>" }
    When method post
    Then status 200
    And match response.message == 'Sign up successful'

    Given url 'https://api.demoblaze.com/login'
    And request { "username": "<username>", "password": "<password>" }
    When method post
    Then status 200
    And match response.message == 'Login successful'

    Examples:
      | username | password   |
      | newuser  | password123|
      | username    | password|
