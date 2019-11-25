Feature: False-friend prisoner

  Scenario: A false-friend will first reciprocate
    Given a false-friend prisoner, Bill
    And any opponent really, but let's name him Jake
    When Bill and Jake play together
    Then Bill will cooperate first
    But once the game ends, Bill will betray