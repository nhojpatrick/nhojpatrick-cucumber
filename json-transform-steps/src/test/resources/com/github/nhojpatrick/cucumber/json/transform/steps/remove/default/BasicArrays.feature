@Json
@Transformation
@Remove
Feature: Transformation - Remove - Checking BasicArrays with Default keys


  Background: Check Clear Run State
    Given I have cleared the run state for keys:
      | runState.json.map |
    And I have an empty run state


  @Success
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Attributes success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When I transform json map using default RunStateKey on paths:
      | path   | action |
      | <path> | Remove |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path             | expected                                                                                                                                                                                                                                                                                                      |
      | objects_array    | {objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                                                                                                                                       |
      | objects_empty    | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |
      | objects_null     | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}  |
      | primitives_array | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_empty=[], primitives_null=null}                                                                      |
      | primitives_empty | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_null=null}    |
      | primitives_null  | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[]}     |


  @Error
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Attributes errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When TestingInternalSteps I transform json map using default RunStateKey and remove the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |

    Examples:
      | path      | error                               |
      | z_unknown | Path does not exist at 'z_unknown'. |


  @Success
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Arrays success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When I transform json map using default RunStateKey on paths:
      | path   | action |
      | <path> | Remove |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                | expected                                                                                                                                                                                                                                                                                                       |
      | objects_array[0]    | {objects_array=[{object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                  |
      | objects_array[1]    | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                  |
      | objects_array[2]    | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                  |
      | objects_array[3]    | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null}                  |
      | primitives_array[0] | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |
      | primitives_array[1] | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |
      | primitives_array[2] | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |
      | primitives_array[3] | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray], primitives_empty=[], primitives_null=null} |


  @Error
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Arrays errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When TestingInternalSteps I transform json map using default RunStateKey and remove the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |

    Examples:
      | path                | error                                                             |
      | objects_array[4]    | Unable to remove path 'objects_array[4]', beyond index of '3'.    |
      | objects_empty[0]    | Unable to remove path 'objects_empty', as array is empty.         |
      | objects_null[0]     | Unable to remove 'null' value, at path 'objects_null'.            |
      | primitives_array[4] | Unable to remove path 'primitives_array[4]', beyond index of '3'. |
      | primitives_empty[0] | Unable to remove path 'primitives_empty', as array is empty.      |
      | primitives_null[0]  | Unable to remove 'null' value, at path 'primitives_null'.         |
      | z_unknown[0]        | Path does not exist at 'z_unknown'.                               |


  @Success
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Object success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When I transform json map using default RunStateKey on paths:
      | path   | action |
      | <path> | Remove |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path | expected |


  @Error
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Object errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When TestingInternalSteps I transform json map using default RunStateKey and remove the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |

    Examples:
      | path                       | error                                                                                 |
      | objects_array.z_unknown    | Unable to convert array to object, at path 'objects_array'.                           |
      | objects_empty.z_unknown    | Unable to convert array to object, at path 'objects_empty'.                           |
      | objects_null.z_unknown     | AutoConvert 'null' value to object disabled, at path 'objects_null'.                  |
      | primitives_array.z_unknown | Unable to convert array to object, at path 'primitives_array'.                        |
      | primitives_empty.z_unknown | Unable to convert array to object, at path 'primitives_empty'.                        |
      | primitives_null.z_unknown  | AutoConvert 'null' value to object disabled, at path 'primitives_null'.               |
      | z_unknown.z_unknown        | Path 'z_unknown' does not existing and automatic creation disabled by transformation. |


  @Success
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Objects success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When I transform json map using default RunStateKey on paths:
      | path   | action |
      | <path> | Remove |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                             | expected                                                                                                                                                                                                                                                                                          |
      | objects_array[0].object_array_id | {objects_array=[{}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |
      | objects_array[1].object_array_id | {objects_array=[{object_array_id=aObjectArrayId}, {}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |
      | objects_array[2].object_array_id | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |
      | objects_array[3].object_array_id | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |


  @Error
  Scenario Outline: Remove Default Keys, Basic Arrays, Paths Objects errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When TestingInternalSteps I transform json map using default RunStateKey and remove the following path "<path>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |

    Examples:
      | path                             | error                                                                                        |
      | objects_array[0].z_unknown       | Path does not exist at 'objects_array[0].z_unknown'.                                         |
      | objects_array[1].z_unknown       | Path does not exist at 'objects_array[1].z_unknown'.                                         |
      | objects_array[2].z_unknown       | Path does not exist at 'objects_array[2].z_unknown'.                                         |
      | objects_array[3].z_unknown       | Path does not exist at 'objects_array[3].z_unknown'.                                         |
      | objects_array[4].object_array_id | Path 'objects_array[4]', beyond index of '3', automatic creation disabled by transformation. |
      | objects_array[4].z_unknown       | Path 'objects_array[4]', beyond index of '3', automatic creation disabled by transformation. |
      | objects_empty[0].z_unknown       | Path 'objects_empty', as array is empty, automatic creation disabled by transformation.      |
      | objects_null[0].z_unknown        | AutoConvert 'null' value to array disabled, at path 'objects_null'.                          |
      | primitives_array[0].z_unknown    | Unable to convert primative array to object array, at path 'primitives_array'.               |
      | primitives_array[1].z_unknown    | Unable to convert primative array to object array, at path 'primitives_array'.               |
      | primitives_array[2].z_unknown    | Unable to convert primative array to object array, at path 'primitives_array'.               |
      | primitives_array[3].z_unknown    | Unable to convert primative array to object array, at path 'primitives_array'.               |
      | primitives_array[4].z_unknown    | Unable to convert primative array to object array, at path 'primitives_array'.               |
      | primitives_empty[0].z_unknown    | Path 'primitives_empty', as array is empty, automatic creation disabled by transformation.   |
      | primitives_null[0].z_unknown     | AutoConvert 'null' value to array disabled, at path 'primitives_null'.                       |
      | z_unknown[0].z_unknown           | Path 'z_unknown' does not existing and automatic creation disabled by transformation.        |
