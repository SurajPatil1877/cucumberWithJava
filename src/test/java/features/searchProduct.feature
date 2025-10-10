Feature: Search and Place the order for Products

 Scenario Outline: Search Experience for product search in both home and offers page
    Given User is on GreenKart landing page
    When User searched with shortname <productName> and extracted actual name of a product
    Then User search of same shortname  <productName> in offers page to check if product exists
    Examples:
    | productName |
    | Tom         |