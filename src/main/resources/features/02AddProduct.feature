Feature: Test add to cart functionality on SauceDemo

# Positive Scenario; test 0005
  Scenario: Add two products to the cart successfully
    Given I am logged in to the website
    When I add two products to the cart
    Then the cart icon should display total product
    And I am on the cart page
    And the product should display in the cart