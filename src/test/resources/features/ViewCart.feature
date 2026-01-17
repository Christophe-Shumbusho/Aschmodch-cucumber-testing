Feature: View Cart functionality
  As a customer
  I want to view my cart
  So that I can confirm my selections

  Scenario: View cart with items
    Given I have items in the cart
      | productName |
      | Blue Shoes  |
      | Denim Jeans |
    When I view the cart
    Then the cart should list all added products

  Scenario: Customer View empty cart
    Given I have no items in the cart
    When  I view the cart
    Then the cart should display "Your cart is empty"
