Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check that team scores display correctly
    Given User opens 'https://www.bbc.com' page
    And User goes to Sport Page
    And User goes to Football Page
    And User goes to Scores and Fixtures
    When User searches for a '<championship>'
    Examples:
      | championship |
      | Scottish Championship |


