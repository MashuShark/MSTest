Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check Name Of Headline Article
    Given User opens '<homePage>' page
    And User opens News
    And Checks the name of the headline article against a '<NAME_OF_HEADLINER_ARTICLE>'

    Examples:
      | homePage            | NAME_OF_HEADLINER_ARTICLE |
      | https://www.bbc.com | Tonga tsunami: Major damage reported amid communications black out  |

  Scenario Outline: Checks secondary article titles against a List titles
    Given User opens '<homePage>' page
    And User opens News
    And Checks the name of the second article against a '<SECOND_TITLE>'
    And Checks the name of the third article against a '<THIRD_TITLE>'
    And Checks the name of the fourth article against a '<FOURTH_TITLE>'
    And Checks the name of the fifth article against a '<FIFTH_TITLE>'
    And Checks the name of the sixth article against a '<SIXTH_TITLE>'

    Examples:
      | homePage            | SECOND_TITLE | THIRD_TITLE  | FOURTH_TITLE | FIFTH_TITLE | SIXTH_TITLE |
      | https://www.bbc.com |  | | | | |

  Scenario Outline: Check name Of first article in category Against name of category
    Given User opens '<homePage>' page
    And User opens News
    And User enters title of Category in search field
    And Checks the name of the first in category article against a '<title_of_Category>'

    Examples:
      | homePage            |
      | https://www.bbc.com |

  Scenario Outline: Check form user question error message missing email
    Given User opens '<homePage>' page
    And User opens News
    And User opens Coronavirus category
    And User opens User Coronavirus Story Page
    And User opens User Questions Page
    And User moves to form for user questions
    And User fills form
    And Checks  email error message '<error_message_missing_email>'
    Examples:
      | homePage            | error_message_missing_email |
      | https://www.bbc.com | |