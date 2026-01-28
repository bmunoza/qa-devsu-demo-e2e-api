Feature: Login de usuarios en Demoblaze

  Background:
    * def prevusername = 'user_karate_123'
    * def password = '123456'

  Scenario: Login exitoso
    Given url baseUrl + '/login'
    And request { username: '#(prevusername)', password: '#(password)' }
    When method post
    Then status 200
    And match response contains 'Auth_token'

  Scenario: Usuario y password incorrecto en login
    * def username = 'brayan_' + java.util.UUID.randomUUID()

    Given url baseUrl
    And path 'signup'
    And request { username: '#(username)', password: '#(password)' }
    When method post
    Then status 200

    Given url baseUrl
    And path 'login'
    And request { username: '#(username)', password: 'WRONG_PASS' }
    When method post
    Then status 200
    And match response.errorMessage contains 'Wrong password'
