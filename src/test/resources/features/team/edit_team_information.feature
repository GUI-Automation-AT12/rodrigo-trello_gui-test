@Team
  Feature: Edit Team Information

    @createTeam @deleteTeam @quitBrowser
    Scenario: Edit Team's information in my Team account section
      Given I log in to Trello with valid User credentials
      When I navigate to my team account page
        And I edit My Team information with the following information
          | Name           |  teamEdited UNIQUE_ID      |
          | Type           |  Educación                 |
          | Short Name     |  teamedited_UNIQUE_ID      |
      Then The team's name should be updated in My Team account section
        And The url should be updated in the browser

