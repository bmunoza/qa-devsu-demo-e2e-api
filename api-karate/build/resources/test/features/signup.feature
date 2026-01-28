Feature: Signup de usuarios en Demoblaze

  Background:
    * def newusername = 'user_' + java.lang.System.currentTimeMillis()
    * def prevusername = 'user_karate_123'
    * def password = '123456'


  Scenario: Crear un nuevo usuario exitosamente
    Given url baseUrl + '/signup'
    And request { username: '#(newusername)', password: '#(password)' }
    When method post
    Then status 200
    * def res = response.trim()
    And match res == '""'

  Scenario: Intentar crear un usuario ya existente
    Given url baseUrl + '/signup'
    And request { username: '#(prevusername)', password: '#(password)' }
    When method post
    Then status 200
    And match response.errorMessage contains 'This user already exist.'
