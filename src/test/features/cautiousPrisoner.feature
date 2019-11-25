Feature: Cautious prisoner

  Scenario: A cautious prisoner one betrays until you cooperate, then he will cooperate
    Given a cautious prisoner, Tim
    And a gullible prisoner, Bob
    When Tim and Bob play together
    Then Tim will start by betraying
    But Tim will cooperate in the following round