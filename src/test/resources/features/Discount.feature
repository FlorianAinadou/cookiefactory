Feature: Discounts on orders

  Background:
    Given I am a registered customer

  Scenario: get a 10% discount for ordering 30 cookies
    When I order 30 cookies
    Then I get a 10 % discount

