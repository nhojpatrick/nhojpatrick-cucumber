@Json
@Transformation
@Remove
Feature: Transformation - Remove - Checking Null with Specified keys


  Background: Check Clear Run State
    Given I have cleared the run state for keys:
      | jsonMap.key |
    And I have an empty run state


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Attributes success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_Null |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action |
      | <path> | Remove |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Attributes errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_Null |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and remove the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | null |

    Examples:
      | path      | error                               |
      | z_unknown | Path does not exist at 'z_unknown'. |


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Arrays success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_Null |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action |
      | <path> | Remove |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Arrays errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_Null |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and remove the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | null |

    Examples:
      | path         | error                               |
      | z_unknown[0] | Path does not exist at 'z_unknown'. |


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Object success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_Null |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action |
      | <path> | Remove |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Object errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_Null |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and remove the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | null |

    Examples:
      | path                | error                                                                                 |
      | z_unknown.z_unknown | Path 'z_unknown' does not existing and automatic creation disabled by transformation. |


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Objects success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_Null |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action |
      | <path> | Remove |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Objects errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_Null |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and remove the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | null |

    Examples:
      | path                   | error                                                                                 |
      | z_unknown[0].z_unknown | Path 'z_unknown' does not existing and automatic creation disabled by transformation. |
