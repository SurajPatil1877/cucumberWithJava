Feature: Application Login

  Scenario: Admin Page Default Login
    Given User is on NetBanking Landing Page
    When User login into application
    Then Home page is displayed
    And Cards are displayed