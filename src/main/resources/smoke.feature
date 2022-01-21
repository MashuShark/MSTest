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
      | https://www.bbc.com | Former pope failed to act over abuse - report |

  Scenario Outline: Checks secondary article titles against a List titles
    Given User opens '<homePage>' page
    And User opens News
    And Checks the name of the second article against a '<SECOND_TITLE>'
    And Checks the name of the third article against a '<THIRD_TITLE>'
    And Checks the name of the fourth article against a '<FOURTH_TITLE>'
    And Checks the name of the fifth article against a '<FIFTH_TITLE>'
    And Checks the name of the sixth article against a '<SIXTH_TITLE>'

    Examples:
      | homePage            |  SECOND_TITLE                                    | THIRD_TITLE                                        | FOURTH_TITLE                                   | FIFTH_TITLE                                       | SIXTH_TITLE                                       |
      | https://www.bbc.com | Biden believes Putin will \'move in\' on Ukraine | Most Havana syndrome not caused by adversary - CIA | Even the dogs were covered in ash - Tonga resident  | Ministers blackmailing Johnson plotters - Tory MP| Ghislaine Maxwell seeks retrial in sex abuse case |

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
      | questions      |<question>        |
      | Name           |<name>            |
      | Email address  | <email address>  |
      | Contact number | <contact number> |
      | Location       | <location>       |
      | Age            | <age>            |

    And User selects dropdown
    And User sends form
    When User checks '<error>' message

    Examples:
      |question                 |name   | email address | contact number | location | age| error                         |
      |Some text for verify form|Tom    | [blank]       | 1234567890     | Monaco   | 20 | Email address can\'t be blank |
      |Some text for verify form|[blank]| test@mail.com | 1234567890     | Monaco  | 20  | Name can\'t be blank          |
      |[blank]                  |Alex   | test@mail.com | 1234567890     | Monaco  | 20  | can\'t be blank               |

