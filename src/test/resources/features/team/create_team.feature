@Team
Feature: Create a new team

  Background: Sets authentication
    Given I log in to Trello with valid User credentials

  Scenario: Create a team in my team section
    When I open the create team form
    And I put the following information on create team section
      | name           |  at14          |
      | Type of team   |  Educacion     |
      | short name     |  at123         |
    Then The team's list should be updated in my home page
    And The values should match

