Feature: Customer interaction with the shop

  Background:
    Given I'm a customer

  When I collect my order
  Then My order is collected

  #Je ne peux pas commander en dehors des horaires d'ouverture

  #Je ne peux pas retirer ma commande avant l’heure spécifiée lors de la commande

  #Je peux retirer ma commande