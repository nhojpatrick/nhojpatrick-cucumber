@ConvertObjectToMap
@Json
@Map
Feature: Convert Map To Json - Checking with Default keys


  @Error
  Scenario: Null input
    Given I have cleared the run state for keys:
      | runState.json.map    |
      | runState.json.string |
    And I have an empty run state
    When TestingInternalSteps I convert json map to json string using default RunStateKeys produces the AssertionError "Run State Validation (1 failure)\n\tjava.lang.AssertionError: Keys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[runState.json.map]>"
    Then I have an empty run state


  @Error
  Scenario: Empty input
    Given I have cleared the run state for keys:
      | runState.json.map    |
      | runState.json.string |
    And TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    Then I convert json map to formatted json string using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.string | { } |


  @Success
  Scenario: Simple input
    Given I have cleared the run state for keys:
      | runState.json.map    |
      | runState.json.string |
    And TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicArrays |
    When I convert json map to formatted json string using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.string | {\n  "objects_array" : [ {\n    "object_array_id" : "aObjectArrayId"\n  }, {\n    "object_array_id" : "bObjectArrayId"\n  }, {\n    "object_array_id" : "cObjectArrayId"\n  }, {\n    "object_array_id" : "dObjectArrayId"\n  } ],\n  "primitive" : "aPrimitive",\n  "primitives_array" : [ "aPrimitiveArray", "bPrimitiveArray", "cPrimitiveArray", "dPrimitiveArray" ]\n} |


  @Success
  Scenario: Simple input
    Given I have cleared the run state for keys:
      | runState.json.map    |
      | runState.json.string |
    And TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_BasicPrimitives |
    When I convert json map to formatted json string using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.string | {\n  "a_boolean" : true,\n  "a_float" : 12.34,\n  "a_integer" : 1234,\n  "a_null" : null,\n  "a_object" : { },\n  "a_string" : "aValue"\n} |
