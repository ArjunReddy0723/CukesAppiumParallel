@smoke
Feature: This just contains One scenarios that sleeps for one second each

  This feature file just sleeps for a 4 seconds (one second each scenario)
  It is not meant to do anything, but sleep
  So we can prove that it runs in parallel

  Scenario: Example 3 that sleep 1 seconds
    Given I accept the tip screen
    When I click on 4 number
    And I click on 3 number
    Then It should finnish