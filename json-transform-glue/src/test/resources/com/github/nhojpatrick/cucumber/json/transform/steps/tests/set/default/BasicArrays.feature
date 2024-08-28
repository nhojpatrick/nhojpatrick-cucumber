@Json
@Transformation
@Remove
Feature: Transformation - Set - Checking BasicArrays with Default keys


  Background: Check Clear Run State
    Given I have cleared the run state for keys:
      | runState.json.map |
    And I have an empty run state


  @Success
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Attributes success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When I transform json map using default RunStateKey on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path             | value     | type             | expected                                                                                                                                                                                                                                                                                                                                             |
      | objects_array    | newString | java.lang.String | {objects_array=newString, objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                                                                                                                                     |
      | objects_empty    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=newString, objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}               |
      | objects_null     | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=newString, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                 |
      | primitives_array | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=newString, primitives_empty=[], primitives_null=null}                                                                                 |
      | primitives_empty | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=newString, primitives_null=null}               |
      | primitives_null  | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=newString}                 |
      | z_unknown        | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null, z_unknown=newString} |


  @Error
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Attributes errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When TestingInternalSteps I transform json map using default RunStateKey and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |

    Examples:
      | path | value | type | error |


  @Success
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Arrays success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When I transform json map using default RunStateKey on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                | value     | type             | expected                                                                                                                                                                                                                                                                                                                                                     |
      | objects_array[0]    | newString | java.lang.String | {objects_array=[newString, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                                     |
      | objects_array[1]    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, newString, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                                     |
      | objects_array[2]    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, newString, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                                     |
      | objects_array[3]    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, newString], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                                     |
      | objects_array[4]    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}, newString], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                   |
      | objects_array[5]    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}, null, newString], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}             |
      | objects_empty[0]    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[newString], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                     |
      | objects_empty[1]    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[null, newString], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}               |
      | objects_null[0]     | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=[newString], primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                       |
      | objects_null[1]     | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=[null, newString], primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                 |
      | primitives_array[0] | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[newString, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                    |
      | primitives_array[1] | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, newString, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                    |
      | primitives_array[2] | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, newString, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                    |
      | primitives_array[3] | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, newString], primitives_empty=[], primitives_null=null}                                    |
      | primitives_array[4] | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray, newString], primitives_empty=[], primitives_null=null}                   |
      | primitives_array[5] | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray, null, newString], primitives_empty=[], primitives_null=null}             |
      | primitives_empty[0] | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[newString], primitives_null=null}                     |
      | primitives_empty[1] | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[null, newString], primitives_null=null}               |
      | primitives_null[0]  | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=[newString]}                       |
      | primitives_null[1]  | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=[null, newString]}                 |
      | z_unknown[0]        | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null, z_unknown=[newString]}       |
      | z_unknown[1]        | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null, z_unknown=[null, newString]} |


  @Error
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Arrays errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When TestingInternalSteps I transform json map using default RunStateKey and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |

    Examples:
      | path | value | type | error |


  @Success
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Object success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When I transform json map using default RunStateKey on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                      | value     | type             | expected                                                                                                                                                                                                                                                                                                                                                         |
      | objects_null.z_unknown    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null={z_unknown=newString}, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                 |
      | primitives_null.z_unknown | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null={z_unknown=newString}}                 |
      | z_unknown.y_unknown       | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null, z_unknown={y_unknown=newString}} |


  @Error
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Object errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When TestingInternalSteps I transform json map using default RunStateKey and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |

    Examples:
      | path                       | value     | type             | error                                                          |
      | objects_array.z_unknown    | newString | java.lang.String | Unable to convert array to object, at path 'objects_array'.    |
      | objects_empty.z_unknown    | newString | java.lang.String | Unable to convert array to object, at path 'objects_empty'.    |
      | primitives_array.z_unknown | newString | java.lang.String | Unable to convert array to object, at path 'primitives_array'. |
      | primitives_empty.z_unknown | newString | java.lang.String | Unable to convert array to object, at path 'primitives_empty'. |


  @Success
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Objects success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When I transform json map using default RunStateKey on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                             | value     | type             | expected                                                                                                                                                                                                                                                                                                                                                               |
      | objects_array[0].object_array_id | newString | java.lang.String | {objects_array=[{object_array_id=newString}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                             |
      | objects_array[0].z_unknown       | newString | java.lang.String | {objects_array=[{z_unknown=newString, object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                   |
      | objects_array[1].object_array_id | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=newString}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                             |
      | objects_array[1].z_unknown       | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {z_unknown=newString, object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                   |
      | objects_array[2].object_array_id | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=newString}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                             |
      | objects_array[2].z_unknown       | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {z_unknown=newString, object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                   |
      | objects_array[3].object_array_id | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=newString}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                             |
      | objects_array[3].z_unknown       | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {z_unknown=newString, object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                   |
      | objects_array[4].object_array_id | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}, {object_array_id=newString}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}           |
      | objects_array[4].z_unknown       | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}, {z_unknown=newString}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                 |
      | objects_array[5].object_array_id | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}, {}, {object_array_id=newString}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}       |
      | objects_array[5].z_unknown       | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}, {}, {z_unknown=newString}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}             |
      | objects_empty[0].z_unknown       | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[{z_unknown=newString}], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                   |
      | objects_empty[1].z_unknown       | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[{}, {z_unknown=newString}], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}               |
      | objects_null[0].z_unknown        | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=[{z_unknown=newString}], primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                     |
      | objects_null[1].z_unknown        | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=[{}, {z_unknown=newString}], primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                 |
      | primitives_empty[0].z_unknown    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[{z_unknown=newString}], primitives_null=null}                   |
      | primitives_empty[1].z_unknown    | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[{}, {z_unknown=newString}], primitives_null=null}               |
      | primitives_null[0].z_unknown     | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=[{z_unknown=newString}]}                     |
      | primitives_null[1].z_unknown     | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=[{}, {z_unknown=newString}]}                 |
      | z_unknown[0].z_unknown           | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null, z_unknown=[{z_unknown=newString}]}     |
      | z_unknown[1].z_unknown           | newString | java.lang.String | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null, z_unknown=[{}, {z_unknown=newString}]} |


  @Error
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Objects errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When TestingInternalSteps I transform json map using default RunStateKey and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |

    Examples:
      | path                          | value     | type             | error                                                                          |
      | primitives_array[0].z_unknown | newString | java.lang.String | Unable to convert primative array to object array, at path 'primitives_array'. |
      | primitives_array[1].z_unknown | newString | java.lang.String | Unable to convert primative array to object array, at path 'primitives_array'. |
      | primitives_array[2].z_unknown | newString | java.lang.String | Unable to convert primative array to object array, at path 'primitives_array'. |
      | primitives_array[3].z_unknown | newString | java.lang.String | Unable to convert primative array to object array, at path 'primitives_array'. |
      | primitives_array[4].z_unknown | newString | java.lang.String | Unable to convert primative array to object array, at path 'primitives_array'. |
