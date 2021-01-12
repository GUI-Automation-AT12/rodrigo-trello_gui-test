@Team
Feature: Create a new team

  Background: Sets authentication
    Given I log in to Trello with valid User credentials

  @deleteTeam @quitBrowser
  Scenario: Create a team in my team section
    When I open the create team form
    And I put the following information on create team section
      | Name            |  at12 UNIQUE_ID     |
      | Type            |  Operaciones        |
      | Description     |  at123 UNIQUE_ID    |
    Then the team's information should match

