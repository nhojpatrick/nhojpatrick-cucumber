@Json
@Transformation
@Whitespace
Feature: Whitespace Transformations Checking Feature with Default keys


#  Scenario: Null input with default keys
#    Given I have cleared the run state for keys:
#      | runState.json.obj |
#      | runState.json.map |
#    And I have an empty run state
#    When I convert object to json map using default RunStateKeys produces the error "Run State Validation (1 failure)\n\tKeys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[runState.json.obj]>"
#    Then I have an empty run state
#
#
#  Scenario: Null input with specified keys
#    Given I have cleared the run state for keys:
#      | object.key  |
#      | jsonMap.key |
#    And I have an empty run state
#    When I convert object using RunStateKey "object.key", to json map using RunStateKey "jsonMap.key" produces the error "Run State Validation (1 failure)\n\tKeys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[object.key]>"
#    Then I have an empty run state
