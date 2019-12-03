Feature: order cookies

  Background:
    Given a client named "Jeff"
    And a cookie named "Chocolala"

  Scenario: Jeff adds 20 Chocolalas to his cart
    When Jeff adds 20 Chocolalas to his cart
    Then A new item named Chocolala appears in his cart
    And The quantity next to this item is 20
    And The total sum to pay is updated
  #Je sais que la commande a été payée

  #Je peux commander sans compte sur la plateforme CoD

  #Il n'est pas possible de commander quelque chose qu'on ne sait pas fabriquer

  #Je peux payer ma commande par carte bancaire

  #Je peux passer une commande avec des cookies classiques et personnalisés

  #Je peux calculer un prix TTC à partir des ingrédients, des discounts et des taxes.

  #Les cookies personnalisés respectent les contraintes de fabrication (mix, topping, etc.)

  #Je dois payer un surcoût en cas de commande de cookies personnalisés

  #Je peux recevoir des packs de cookies selon le nombre de cookies commandés

  #Je peux associer des boissons à des packs de cookies