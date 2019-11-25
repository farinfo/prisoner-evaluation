Feature: Mimic prisoner

  Scenario: A mimic will always cooperate first then copy his opponent
    Given a mimic prisoner, Dan
    And any opponent really, but let's name him Jake
    When Dan and Jake play together
    Then Dan will start by betraying
    But Dan will copy Jake's last decision in the following rounds