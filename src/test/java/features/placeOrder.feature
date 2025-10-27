Feature: Place order of a product and validate details on cart page

  @PlaceOrder
  Scenario Outline: Search product increase quantity and validate the name and buttons
    Given User is on GreenKart landing page
    When  User searched with shortname <productName> and extracted actual name of a product
    Then User increase quantity of a product to <quantity>
    Then User clicks on Add to Cart Button
    And Validate the product details on cart page
    Examples:
      | productName | quantity |
      | Tomato      | 3        |