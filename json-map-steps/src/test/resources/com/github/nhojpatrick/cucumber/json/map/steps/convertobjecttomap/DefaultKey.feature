@Json
@Map
@ConvertObjectToMap
Feature: Convert Object To Map - Checking with Default keys


  @Error
  Scenario: Null input
    Given I have cleared the run state for keys:
      | runState.json.obj |
      | runState.json.map |
    And I have an empty run state
    When I convert object to json map using default RunStateKeys produces the AssertionError "Run State Validation (1 failure)\n\tjava.lang.AssertionError: Keys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[runState.json.obj]>"
    Then I have an empty run state


  @Error
  Scenario: Empty input
    Given I have cleared the run state for keys:
      | runState.json.map |
    And I have setup the run state for keys and type:
      | runState.json.obj | Object |
    When I convert object to json map using default RunStateKeys produces the IllegalArgumentException "No serializer found for class java.lang.Object and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)"
    Then I have run state key->value string pairs of:
      | runState.json.map | null |


  @Success
  Scenario: Simple input
    Given I have cleared the run state for keys:
      | runState.json.map |
    And I have setup the run state for keys and type:
      | runState.json.obj | SimpleObject |
    When I convert object to json map using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.map | {simpleName=ASimpleName} |


  @Success
  Scenario: Complex input
    Given I have cleared the run state for keys:
      | runState.json.map |
    And I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    When I convert object to json map using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.map | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1223, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2234, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3245, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1123, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2134, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3145, lcBottom={bravo=objs3Bravo}}]} |
