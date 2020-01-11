@Json
@Map
@ConvertObjectToMap
Feature: Convert Map To Json (Unformatted Formatting) - Checking with Specified keys


  @Error
  Scenario: Null input
    Given I have cleared the run state for keys:
      | jsonMap.key    |
      | jsonString.key |
    And I have an empty run state
    When TestingInternalSteps I convert json map using RunStateKey "jsonMap.key", to json string using RunStateKey "jsonString.key" produces the AssertionError "Run State Validation (1 failure)\n\tjava.lang.AssertionError: Keys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[jsonMap.key]>"
    Then I have an empty run state


  @Error
  Scenario: Empty input
    Given I have cleared the run state for keys:
      | jsonMap.key    |
      | jsonString.key |
    And TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_Empty |
    Then I convert json map using RunStateKey "jsonMap.key", to unformatted json string using RunStateKey "jsonString.key"
    Then I have run state key->value string pairs of:
      | jsonString.key | {} |


  @Success
  Scenario: Simple input
    Given I have cleared the run state for keys:
      | jsonMap.key    |
      | jsonString.key |
    And TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicArrays |
    When I convert json map using RunStateKey "jsonMap.key", to unformatted json string using RunStateKey "jsonString.key"
    Then I have run state key->value string pairs of:
      | jsonString.key | {"objects_array":[{"object_array_id":"aObjectArrayId"},{"object_array_id":"bObjectArrayId"},{"object_array_id":"cObjectArrayId"},{"object_array_id":"dObjectArrayId"}],"primitive":"aPrimitive","primitives_array":["aPrimitiveArray","bPrimitiveArray","cPrimitiveArray","dPrimitiveArray"]} |


  @Success
  Scenario: Simple input
    Given I have cleared the run state for keys:
      | jsonMap.key    |
      | jsonString.key |
    And TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicPrimitives |
    When I convert json map using RunStateKey "jsonMap.key", to unformatted json string using RunStateKey "jsonString.key"
    Then I have run state key->value string pairs of:
      | jsonString.key | {"a_boolean":true,"a_float":12.34,"a_integer":1234,"a_null":null,"a_object":{},"a_string":"aValue"} |
