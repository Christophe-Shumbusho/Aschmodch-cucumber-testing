Feature: Customer registration
  As a new customer,
  I want to create an account by registering with my personal details,
  So that I can login in the website.

  Background:
    Given I am on the registration page

  Scenario: Customer to register with valid credential
    When I enter valid details:
      | userName    | email                   | password          |
      | Christiana  | christiana@gmail.com    |   Strong-pass2354 |
    And I click on register button
    Then I should be redirected to the dashboard
    And I see welcome message contains my username

#  Scenario: Registration fails with existing email
#    When I enter exist email credential
#      | userName | email         | password          |
#      | Chris    | tti@elool.com |   Strong-pass2354 |
#    And I click on register button
#    Then an error message should be displayed on a registration page
#
#
#
#  Scenario Outline: Registration fails with missing required fields
#    When I enter "<userName>" "<email>" and "<password>"
#    Then an error message "<errorMessage>" should be displayed on the registration page
#
#    Examples:
#      | userName | email          | password          | errorMessage              |
#      |          | tti@elool.com  | Strong-pass2354   | Username is required      |
#      | Chris    |                | Strong-pass2354   | Email is required         |
#      | Chris    | tti@elool.com  |                   | Password is required      |
#      |          |                |                   | All fields are required   |

