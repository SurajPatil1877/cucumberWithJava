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