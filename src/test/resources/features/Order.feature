Feature: Ordering cookies

  Background:
    Given I am an unregistered customer

  Scenario: I can add predefined cookies to my cart
    When I add 20 predefined cookies named "Chocolala" to my cart
    Then The cookie named "Chocolala" appears in my cart
    And The quantity of this predefined cookie is 20

  Scenario: I can't create personalized cookies with too few ingredients
    When I try to create a personalized recipe with too few ingredients
    Then The recipe is not created

  Scenario: I can't create personalized cookies with too many ingredients
    When I try to add more than 3 toppings
    Then The toppings that surpass the limit of 3 are not added

  Scenario: I can create personalized cookies
    When I try to create a personalized recipe named "My cookie" with enough ingredients
    Then The recipe named "My cookie" is created

  Scenario: I can add personalized cookies to my cart
    When I add 10 personalized cookies to my cart
    Then This personalized cookie is added to my cart
    And The quantity of this personalized cookie is 10