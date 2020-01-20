@Json
@Transformation
@Reverse
Feature: Transformation - Reverse - Checking with Default keys


  @Success
  Scenario Outline: Reverse defaultKeys transform complex input basic paths
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When I transform json map using default RunStateKey on paths:
      | path   | action  |
      | <path> | Reverse |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                            | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
      | active                          | {active=eurt, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}              |
      | count                           | {active=true, count=4323, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}              |
      | objs                            | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}], tags=[tagOne, tagTwo, tagThree], title=Complex}              |
      | tags                            | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagThree, tagTwo, tagOne], title=Complex}              |
      | title                           | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=xelpmoC}              |
      | unknown1                        | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}              |
      | unknown1.unknown2               | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex, unknown1={}} |

      | nested.labels                   | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelThree, labelTwo, labelOne], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}              |
      | nested.name                     | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=detseN, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}              |
      | nested.nests                    | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}              |
      | nested.unknown1                 | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}              |
      | nested.unknown1.unknown2        | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}], unknown1={}}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |

      | nested.bottom.alpha             | {active=true, count=3234, nested={bottom={alpha=ahplA}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}              |
      | nested.bottom.unknown1          | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}              |
      | nested.bottom.unknown1.unknown2 | {active=true, count=3234, nested={bottom={alpha=Alpha, unknown1={}}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |


  @Error
  Scenario Outline: Reverse defaultKeys transform complex input basic paths errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When TestingInternalSteps I transform json map using default RunStateKey and reverse the following path "<path>" produces the IllegalPathOperationException "<error>"
    # check run state has not changed
    And I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                | error                                                         | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
      | nested              | Unable to reverse JsonObject, at path 'nested'.               | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |
      | nested.bottom       | Unable to reverse JsonObject, at path 'nested.bottom'.        | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |
      | title.unknown       | Unable to convert primative to object, at path 'title'.       | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |
      | nested.name.unknown | Unable to convert primative to object, at path 'nested.name'. | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |


  @Success
  Scenario Outline: Complex input array <Primative> paths
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When I transform json map using default RunStateKey on paths:
      | path   | action  |
      | <path> | Reverse |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path              | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
      | tags[0]           | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[enOgat, tagTwo, tagThree], title=Complex}                                                 |
      | tags[1]           | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, owTgat, tagThree], title=Complex}                                                 |
      | tags[2]           | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, eerhTgat], title=Complex}                                                 |
      | tags[3]           | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree, null], title=Complex}                                           |
      | tags[10]          | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree, null, null, null, null, null, null, null, null], title=Complex} |

      | nested.labels[0]  | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[enOlebal, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}                                                 |
      | nested.labels[1]  | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, owTlebal, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}                                                 |
      | nested.labels[2]  | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, eerhTlebal], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}                                                 |
      | nested.labels[3]  | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree, null], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}                                           |
      | nested.labels[10] | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree, null, null, null, null, null, null, null, null], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |


  @Error
  Scenario Outline: Complex input array <Primative> paths errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When TestingInternalSteps I transform json map using default RunStateKey and reverse the following path "<path>" produces the IllegalPathOperationException "<error>"
    # check run state has not changed
    And I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                     | error                                                                       | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
      | tags[1].unknown          | Unable to convert primative array to object array, at path 'tags'.          | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |
      | nested.labels[1].unknown | Unable to convert primative array to object array, at path 'nested.labels'. | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |


  @Success
  Scenario Outline: Complex input array <Object> paths
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When I transform json map using default RunStateKey on paths:
      | path   | action  |
      | <path> | Reverse |
    Then I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                             | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
      #| objs[0]                          | {count=4323, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1223, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2234, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3245, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs2, lcId=2134, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3145, lcBottom={bravo=objs3Bravo}}]}                                                      |
      #| objs[1]                          | {count=4323, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1223, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2234, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3245, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1123, lcBottom={bravo=objs1Bravo}}, {lcName=objs3, lcId=3145, lcBottom={bravo=objs3Bravo}}]}                                                      |
      #| objs[2]                          | {count=4323, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1223, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2234, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3245, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1123, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2134, lcBottom={bravo=objs2Bravo}}]}                                                      |
      | objs[3]                          | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}, null], tags=[tagOne, tagTwo, tagThree], title=Complex}                                           |
      | objs[10]                         | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}, null, null, null, null, null, null, null, null], tags=[tagOne, tagTwo, tagThree], title=Complex} |

      | objs[1].lcId                     | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=4312, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}                                                 |
      #| objs[1].lcBottom                 | {count=4323, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1223, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2234, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3245, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1123, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2134}, {lcName=objs3, lcId=3145, lcBottom={bravo=objs3Bravo}}]}                              |
      | objs[1].lcBottom.bravo           | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=ovarB2sjbo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}                                                 |

      #| nested.nests[0]                  | {count=4323, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests2, lnId=2234, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3245, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1123, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2134, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3145, lcBottom={bravo=objs3Bravo}}]}                                                            |
      #| nested.nests[1]                  | {count=4323, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1223, lnBottom={charlie=nests1Charlie}}, {lnName=nests3, lnId=3245, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1123, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2134, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3145, lcBottom={bravo=objs3Bravo}}]}                                                            |
      #| nested.nests[2]                  | {count=4323, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1223, lnBottom={charlie=nests1Charlie}}, {lnName=nests2, lnId=2234, lnBottom={charlie=nests2Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1123, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2134, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3145, lcBottom={bravo=objs3Bravo}}]}                                                            |
      | nested.nests[3]                  | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}, null]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}                                           |
      | nested.nests[10]                 | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}, null, null, null, null, null, null, null, null]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |

      | nested.nests[0].lnId             | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=3221, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}                                                 |
      #| nested.nests[0].lnBottom         | {count=4323, active=true, title=Complex, nested={name=Nested, labels=[labelOne, labelTwo, labelThree], bottom={alpha=Alpha}, nests=[{lnName=nests1, lnId=1234023}, {lnName=nests2, lnId=2234, lnBottom={charlie=nests2Charlie}}, {lnName=nests3, lnId=3245, lnBottom={charlie=nests3Charlie}}]}, tags=[tagOne, tagTwo, tagThree], objs=[{lcName=objs1, lcId=1123, lcBottom={bravo=objs1Bravo}}, {lcName=objs2, lcId=2134, lcBottom={bravo=objs2Bravo}}, {lcName=objs3, lcId=3145, lcBottom={bravo=objs3Bravo}}]}                                   |
      | nested.nests[0].lnBottom.charlie | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=eilrahC1stsen}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex}                                                 |


  @Error
  Scenario Outline: Complex input array <Object> paths errors
    Given TestingInternalSteps I have setup the run state for keys and type:
      | runState.json.obj | ComplexObject |
    And I convert object to json map using default RunStateKeys
    When TestingInternalSteps I transform json map using default RunStateKey and reverse the following path "<path>" produces the IllegalPathOperationException "<error>"
    # check run state has not changed
    And I have run state key->value string pairs of:
      | runState.json.map | <expected> |

    Examples:
      | path                 | error                                                      | expected                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
      | objs.unknown         | Unable to convert array to object, at path 'objs'.         | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |
      | nested.nests.unknown | Unable to convert array to object, at path 'nested.nests'. | {active=true, count=3234, nested={bottom={alpha=Alpha}, labels=[labelOne, labelTwo, labelThree], name=Nested, nests=[{lnBottom={charlie=nests1Charlie}, lnId=1223, lnName=nests1}, {lnBottom={charlie=nests2Charlie}, lnId=2234, lnName=nests2}, {lnBottom={charlie=nests3Charlie}, lnId=3245, lnName=nests3}]}, objs=[{lcBottom={bravo=objs1Bravo}, lcId=1123, lcName=objs1}, {lcBottom={bravo=objs2Bravo}, lcId=2134, lcName=objs2}, {lcBottom={bravo=objs3Bravo}, lcId=3145, lcName=objs3}], tags=[tagOne, tagTwo, tagThree], title=Complex} |
