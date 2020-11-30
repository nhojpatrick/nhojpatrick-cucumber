Feature: State Steps Checking Feature


  Scenario: State Steps Checking Scenario 1
    Given I have an empty run state
    And I've defined "key1" is "value1"
    And I've defined "key2" is "value2"
    Then I expected "key1" to match "value1"
    And I expected "key2" to match "value2"
    Then I have run state key->value string pairs of:
      | key1 | value1 |
      | key2 | value2 |
    When I have cleared the run state
    And I have an empty run state


  Scenario: State Steps Checking Scenario 2
    Given I have an empty run state
    And I've defined "key1" is "value1"
    And I've defined "key2" is "value2"
    Then I expected "key1" to match "value1"
    And I expected "key2" to match "value2"
    Then I have run state key->value string pairs of:
      | key1 | value1 |
      | key2 | value2 |
    When I have cleared the run state for keys:
      | key1 |
      | key2 |
    And I have an empty run state
