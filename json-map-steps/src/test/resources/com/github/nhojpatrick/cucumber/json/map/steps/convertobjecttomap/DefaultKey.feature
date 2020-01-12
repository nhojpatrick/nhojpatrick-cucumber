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
  Scenario: Null input
    Given TestingInternalSteps I convert object to json map using default RunStateKeys produces the AssertionError "Run State Validation (1 failure)\n\tjava.lang.AssertionError: Keys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[runState.json.obj]>"
    Then I have an empty run state


  @Error
  Scenario: Empty input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | Object |
    When TestingInternalSteps I convert object to json map using default RunStateKeys produces the IllegalArgumentException "No serializer found for class java.lang.Object and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)"
    Then I have run state key->value string pairs of:
      | runState.json.map | null |


  @Success
  Scenario: Simple input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | SimpleObject |
    When I convert object to json map using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.map | {simpleName=ASimpleName} |


  @Success
  Scenario: Complex input
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    When I convert object to json map using default RunStateKeys
    Then I have run state key->value string pairs of:
      | runState.json.map | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |
