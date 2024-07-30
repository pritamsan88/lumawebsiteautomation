@Registration
Feature: Registration section of the website

  @Registration
  Scenario Outline: To Check the registration section of the website using dynamic data
    Given browser open
    And Go to proper Url
    When Users enters details <FirstName> and <LastName>
    And user gives <Email> and <Password> and <ConfirmPassword>
    And Click on registerbutton
    Then Users should enter a dashboard page
    And Also check logout button present or not

    Examples: 
      | FirstName | LastName | Email                   | Password  | ConfirmPassword |
      | Ritam14   | Das      | ritam.das14@yopmail.com | Sanyal88@ | Sanyal88@       |
      | Ritam15   | Das1     | ritam.das15@yopmail.com | Sanyal88@ | Sanyal88@       |
