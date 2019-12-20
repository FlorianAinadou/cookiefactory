Feature: Recipe management by the cookie shops' owner

  Background:
    Given I have a list of ingredients and recipes for my cookie shops

  Scenario: I can add a new dough
    When I add a new dough named "Banana" of price 0.05
    Then A dough named "Banana" appears in my list

  Scenario: I can add a new flavour
    When I add a new flavour named "Banana" of price 0.02
    Then A flavour named "Banana" appears in my list

  Scenario: I can add a new topping
    When I add a new topping named "Banana" of price 0.03
    Then A topping named "Banana" appears in my list

  Scenario: I can change the margin for all products in a given shop
    When In the shop of id 0 I change the margin for all products to 0.19
    Then The margin for all products in the shop of id 0 becomes 0.19

  Scenario: I can change the margin for personalized cookies in a given shop
    When In the shop of id 0 I change the margin for personalized cookies to 0.3
    Then The margin for personalized cookies in the shop of id 0 becomes 0.3

  Scenario: I can change the price of a certain dough
    When I set the price of the dough named "Oatmeal" to 0.02
    Then The price of the dough named "Oatmeal" becomes 0.02

  Scenario: I can change the price of a certain flavour
    When I set the price of the flavour named "Chili" to 0.05
    Then The price of the flavour named "Chili" becomes 0.05

  Scenario: I can change the price of a certain topping
    When I set the price of the topping named "M&Ms" to 0.03
    Then The price of the topping named "M&Ms" becomes 0.03