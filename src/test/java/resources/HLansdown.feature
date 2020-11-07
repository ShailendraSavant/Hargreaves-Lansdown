Feature: To verify  authentication, dynamic load and java script Alert

 @iLogin
 Scenario Outline: I can login to herokuapp webiste
  Given I access herokuapp website
  When I enter valid "<Username>" and "<Password>"
  Then I click on login button
  And I am successfully logged in
 Examples:
 | Username        | Password           |
 | tomsmith        |SuperSecretPassword!|

 @LoadingBarTest
  Scenario Outline: Confirm 'Hello World!' is rendered after the loading bar disappears
   Given I navigate to test url "<url>"
   When I click on Dynamic Load link "<link>"
   And I click on Example two link "<link2>"
   And I click Start button
   Then Confirm Hello World! is rendered after the loading bar disappears
  Examples:
  | url                                 | link              | link2                                        |
  | https://the-internet.herokuapp.com/ |  Dynamic Loading  |  Example 2: Element rendered after the fact  |

 @JSalertTest
  Scenario Outline: I can click on JS confirm button
   Given I navigate to test url "<url>"
   And I click on JavaScript Alerts link "<link>"
   When I click on JS Confirm button
   Then JS Alert message is displayed
  Examples:
  |url                                 | link             |
  |https://the-internet.herokuapp.com/ |JavaScript Alerts |