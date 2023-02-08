Feature: UI testing


  Scenario: User download CSV file from the page
    Given User do some preparations for the test
    Then User download CSV file from chart context menu

  Scenario: User assert text from tooltip with CSV file
    Given User do some preparations for the test
    When User write all information from tooltips
    Then User read expected data from the file
    Then User verify text from Tooltips with text from CSV file