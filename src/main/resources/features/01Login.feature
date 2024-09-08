Feature: Test login functionality on SauceDemo

# Positive Scenario; test 0001
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enters username and password validly
    And  I click the login button
    Then I should be redirected to the products page

  # Negative Scenario; test 0002
  Scenario: Login attempt with invalid password
    Given I am on the login page
    When I enters username validly and password invalidly
    And I click the login button
    Then I should see an error displayed

  # Negative Scenario; test 0003
  Scenario: Login attempt with invalid username
    Given I am on the login page
    When I enters username invalidly and password validly
    And I click the login button
    Then I should see an error displayed

  # Negative Scenario; test 0004
  Scenario: Login attempt with empty username and password
    Given I am on the login page
    When I leaves username and password fields empty
    And I click the login button
    Then an error message Username is required should be displayed