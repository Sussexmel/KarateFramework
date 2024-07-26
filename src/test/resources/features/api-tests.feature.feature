Feature: Test signup and login functionality via API

  Scenario: Create a new user
    Given url 'https://www.demoblaze.com/index.html'
    And request { "username": "newuser", "password": "password123" }
    When method post
    Then status 200
    And match response.message == 'Sign up successful'

  Scenario: Try to create an existing user
    Given url 'https://www.demoblaze.com/index.html'
    And request { "username": "existinguser", "password": "password123" }
    When method post
    Then status 400
    And match response.message == 'User already exists'

  Scenario: Correct username and password in login via API
    Given url 'https://www.demoblaze.com/index.html'
    And request { "username": "newuser", "password": "password123" }
    When method post
    Then status 200
    And match response.message == 'Login successful'

  Scenario: Incorrect username and password in login via API
    Given url 'https://www.demoblaze.com/index.html'
    And request { "username": "wronguser", "password": "wrongpassword" }
    When method post
    Then status 401
    And match response.message == 'Invalid username or password'
