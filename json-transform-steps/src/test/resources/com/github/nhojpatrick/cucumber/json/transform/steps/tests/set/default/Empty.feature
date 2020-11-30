@Json
@Transformation
@Remove
Feature: Transformation - Set - Checking Empty with Default keys


  Background: Check Clear Run State
    Given I have cleared the run state for keys:
      | runState.json.map |
    And I have an empty run state


  @Success
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Attributes success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When I transform json map using default RunStateKey on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path      | value     | type              | expected              |
      | z_unknown | false     | java.lang.Boolean | {z_unknown=false}     |
      | z_unknown | true      | java.lang.Boolean | {z_unknown=true}      |
      | z_unknown | 12.34     | java.lang.Double  | {z_unknown=12.34}     |
      | z_unknown | 12.34     | java.lang.Float   | {z_unknown=12.34}     |
      | z_unknown | 1234      | java.lang.Integer | {z_unknown=1234}      |
      | z_unknown | 1234      | java.lang.Long    | {z_unknown=1234}      |
      | z_unknown | newString | java.lang.String  | {z_unknown=newString} |
      | z_unknown |           | null              | {z_unknown=null}      |
      | z_unknown |           | JsonObject        | {z_unknown={}}        |


  @Error
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Attributes errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When TestingInternalSteps I transform json map using default RunStateKey and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {} |

    Examples:
      | path | value | type | error |


  @Success
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Arrays success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When I transform json map using default RunStateKey on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path         | value     | type              | expected                      |
      | z_unknown[0] | false     | java.lang.Boolean | {z_unknown=[false]}           |
      | z_unknown[0] | true      | java.lang.Boolean | {z_unknown=[true]}            |
      | z_unknown[0] | 12.34     | java.lang.Double  | {z_unknown=[12.34]}           |
      | z_unknown[0] | 12.34     | java.lang.Float   | {z_unknown=[12.34]}           |
      | z_unknown[0] | 1234      | java.lang.Integer | {z_unknown=[1234]}            |
      | z_unknown[0] | 1234      | java.lang.Long    | {z_unknown=[1234]}            |
      | z_unknown[0] | newString | java.lang.String  | {z_unknown=[newString]}       |
      | z_unknown[0] |           | null              | {z_unknown=[null]}            |
      | z_unknown[0] |           | JsonObject        | {z_unknown=[{}]}              |

      | z_unknown[1] | false     | java.lang.Boolean | {z_unknown=[null, false]}     |
      | z_unknown[1] | true      | java.lang.Boolean | {z_unknown=[null, true]}      |
      | z_unknown[1] | 12.34     | java.lang.Double  | {z_unknown=[null, 12.34]}     |
      | z_unknown[1] | 12.34     | java.lang.Float   | {z_unknown=[null, 12.34]}     |
      | z_unknown[1] | 1234      | java.lang.Integer | {z_unknown=[null, 1234]}      |
      | z_unknown[1] | 1234      | java.lang.Long    | {z_unknown=[null, 1234]}      |
      | z_unknown[1] | newString | java.lang.String  | {z_unknown=[null, newString]} |
      | z_unknown[1] |           | null              | {z_unknown=[null, null]}      |
      | z_unknown[1] |           | JsonObject        | {z_unknown=[null, {}]}        |

  @Error
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Arrays errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When TestingInternalSteps I transform json map using default RunStateKey and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {} |

    Examples:
      | path | value | type | error |


  @Success
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Object success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When I transform json map using default RunStateKey on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                | value     | type              | expected                          |
      | z_unknown.y_unknown | newString | java.lang.String  | {z_unknown={y_unknown=newString}} |
      | z_unknown.y_unknown | false     | java.lang.Boolean | {z_unknown={y_unknown=false}}     |
      | z_unknown.y_unknown | true      | java.lang.Boolean | {z_unknown={y_unknown=true}}      |
      | z_unknown.y_unknown | 12.34     | java.lang.Double  | {z_unknown={y_unknown=12.34}}     |
      | z_unknown.y_unknown | 12.34     | java.lang.Float   | {z_unknown={y_unknown=12.34}}     |
      | z_unknown.y_unknown | 1234      | java.lang.Integer | {z_unknown={y_unknown=1234}}      |
      | z_unknown.y_unknown | 1234      | java.lang.Long    | {z_unknown={y_unknown=1234}}      |
      | z_unknown.y_unknown | newString | java.lang.String  | {z_unknown={y_unknown=newString}} |
      | z_unknown.y_unknown |           | null              | {z_unknown={y_unknown=null}}      |
      | z_unknown.y_unknown |           | JsonObject        | {z_unknown={y_unknown={}}}        |


  @Error
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Object errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When TestingInternalSteps I transform json map using default RunStateKey and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {} |

    Examples:
      | path | value | type | error |


  @Success
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Objects success
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When I transform json map using default RunStateKey on paths:
      | path   | action | value   | type   |
      | <path> | Set    | <value> | <type> |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                   | value     | type              | expected                                |
      | z_unknown[0].y_unknown | false     | java.lang.Boolean | {z_unknown=[{y_unknown=false}]}         |
      | z_unknown[0].y_unknown | true      | java.lang.Boolean | {z_unknown=[{y_unknown=true}]}          |
      | z_unknown[0].y_unknown | 12.34     | java.lang.Double  | {z_unknown=[{y_unknown=12.34}]}         |
      | z_unknown[0].y_unknown | 12.34     | java.lang.Float   | {z_unknown=[{y_unknown=12.34}]}         |
      | z_unknown[0].y_unknown | 1234      | java.lang.Integer | {z_unknown=[{y_unknown=1234}]}          |
      | z_unknown[0].y_unknown | 1234      | java.lang.Long    | {z_unknown=[{y_unknown=1234}]}          |
      | z_unknown[0].y_unknown | newString | java.lang.String  | {z_unknown=[{y_unknown=newString}]}     |
      | z_unknown[0].y_unknown |           | null              | {z_unknown=[{y_unknown=null}]}          |
      | z_unknown[0].y_unknown |           | JsonObject        | {z_unknown=[{y_unknown={}}]}            |

      | z_unknown[1].y_unknown | false     | java.lang.Boolean | {z_unknown=[{}, {y_unknown=false}]}     |
      | z_unknown[1].y_unknown | true      | java.lang.Boolean | {z_unknown=[{}, {y_unknown=true}]}      |
      | z_unknown[1].y_unknown | 12.34     | java.lang.Double  | {z_unknown=[{}, {y_unknown=12.34}]}     |
      | z_unknown[1].y_unknown | 12.34     | java.lang.Float   | {z_unknown=[{}, {y_unknown=12.34}]}     |
      | z_unknown[1].y_unknown | 1234      | java.lang.Integer | {z_unknown=[{}, {y_unknown=1234}]}      |
      | z_unknown[1].y_unknown | 1234      | java.lang.Long    | {z_unknown=[{}, {y_unknown=1234}]}      |
      | z_unknown[1].y_unknown | newString | java.lang.String  | {z_unknown=[{}, {y_unknown=newString}]} |
      | z_unknown[1].y_unknown |           | null              | {z_unknown=[{}, {y_unknown=null}]}      |
      | z_unknown[1].y_unknown |           | JsonObject        | {z_unknown=[{}, {y_unknown={}}]}        |


  @Error
  Scenario Outline: Set Default Keys, Basic Arrays, Paths Objects errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.map | Map_Empty |
    When TestingInternalSteps I transform json map using default RunStateKey and set the following path "<path>" to "<value>" of type "<type>" produces the IllegalPathOperationException "<error>"
    Then I have run state key->value string pairs of:
      | runState.json.map | {} |

    Examples:
      | path | value | type | error |
