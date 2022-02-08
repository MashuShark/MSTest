Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

#  Add a test that verifies that team scores display correctly:
#  - From BBC Home page go to Sport;
#  - Go to Football
#  - Go to Scores and Fixtures
#  - Search for a championship (e.g. Scottish Championship). This value should be in your test, so that another test can search for a different value.
#  - Select results for a month. Again, the month should be in your test.
#  - Verify that 2 specific teams (specified in your test) played with a specific score (again, specified in your test);
#  - Click on one of the team’s names;
#  - Verify that the score at the center of the screen is also the one from your test (same value). Both the numbers and the team names should be verified.
#  Note: you need text from :after element. Selenium doesn’t work with them properly – google how to get around that.

  Scenario Outline: Check that team scores display correctly
    Given User opens 'https://www.bbc.com' page
    And User goes to Sport Page
    And User goes to Football Page
    And User goes to Scores and Fixtures
    When User searches for a '<championship>'
    And User selects results for a '<period>'
    Then User checks that '<teamFirst>' and '<teamSecond>' played with a specific '<score>'
    Examples:
      | championship          | period  | teamFirst   | teamSecond | score |
      | Scottish Championship | 2021-12 | Dunfermline | Arbroath   | 0 3   |


