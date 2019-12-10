Feature: customer interaction with the cinema

  Background: cinema visitor
    Given I have a cinema ticket for today
    And I go to a cookie shop nearby the cinema

  #Je peux bénéficier de cookies gratuits avec mon ticket de cinéma du Paté-Poorsha
  Scenario: get free cookies
    When I buy cookies for a total of 5 euros
    Then I get 2 free cookies of the day

  #Je peux interagir avec le système du cinéma à partir d’un simulateur de son API