Feature: Customer registration
  As a new customer,
  I want to create an account by registering with my personal details,
  So that I can login in the website.

  Background:
    Given I am on the registration page

  Scenario: Customer to register with valid credential
    When I enter valid details:
      | userName    | email                   | password          |
      | Christian  | christian@gmail.com    |   Strong-pass2354 |
    And I click on register button
    Then I should be redirected to the dashboard
    And I see welcome message contains my username


