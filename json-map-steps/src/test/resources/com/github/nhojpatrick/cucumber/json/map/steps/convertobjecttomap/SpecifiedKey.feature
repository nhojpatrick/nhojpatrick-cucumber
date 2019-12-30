@Json
@Map
@ConvertObjectToMap
Feature: Convert Object To Map - Checking with Specified keys


  @Error
  Scenario: Null input
    Given I have cleared the run state for keys:
      | object.key  |
      | jsonMap.key |
    And I have an empty run state
    When TestingInternalSteps I convert object using RunStateKey "object.key", to json map using RunStateKey "jsonMap.key" produces the AssertionError "Run State Validation (1 failure)\n\tjava.lang.AssertionError: Keys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[object.key]>"
    Then I have an empty run state


  @Error
  Scenario: Empty input
    Given I have cleared the run state for keys:
      | jsonMap.key |
    And TestingInternalSteps I have setup the run state for keys and type:
      | object.key | Object |
    When TestingInternalSteps I convert object using RunStateKey "object.key", to json map using RunStateKey "jsonMap.key" produces the IllegalArgumentException "No serializer found for class java.lang.Object and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)"
    Then I have run state key->value string pairs of:
      | jsonMap.map | null |


  @Success
  Scenario: Simple input
    Given I have cleared the run state for keys:
      | jsonMap.key |
    And TestingInternalSteps I have setup the run state for keys and type:
      | object.key | SimpleObject |
    When I convert object using RunStateKey "object.key", to json map using RunStateKey "jsonMap.key"
    Then I have run state key->value string pairs of:
      | jsonMap.key | {simpleName=ASimpleName} |


  @Success
  Scenario: Complex input
    Given I have cleared the run state for keys:
      | jsonMap.key |
    And TestingInternalSteps I have setup the run state for keys and type:
      | object.key | ComplexObject |
    When I convert object using RunStateKey "object.key", to json map using RunStateKey "jsonMap.key"
    Then I have run state key->value string pairs of:
      | jsonMap.key | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1223, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2234, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3245, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1123, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2134, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3145, lcBottom={bravo=objs3Bravo}}]} |
