Feature: discounts for registered customers

  Background: registered customer
    Given I am a registered customer

  #Je peux bénéficier des 10% tous les 30 cookies (for registered customers only)
  Scenario: get a 10% discount after ordering 30 cookies
    When I have already bought 30 cookies in the past
    And I order cookies the next time
    Then I automatically get a 10% discount

  #Je peux bénéficier d’une réduction avec le bon EVENT à partir de 100 cookies commandés (for registered customers only)
  Scenario: get a discount after ordering 100 cookies and entering the code "EVENT"
    When I have already bought 100 cookies in the past
    And I order cookies the next time
    And I enter the code "EVENT"
    Then I get a 15% discount

  #Je peux bénéficier d’une réduction grâce à mon ancienneté (for registered customers only)
  Scenario: get a discount for being a long registered customer
    When I order cookies
    Then I get a 1% discount for every year that I have been registered

Feature: discounts for all users

  Background:
    Given: I am a registered on an unregistered customer

  #Je peux bénéficier d’une réduction avec le CE de mon entreprise
  Scenario: get a discount after entering the code "CE_COMPANY"
    When I am an employee of the company "COMPANY" that has a partnership with the cookie shop
    And I order cookies
    And I enter the code "CE_COMPANY"
    Then I get a 5% discount

#Je peux bénéficier de 30% de réduction sur les recettes pré-existantes dans la dernière heure d’ouverture
  Scenario: get a discount during the last opening hour of the shop
    When I order predefined cookies during the last opening hour of the shop
    Then I automatically get a 30% discount