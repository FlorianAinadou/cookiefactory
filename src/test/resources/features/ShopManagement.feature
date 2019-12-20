Feature: Shop management by the owner

  Background:
    Given I have a shop

  Scenario: I can change the opening hours of my shop
    When I set the opening hour of my shop to 8 and the closing hour of my shop to 22
    Then The opening hour of my shop becomes 8
    And The closing hour of my shop becomes 22

  Scenario: I can set the recipe of the month of my shop
    When I set "Chocolala" to be the recipe of the month in my shop
    Then The recipe of the month in my shop becomes "Chocolala"
