@Json
@Transformation
@Remove
Feature: Transformation - Set - Checking BasicAttributes with Specified keys


  Background: Check Clear Run State
    Given I have cleared the run state for keys:
      | jsonMap.key |
    And I have an empty run state


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Attributes success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path           | value     | type             | expected                                                                                                              |
      | a_boolean      | newString | java.lang.String | {a_boolean=newString, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue}                 |
      | a_float        | newString | java.lang.String | {a_boolean=true, a_float=newString, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue}                  |
      | a_integer      | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=newString, a_null=null, a_object_empty={}, a_string=aValue}                 |
      | a_null         | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=newString, a_object_empty={}, a_string=aValue}                 |
      | a_object_empty | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty=newString, a_string=aValue}               |
      | a_string       | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=newString}                   |
      | z_unknown      | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue, z_unknown=newString} |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Attributes errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |

    Examples:
      | path | value | type | error |


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Arrays success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path         | value     | type             | expected                                                                                                                |
      | a_null[0]    | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=[newString], a_object_empty={}, a_string=aValue}                 |
      | z_unknown[0] | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue, z_unknown=[newString]} |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Arrays errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    Then I have run state key->value string pairs of:
      | jsonMap.key | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |

    Examples:
      | path              | value     | type             | error                                                 |
      | a_boolean[0]      | newString | java.lang.String | Unable to set path 'a_boolean', as is not Array.      |
      | a_float[0]        | newString | java.lang.String | Unable to set path 'a_float', as is not Array.        |
      | a_integer[0]      | newString | java.lang.String | Unable to set path 'a_integer', as is not Array.      |
      | a_object_empty[0] | newString | java.lang.String | Unable to set path 'a_object_empty', as is not Array. |
      | a_string[0]       | newString | java.lang.String | Unable to set path 'a_string', as is not Array.       |


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Object success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path                     | value     | type             | expected                                                                                                                          |
      | a_null.z_unknown         | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null={z_unknown=newString}, a_object_empty={}, a_string=aValue}                 |
      | a_object_empty.z_unknown | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={z_unknown=newString}, a_string=aValue}               |
      | z_unknown.y_unknown      | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue, z_unknown={y_unknown=newString}} |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Object errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |

    Examples:
      | path                | value     | type             | error                                                       |
      | a_boolean.z_unknown | newString | java.lang.String | Unable to convert primative to object, at path 'a_boolean'. |
      | a_float.z_unknown   | newString | java.lang.String | Unable to convert primative to object, at path 'a_float'.   |
      | a_integer.z_unknown | newString | java.lang.String | Unable to convert primative to object, at path 'a_integer'. |
      | a_string.z_unknown  | newString | java.lang.String | Unable to convert primative to object, at path 'a_string'.  |


  @Success
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Objects success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When I transform json map using RunStateKey "jsonMap.key" on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | jsonMap.key | <expected> |

    Examples:
      | path                   | value     | type             | expected                                                                                                                                |
      | a_null[0].z_unknown    | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=[{z_unknown=newString}], a_object_empty={}, a_string=aValue}                     |
      | a_null[1].z_unknown    | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=[{}, {z_unknown=newString}], a_object_empty={}, a_string=aValue}                 |
      | z_unknown[0].y_unknown | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue, z_unknown=[{y_unknown=newString}]}     |
      | z_unknown[1].y_unknown | newString | java.lang.String | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue, z_unknown=[{}, {y_unknown=newString}]} |


  @Error
  Scenario Outline: Remove Specified Keys, Basic Arrays, Paths Objects errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When TestingInternalSteps I transform json map using RunStateKey "jsonMap.key" and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | jsonMap.key | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |

    Examples:
      | path                        | value     | type             | error                                                        |
      | a_boolean[0].z_unknown      | newString | java.lang.String | Unable to convert primative to array, at path 'a_boolean'.   |
      | a_float[0].z_unknown        | newString | java.lang.String | Unable to convert primative to array, at path 'a_float'.     |
      | a_integer[0].z_unknown      | newString | java.lang.String | Unable to convert primative to array, at path 'a_integer'.   |
      | a_object_empty[0].z_unknown | newString | java.lang.String | Unable to convert object to array, at path 'a_object_empty'. |
      | a_string[0].z_unknown       | newString | java.lang.String | Unable to convert primative to array, at path 'a_string'.    |
