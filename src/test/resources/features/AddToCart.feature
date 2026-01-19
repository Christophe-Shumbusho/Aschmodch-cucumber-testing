Feature: Add product to cart functionality
  As a customer
  I want to add products to my cart
  So that I can purchase them later

  Background:
  Given I am on the store page

  Scenario: Add a single product to cart
    When I add a "Boho Bangle Bracelet" to the cart
    Then I should see 1 "Boho Bangle Bracelet" in the cart


  Scenario Outline: Add products to cart
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart

    Examples:
    |product_name|
    |"Blue Shoes"|
    |"Basic Blue Jeans"|
    |"Black Over-the-shoulder Handbag"|