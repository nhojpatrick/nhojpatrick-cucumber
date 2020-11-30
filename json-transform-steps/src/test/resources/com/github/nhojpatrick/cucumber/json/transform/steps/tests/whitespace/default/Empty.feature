@Json
@Transformation
@Remove
Feature: Transformation - Whitespace - Checking Empty with Default keys


  Background: Check Clear Run State
    Given I have cleared the run state for keys:
      | runState.json.map |
    And I have an empty run state


  @Success
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Attributes success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When I transform json map using default RunStateKey on paths:
      | path   | action     |
      | <path> | Whitespace |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Attributes errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When TestingInternalSteps I transform json map using default RunStateKey and whitespace the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {} |

    Examples:
      | path      | error                               |
      | z_unknown | Path does not exist at 'z_unknown'. |


  @Success
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Arrays success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When I transform json map using default RunStateKey on paths:
      | path   | action     |
      | <path> | Whitespace |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Arrays errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When TestingInternalSteps I transform json map using default RunStateKey and whitespace the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {} |

    Examples:
      | path         | error                               |
      | z_unknown[0] | Path does not exist at 'z_unknown'. |


  @Success
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Object success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When I transform json map using default RunStateKey on paths:
      | path   | action     |
      | <path> | Whitespace |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Object errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When TestingInternalSteps I transform json map using default RunStateKey and whitespace the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {} |

    Examples:
      | path                | error                                                                                 |
      | z_unknown.z_unknown | Path 'z_unknown' does not existing and automatic creation disabled by transformation. |


  @Success
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Objects success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When I transform json map using default RunStateKey on paths:
      | path   | action     |
      | <path> | Whitespace |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Objects errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When TestingInternalSteps I transform json map using default RunStateKey and whitespace the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {} |

    Examples:
      | path                   | error                                                                                 |
      | z_unknown[0].z_unknown | Path 'z_unknown' does not existing and automatic creation disabled by transformation. |
