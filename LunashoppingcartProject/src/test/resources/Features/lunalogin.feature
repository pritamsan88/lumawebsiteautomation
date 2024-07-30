@lunalogin
Feature: Login section of the website

  @lunalogin
  Scenario Outline: To check the login section of the website with valid & invalid data
    Given open a browser
    And Go to project login page
    When user type <email> and <password>
    And Click on signin button
    Then verify user enter into dashboard or not
    And logout option present or not

    Examples: 
      | email                   | password  |
      | ritam.das14@yopmail.com | Sanyal88@ |
      | ritam.das14@yopmail.com |    123456 |
