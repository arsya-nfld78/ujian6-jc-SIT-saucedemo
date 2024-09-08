Feature: Test checkout functionality on SauceDemo

 # Positive Scenario; test 0006
  Scenario: Successfully complete the checkout process
    Given I proceeds to checkout
    When I enters users information
    And I click continue
    Then I should be redirected to the overview page and click finish
    And I should see a message THANK YOU FOR YOUR ORDER
