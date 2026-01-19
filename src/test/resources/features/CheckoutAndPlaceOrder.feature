
Feature: Checkout and Place order
  As a guest customer
  I want to checkout my cart
  So that I can place an order successfully

  Scenario: Guest customer place order using default payment option
    Given I am a guest customer
    And my billing details are
      | firstname | lastname | country            | address_line1      | city  | state      | zip   | email              |
      | demo      | user     | 6299kk china       | United States (US) | Plano | California | 75024 | askomdch@gmail.com |
    And I have product in the cart
    When I click on Checkout button
    And  I provide billing details
    And I place an order
    Then I should see an order confirmation message
    And an order number should be generated


