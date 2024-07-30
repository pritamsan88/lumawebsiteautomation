@cartfunctionality
Feature: To check the cart functionality & Checkout

  @cartfunctionality
  Scenario Outline: Multiple product add in the cart page and procceed to checkout
    Given Startup browser
    And Go to shopping cart website
    When Product select from menu
    And Add to cart section
    And Another product select from menu
    And Add to cart section
    And go to cart section
    And Click on check out option
    And user sigin their account <email> and <password>
    And choose address
    And Click on place order
    Then validate order is placed I see confirmation message
    And Go to my account to order check order details placed or not

    Examples: 
      | email                   | password  |
      | ritam.das14@yopmail.com | Sanyal88@ |
