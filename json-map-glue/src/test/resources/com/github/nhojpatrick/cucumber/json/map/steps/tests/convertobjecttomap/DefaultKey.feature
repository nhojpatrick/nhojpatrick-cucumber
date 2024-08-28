@Json
@Map
@ConvertObjectToMap
Feature: Convert Object To Map - Checking with Default keys


  Background: Check Clear Run State
    Given I have cleared the run state for keys:
      | runState.json.obj |
      | runState.json.map |
    And I have an empty run state


  @Error
  Scenario: Missing input
    Given TestingInternalSteps I convert object to json map using default RunStateKeys produces the AssertionError "Run State Validation (1 failure)\n\tjava.lang.AssertionError: Keys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[runState.json.obj]>"
    Then I have an empty run state


  @Error
  Scenario: Null input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | Object_Null |
    When TestingInternalSteps I convert object to json map using default RunStateKeys produces the RuntimeException "com.github.nhojpatrick.cucumber.core.exceptions.NullObjectException: Null object."
    Then I have run state key->value string pairs of:
      | runState.json.obj | null |


  @Error
  Scenario: Empty input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | Object_Empty |
    When TestingInternalSteps I convert object to json map using default RunStateKeys produces the IllegalArgumentException "No serializer found for class java.lang.Object and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)"
    Then I have run state key->value string pairs of:
      | runState.json.map | null |


  @Success
  Scenario: Simple input BasicArrays
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | Object_BasicArrays |
    When I convert object to json map using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.map | {objects_array=[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}], objects_empty=[], objects_null=null, primitives_array=[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray], primitives_empty=[], primitives_null=null} |


  @Success
  Scenario: Simple input BasicAttributes
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | Object_BasicAttributes |
    When I convert object to json map using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.map | {a_boolean=true, a_float=12.34, a_integer=1234, a_null=null, a_object_empty={}, a_string=aValue} |
