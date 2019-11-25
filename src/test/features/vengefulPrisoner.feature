Feature: Vengeful prisoner

  Scenario: A vengeful prisoner should retaliate if betrayed
    Given a vengeful prisoner, Tim
    And a treacherous prisoner, John
    When Tim and John play together
    Then Tim will start by cooperating
    But once he's betrayed, Tim will betray back