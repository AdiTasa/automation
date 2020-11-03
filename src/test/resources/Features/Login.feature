@SanityTest
Feature: Valid Login

  Scenario Outline: Login as valid user
    Given user goes to the login page
    When user inserts <username> and <password>
    And  user clicks submit
    Then user <username> gets into the welcome page

    Examples:
      | username | password |
      | root     | root     |
      | error    | error    |