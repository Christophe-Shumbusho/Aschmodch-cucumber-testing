Feature: Login functionality
  As a registered customer
  I want to log into my account
  So that I can view my orders and checkout faster

  Background:
    Given I am on the login page

  Scenario: Customer login with valid credentials
    When I enter valid credentials
      | username            | password       |
      | Shumbusho           | StrongPass123  |
    And I click on login button
    Then I should be redirected to my account dashboard
    And I see a welcome message contains my username

#  Scenario: Customer Login with invalid password
#    When I enter invalid password credential
#      | username            | password   |
#      | christophe@test.com | WrongPass  |
##    Then an error message should be displayed on the login page