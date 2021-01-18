@Board
Feature: Create a new board

  Background: Sets authentication
    Given I log in to Trello with valid User credentials

  @createTeam @deleteTeam @quitBrowser
  Scenario: Create a board in my team created
    When I open the create board form
    And I put the following information on create board pop up
      | Name            |  board UNIQUE_ID     |
    Then the board's information should match

