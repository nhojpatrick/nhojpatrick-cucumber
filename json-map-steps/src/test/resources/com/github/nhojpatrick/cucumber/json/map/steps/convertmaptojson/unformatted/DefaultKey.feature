@Json
@Map
@ConvertObjectToMap
Feature: Convert Map To Json (Unformatted Formatting) - Checking with Default keys


  Background: Check Clear Run State
    Given I have cleared the run state for keys:
      | runState.json.map    |
      | runState.json.string |
    And I have an empty run state


  @Error
  Scenario: Null input
    Given TestingInternalSteps I convert json map to json string using default RunStateKeys produces the AssertionError "Run State Validation (1 failure)\n\tjava.lang.AssertionError: Keys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[runState.json.map]>"
    Then I have an empty run state


  @Error
  Scenario: Empty input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    Then I convert json map to unformatted json string using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.string | {} |


  @Success
  Scenario: Simple input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When I convert json map to unformatted json string using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.string | {"null_array":null,"objects_array":[{"object_array_id":"aObjectArrayId"},{"object_array_id":"bObjectArrayId"},{"object_array_id":"cObjectArrayId"},{"object_array_id":"dObjectArrayId"}],"primitive":"aPrimitive","primitives_array":["aPrimitiveArray","bPrimitiveArray","cPrimitiveArray","dPrimitiveArray"]} |


  @Success
  Scenario: Simple input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicAttributes |
    When I convert json map to unformatted json string using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.string | {"a_boolean":true,"a_float":12.34,"a_integer":1234,"a_null":null,"a_object":{},"a_string":"aValue"} |
