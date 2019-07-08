@scenario_1
Feature: Home page and Different Elements Page

  Scenario: Test Home page, navigation to the Different Elements Page, and operations on the Different Elements Page
    Given I am on the index page
    Then The index page has the 'Home Page' title
    When I login as the user 'epam'/'1234'
    # TODO It iw better 'User name should be '...''
    Then I see the user 'PITER CHAILOVSKII'
    # TODO There are - it is where?
    And There are '4' pictures
    # TODO There are - it is where?
    And There are '4' text labels under the pictures
    # TODO There are - it is where?
    And There are '2' text labels above the pictures
    When I click the top menu item 'Service'
    # TODO There are - it is where?
    Then There are the following top service items
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
    # TODO There are - it is where?
    Then There are the following left service items
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
    # TODO There are - it is where?
    And There are '4' checkboxes
    # TODO There are - it is where?
    And There are '4' radio buttons
    # TODO There are - it is where?
    And There are '1' dropdowns
    # TODO There are - it is where?
    And There are '2' buttons
    # TODO There are - it is where?
    And There is right section
    # TODO There are - it is where?
    And There is left section
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






