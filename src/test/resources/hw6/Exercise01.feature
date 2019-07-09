@scenario_1
Feature: Home page and Different Elements Page

  Scenario: Test Home page, navigation to the Different Elements Page, and operations on the Different Elements Page
    Given I am on the index page
    Then The index page has the 'Home Page' title
    When I login as the user 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'
    And Home Page contains '4' pictures
    And Home Page contains '4' text labels under the pictures
    And Home Page contains '2' text labels above the pictures
    When I click the top menu item 'Service'
    Then Top service menu contains the following items
      | SUPPORT            |
      | DATES              |
      | SEARCH             |
      | COMPLEX TABLE      |
      | SIMPLE TABLE       |
      | USER TABLE         |
      | TABLE WITH PAGES   |
      | DIFFERENT ELEMENTS |
      | PERFORMANCE        |
    When I click the left menu item 'Service'
    Then The left service menu contains the following items
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | Search             |
      | User Table         |
      | Table with pages   |
      | Different elements |
      | Performance        |
    When I click the top menu item 'Service'
    And I open Different Elements Page via top Services menu
    Then The page has 'Different Elements' title
    And The Different Elements page contains '4' checkboxes
    And The Different Elements page contains '4' radio buttons
    And The Different Elements page contains '1' dropdowns
    And The Different Elements page contains '2' buttons
    And The Different Elements page contains right section
    And The Different Elements page contains left section
    When I set the following checkboxes
      | Water |
      | Wind  |
    Then The log is updated for the following checkboxes
      | Water | true |
      | Wind  | true |
    When I select the 'Selen' radio button
    Then The log is updated for the 'Selen' radio button
    When I select the 'Yellow' option in the drop down
    Then The log is updated for the 'Yellow' value in the drop down
    When I unset the following checkboxes
      | Water |
      | Wind  |
    Then The log is updated for the following checkboxes
      | Water | false |
      | Wind  | false |






