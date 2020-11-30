@Json
@Transformation
@Remove
Feature: Transformation - Whitespace - Checking BasicAttributes with Specified keys


  Background: Check Clear Run State
    Given I have cleared the run state for keys:
      | jsonMap.key |
    And I have an empty run state


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Attributes success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action     |
      | <path> | Whitespace |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path      | expected                                                                                                 |
      | a_boolean | {a_boolean=    true    , a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |
      | a_float   | {a_boolean=true, a_float=    12.34    , a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |
      | a_integer | {a_boolean=true, a_float=12.34, a_integer=    1234    , a_null=null, a_object_empty={}, a_string=aValue} |
      | a_string  | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=    aValue    } |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Attributes errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and whitespace the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |

    Examples:
      | path           | error                                                      |
      | a_null         | Unable to whitespace 'null' value, at path 'a_null'.       |
      | a_object_empty | Unable to whitespace JsonObject, at path 'a_object_empty'. |
      | z_unknown      | Path does not exist at 'z_unknown'.                        |


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Arrays success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action     |
      | <path> | Whitespace |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Arrays errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and whitespace the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |

    Examples:
      | path              | error                                                        |
      | a_boolean[0]      | Unable to whitespace path 'a_boolean', as is not Array.      |
      | a_float[0]        | Unable to whitespace path 'a_float', as is not Array.        |
      | a_integer[0]      | Unable to whitespace path 'a_integer', as is not Array.      |
      | a_null[0]         | Unable to whitespace 'null' value, at path 'a_null'.         |
      | a_object_empty[0] | Unable to whitespace path 'a_object_empty', as is not Array. |
      | a_string[0]       | Unable to whitespace path 'a_string', as is not Array.       |
      | z_unknown[0]      | Path does not exist at 'z_unknown'.                          |


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Object success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action     |
      | <path> | Whitespace |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Object errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and whitespace the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |

    Examples:
      | path                     | error                                                                                 |
      | a_boolean.z_unknown      | Unable to convert primative to object, at path 'a_boolean'.                           |
      | a_float.z_unknown        | Unable to convert primative to object, at path 'a_float'.                             |
      | a_integer.z_unknown      | Unable to convert primative to object, at path 'a_integer'.                           |
      | a_null.z_unknown         | AutoConvert 'null' value to object disabled, at path 'a_null'.                        |
      | a_object_empty.z_unknown | Path does not exist at 'a_object_empty.z_unknown'.                                    |
      | a_string.z_unknown       | Unable to convert primative to object, at path 'a_string'.                            |
      | z_unknown.z_unknown      | Path 'z_unknown' does not existing and automatic creation disabled by transformation. |


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Objects success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action     |
      | <path> | Whitespace |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Objects errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and whitespace the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |

    Examples:
      | path                        | error                                                                                 |
      | a_boolean[0].z_unknown      | Unable to convert primative to array, at path 'a_boolean'.                            |
      | a_float[0].z_unknown        | Unable to convert primative to array, at path 'a_float'.                              |
      | a_integer[0].z_unknown      | Unable to convert primative to array, at path 'a_integer'.                            |
      | a_null[0].z_unknown         | AutoConvert 'null' value to array disabled, at path 'a_null'.                         |
      | a_object_empty[0].z_unknown | Unable to convert object to array, at path 'a_object_empty'.                          |
      | a_string[0].z_unknown       | Unable to convert primative to array, at path 'a_string'.                             |
      | z_unknown[0].z_unknown      | Path 'z_unknown' does not existing and automatic creation disabled by transformation. |
