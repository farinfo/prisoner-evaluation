Feature: Friend or foe game

  Scenario: Game ends with a winner
    Given a gullible prisoner, Bob
    And a treacherous prisoner, John
    When Bob and John play together
    Then John should always win

  Scenario: Game ends with a draw
    Given a gullible prisoner, Bob
    And another gullible prisoner, Dave
    When Bob and Dave play together
    Then there should be no winner