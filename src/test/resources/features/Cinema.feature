Feature: Customer interaction with the cinema

  Background:
    Given I have a cinema ticket for today
    And I go to a cookie shop nearby the cinema

  #Je peux bénéficier de cookies gratuits avec mon ticket de cinéma du Paté-Poorsha
  Scenario: I can get free cookies thanks to my cinema ticket
    When I buy cookies for a total of 5 euros
    Then I get 2 free cookies of the day

  #Je peux interagir avec le système du cinéma à partir d’un simulateur de son API