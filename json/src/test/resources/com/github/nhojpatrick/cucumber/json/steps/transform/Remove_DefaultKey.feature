@Json
@Remove
@Transformation
Feature: Transformation - Remove - Checking with Default keys


  @Success
  Scenario Outline: Remove defaultKeys transform complex input basic paths
    Given I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When I transform json map using default RunStateKey on paths:
      | path   | action |
      | <path> | remove |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                            | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
      | active                          | {count=3234, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                      |
      | count                           | {active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                     |
      | nested                          | {count=3234, active=true, title=Complex, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                                                                                                                                                                                                                                                                                       |
      | objs                            | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree]}                                                                                                                                                                                               |
      | tags                            | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                                          |
      | title                           | {count=3234, active=true, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                        |
      | unknown1                        | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                         |
      | unknown1.unknown2               | {count=3234, unknown1={}, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}            |

      | nested.bottom                   | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                               |
      | nested.labels                   | {count=3234, active=true, title=Complex, nested={name=Nested, bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                                                  |
      | nested.name                     | {count=3234, active=true, title=Complex, nested={labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                      |
      | nested.nests                    | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                                                                                                                                                                                                  |
      | nested.unknown1                 | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                         |
      | nested.unknown1.unknown2        | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}], unknown1={}}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}            |

      | nested.bottom.alpha             | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                    |
      | nested.bottom.unknown1          | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                         |
      | nested.bottom.unknown1.unknown2 | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha, unknown1={}}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}            |


  @Error
  Scenario Outline: Remove defaultKeys transform complex input basic paths errors
    Given I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When I transform json map using default RunStateKey and remove the following path "<path>" produces the IllegalOperationException "<error>"
    # check run state has not changed
    And I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                | error                                                         | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
      | title.unknown       | Unable to convert primative to object, at path 'title'.       | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |
      | nested.name.unknown | Unable to convert primative to object, at path 'nested.name'. | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |


  @Success
  Scenario Outline: Complex input array <Primative> paths
    Given I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When I transform json map using default RunStateKey on paths:
      | path   | action |
      | <path> | remove |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path              | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
      | tags[0]           | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}         |
      | tags[1]           | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}         |
      | tags[2]           | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}           |
      | tags[3]           | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |
      | tags[10]          | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |

      | nested.labels[0]  | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}           |
      | nested.labels[1]  | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}           |
      | nested.labels[2]  | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}             |
      | nested.labels[3]  | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |
      | nested.labels[10] | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |


  @Error
  Scenario Outline: Complex input array <Primative> paths errors
    Given I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When I transform json map using default RunStateKey and remove the following path "<path>" produces the IllegalOperationException "<error>"
    # check run state has not changed
    And I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                     | error                                                                          | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
      | tags[1].unknown          | Unable to convert primative array to object array, at path 'tags[1]'.          | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |
      | nested.labels[1].unknown | Unable to convert primative array to object array, at path 'nested.labels[1]'. | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |


  @Success
  Scenario Outline: Complex input array <Object> paths
    Given I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When I transform json map using default RunStateKey on paths:
      | path   | action |
      | <path> | remove |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                             | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
      | objs[0]                          | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                                      |
      | objs[1]                          | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                                      |
      | objs[2]                          | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}]}                                                      |
      | objs[3]                          | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |
      | objs[10]                         | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |

      | objs[1].lcId                     | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}         |
      | objs[1].lcBottom                 | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                              |
      | objs[1].lcBottom.bravo           | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                 |

      | nested.nests[0]                  | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                                            |
      | nested.nests[1]                  | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                                            |
      | nested.nests[2]                  | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                                            |
      | nested.nests[3]                  | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |
      | nested.nests[10]                 | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |

      | nested.nests[0].lnId             | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}         |
      | nested.nests[0].lnBottom         | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                                   |
      | nested.nests[0].lnBottom.charlie | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]}                      |


  @Error
  Scenario Outline: Complex input array <Object> paths errors
    Given I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When I transform json map using default RunStateKey and remove the following path "<path>" produces the IllegalOperationException "<error>"
    # check run state has not changed
    And I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                 | error                                                      | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
      | objs.unknown         | Unable to convert array to object, at path 'objs'.         | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |
      | nested.nests.unknown | Unable to convert array to object, at path 'nested.nests'. | {count=3234, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3, lcBottom={bravo=objs3Bravo}}]} |

