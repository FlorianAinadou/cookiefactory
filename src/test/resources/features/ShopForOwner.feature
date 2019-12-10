Feature: shop management by owner

  Background:
    Given a shop

  # I can change the opening hours of my shop
  Scenario: changing opening hours
    When I change the opening hours of the shop
    Then they are not the same as before
    And they are just the ones I wanted

  # I can set the recipe of the month of my shop
  Scenario: recipe of the month
    When I set a certain recipe to be the recipe of the month
    Then the recipe of the month becomes just the one I wanted
