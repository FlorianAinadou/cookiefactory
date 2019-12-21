Feature: Customer interaction with the cinema

  Background:
    Given I am a customer
    And I have a cinema ticket for today

  Scenario: I can get free cookies thanks to my cinema ticket
    When I order 5 or more cookies
    Then I get 2 additional cookies of the month to my 5 cookies
    And They are free