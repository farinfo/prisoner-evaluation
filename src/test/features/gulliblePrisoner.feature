Feature: Gullible prisoner

  Scenario: A gullible prisoner should always cooperate
    Given a gullible prisoner, Bob
    And any opponent really, but let's name him Jake
    When Bob and Jake play together
    Then Bob will always cooperate