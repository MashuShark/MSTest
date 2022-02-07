Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check Name Of Headline Article
    Given User opens '<homePage>' page
    And User opens News
    And Checks the name of the headline article against a '<NAME_OF_HEADLINER_ARTICLE>'

    Examples:
      | homePage            | NAME_OF_HEADLINER_ARTICLE                     |
      | https://www.bbc.com | Former pope failed to act over abuse - report |

  Scenario: Checks secondary article titles against a List titles
    Given User opens 'https://www.bbc.com' page
    And User opens News
    And Checks that name of secondary articles are correct
      | Winter Olympics opening ceremony - watch & follow text |
      | South Africa makes its own version of Moderna jab      |
      | UK PM Johnson rocked by wave of resignations           |
      | Billionaire Bezos' superyacht sparks bridge row        |
      | India row over right to wear hijab deepens             |

  Scenario Outline: Check name Of first article in category Against name of category
    Given User opens '<homePage>' page
    And User opens News
    And User enters title of Category in search field
    When Checks the name of the first in category article against a title of Category

    Examples:
      | homePage            |
      | https://www.bbc.com |

  Scenario Outline: Check form user question
    Given User opens 'https://www.bbc.com' page
    And User opens News
    And User opens Coronavirus category
    And User opens User Coronavirus Story Page
    And User opens User Questions Page
    And User moves to form for user questions
    And User fills form
      | questions      | <question>       |
      | Name           | <name>           |
      | Email address  | <email address>  |
      | Contact number | <contact number> |
      | Location       | <location>       |
      | Age            | <age>            |

    And User selects dropdown
    And User sends form
    When User checks '<error>' message

    Examples:
      | question                  | name    | email address | contact number | location | age | error                         |
      | Some text for verify form | Tom     | [blank]       | 1234567890     | Monaco   | 20  | Email address can\'t be blank |
#      | Some text for verify form | [blank] | test@mail.com | 1234567890     | Monaco   | 20  | Name can\'t be blank          |
#      | [blank]                   | Alex    | test@mail.com | 1234567890     | Monaco   | 20  | can\'t be blank               |

