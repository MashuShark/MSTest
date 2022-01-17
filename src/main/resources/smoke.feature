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
      | https://www.bbc.com | Anxious wait for news after tsunami cuts off Tonga  |

  Scenario Outline: Checks secondary article titles against a List titles
    Given User opens '<homePage>' page
    And User opens News
    And Checks the name of the second article against a '<SECOND_TITLE>'
    And Checks the name of the third article against a '<THIRD_TITLE>'
    And Checks the name of the fourth article against a '<FOURTH_TITLE>'
    And Checks the name of the fifth article against a '<FIFTH_TITLE>'
    And Checks the name of the sixth article against a '<SIXTH_TITLE>'

    Examples:
      | homePage            |                     SECOND_TITLE                   |                 THIRD_TITLE                         |                  FOURTH_TITLE                    |                       FIFTH_TITLE              | SIXTH_TITLE                        |
      | https://www.bbc.com | Body of British woman found in Tonga, says brother | Djokovic back in Serbia after Australia deportation | Two teens held in UK over Texas synagogue siege  | Texas Rabbi: How I escaped from synagogue siege| How I escaped from synagogue siege |

  Scenario Outline: Check name Of first article in category Against name of category
    Given User opens '<homePage>' page
    And User opens News
    And User enters title of Category in search field
    When Checks the name of the first in category article against a title of Category

    Examples:
      | homePage            |
      | https://www.bbc.com |

  Scenario Outline: Check form user question error message missing email
    Given User opens 'https://www.bbc.com' page
    And User opens News
    And User opens Coronavirus category
    And User opens User Coronavirus Story Page
    And User opens User Questions Page
    And User moves to form for user questions
    And User enters question
    And User fills form

      | Name           |<name>     |
      | Email address  | <Email address>   |
      | Contact number | <Contact number> |
      | Location        | <Location> |
      | Age            | <Age>         |

    And User selects dropdown
    And User sends form
    And User clicks on Submit Button
    When Checks email error message

    Examples:
      | name   | Email address | Contact number | Location | Age|
      | Alex   || 1234567890     | Monaco  | 20 |

