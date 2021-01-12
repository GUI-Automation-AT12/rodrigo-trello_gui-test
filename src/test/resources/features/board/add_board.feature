@Board
Feature: Create a new board

  Background: Sets authentication
    Given I log in to Trello with valid User credentials

  @createTeam @deleteTeam @quitBrowser
  Scenario: Create a board in my team created
    When I open the create board form
    And I put the following information on create board pop up
      | Name            |  at12 UNIQUE_ID     |
      | Type            |  Operaciones        |
      | Description     |  at123 UNIQUE_ID    |
    Then the team's information should match

