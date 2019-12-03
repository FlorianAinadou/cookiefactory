Feature: order cookies

  Background:
    Given a client named "Jeff"
    And a cookie named "Chocolala"

  Scenario: Jeff adds 20 Chocolalas to his cart
    When Jeff adds 20 Chocolalas to his cart
    Then A new item named Chocolala appears in his cart
    And The quantity next to this item is 20
    And The total sum to pay is updated