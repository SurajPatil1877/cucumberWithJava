Feature: Application Login

  Scenario: Admin Page Default Login
    Given User is on NetBanking Landing Page
    When User login into application with "admin" and password "admin123"
    Then Home page is displayed
    And Cards are displayed

    #Reusable
  Scenario: User Page default Login
    Given User is on NetBanking Landing Page
    When User login into application with "john_doe" and password "password123"
    Then Home page is displayed
    And Cards are displayed

  Scenario Outline: User Page default Login
    Given User is on NetBanking Landing Page
    When User login into application with "<username>" and password "<password>"
    Then Home page is displayed
    And Cards are displayed
    Examples:
      | username | password |
      | user1    | pass123  |
      | user2    | pass456  |
      | user3    | pass789  |

  Scenario: User Page default Signup
    Given User is on Practice Landing Page
    When User signup into application with following details
      | firstName | Suraj          |
      | lastName  | Patil          |
      | email     | test@gmail.com |
      | mobile    | 9878676543     |
    Then Home page is displayed
