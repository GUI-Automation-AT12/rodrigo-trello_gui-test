@TeamProfile
  Feature: Edit Team Information

    Scenario: Edit Team's information in my Team account section
      Given I log in to Trello with Editable User credentials
      When I navigate to my team account page
        And I edit My Team information with the following information
          | name           |  at14          |
          | Type of team   |  Educacion     |
          | short name     |  at123         |
      Then The team's name should be updated in My Team account section
        And The url should be updated in the browser


    Scenario: