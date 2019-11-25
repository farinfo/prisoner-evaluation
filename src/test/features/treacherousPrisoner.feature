Feature: Treacherous prisoner

  Scenario: A treacherous prisoner should always betray
    Given a treacherous prisoner, John
    And any opponent really, but let's name him Jake
    When John and Jake play together
    Then John will always betray