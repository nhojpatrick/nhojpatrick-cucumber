@Json
@Map
@ConvertObjectToMap
Feature: Convert Map To Json (Formatted Formatting) - Checking with Specified keys


  Background: Check Clear Run State
    Given I have cleared the run state for keys:
      | jsonMap.key    |
      | jsonString.key |
    And I have an empty run state


  @Error
  Scenario: Null input
    Given TestingInternalSteps I convert json map using RunStateKey "jsonMap.key", to json string using RunStateKey "jsonString.key" produces the AssertionError "Run State Validation (1 failure)\n\tjava.lang.AssertionError: Keys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[jsonMap.key]>"
    Then I have an empty run state


  @Error
  Scenario: Empty input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_Empty |
    Then I convert json map using RunStateKey "jsonMap.key", to formatted json string using RunStateKey "jsonString.key"
    Then I have run state key->value string pairs of:
      | jsonString.key | { } |


  @Success
  Scenario: Simple input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicArrays |
    When I convert json map using RunStateKey "jsonMap.key", to formatted json string using RunStateKey "jsonString.key"
    Then I have run state key->value string pairs of:
      | jsonString.key | {\n  "objects_array" : [ {\n    "object_array_id" : "aObjectArrayId"\n  }, {\n    "object_array_id" : "bObjectArrayId"\n  }, {\n    "object_array_id" : "cObjectArrayId"\n  }, {\n    "object_array_id" : "dObjectArrayId"\n  } ],\n  "objects_empty" : [ ],\n  "objects_null" : null,\n  "primitives_array" : [ "aPrimitiveArray", "bPrimitiveArray", "cPrimitiveArray", "dPrimitiveArray" ],\n  "primitives_empty" : [ ],\n  "primitives_null" : null\n} |


  @Success
  Scenario: Simple input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | jsonMap.key | Map_BasicAttributes |
    When I convert json map using RunStateKey "jsonMap.key", to formatted json string using RunStateKey "jsonString.key"
    Then I have run state key->value string pairs of:
      | jsonString.key | {\n  "a_boolean" : true,\n  "a_float" : 12.34,\n  "a_integer" : 1234,\n  "a_null" : null,\n  "a_object_empty" : { },\n  "a_string" : "aValue"\n} |
