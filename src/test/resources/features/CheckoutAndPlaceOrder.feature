
Feature: Checkout and Place order
  As a guest customer
  I want to checkout my cart
  So that I can place an order successfully

  Background:
    Given I have product in the cart
      | productName |
      | Blue Shoes  |

  Scenario: Guest customer place order using default payment option
    And I am a guest customer
    And my billing details are
      | firstname | lastname | address_line1     | city  | zip   | email             |
      | demo      | user     | 6300 Spring Creek | Plano |75024 | askomdch@gmail.com |
    And I am on the Checkout page
    When I provide billing details
    And I place an order
    Then the order should be placed successfully



  Scenario: Logged Customer successful checkout with valid details
    And I logged in as a customer
    When I proceed to checkout
    And I enter shipping details
      | firstname | lastname | country            | address_line1     | city  | state | zip   | email              |
      | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | askomdch@gmail.com |
    And places the order
    Then I should see an order confirmation message
    And an order number should be generated

