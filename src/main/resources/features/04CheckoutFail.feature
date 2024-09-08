Feature: Negative Test checkout functionality on SauceDemo

# Negative Scenario; test 0007
Scenario: Attempt checkout with missing information
  Given I am logged in to the website
  When I click to the cart and proceeds to checkout
  And I leaves the name field empty
  Then an error message First Name is required should be displayed