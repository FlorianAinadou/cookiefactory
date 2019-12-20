Feature: Statistics

  Background:
    Given I have several shops

  Scenario: I can collect statistics per shop (i.e. nb cookies sold per day, % of personalized cookies)
    When I request statistics on the shop of id 0
    Then The statistics on the shop of id 0 are shown

  Scenario: I can aggregate statistics for all the shops
    When I request statistics on all the shops
    Then The statistics on all the shops are shown