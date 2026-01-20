Feature: Login functionality
  As a registered customer
  I want to log into my account
  So that I can view my orders and checkout faster
  @login
  Background:
    Given I am on the login page

  Scenario: Customer login with valid credentials
    When I enter valid credentials
      | username            | password       |
      | Shumbusho           | StrongPass123  |
    And I click on login button
    Then I should be redirected to my account dashboard
    And I see a welcome message contains my username

