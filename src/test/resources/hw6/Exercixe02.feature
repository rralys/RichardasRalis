@scenario_2
Feature: User Table page layout

  Scenario: User Table page test
    Given I am on the index page
    Then The index page has the 'Home Page' title
    When I login as the user 'epam'/'1234'
    Then I see the user 'PITER CHAILOVSKII'
    When I click the top menu item 'Service'
    And I click the 'User Table' button in Service top menu
    Then The page has 'User Table' title
    And The User Table page contains '6' dropdowns
    And The User Table page contains '6' user names
    And The User Table page contains '6' user images
    And The User Table page contains '6' user descriptions
    And The User Table page contains '6' check boxes
    And The User Table page contains the following values
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    When I set vip checkbox for 'Sergey Ivan'
    Then Log contains the 'Vip: condition changed to true' record
    When I click the dropdown for the user 'Roman'
    Then The dropdown for 'Roman' contains the following options
      | Admin   |
      | User    |
      | Manager |