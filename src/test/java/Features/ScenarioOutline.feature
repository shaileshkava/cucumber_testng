#Scenario outline runs number of times as per the rows mentioed in Examples
Feature: verify scenario outline

  Scenario Outline: Verify scenario outline for messages
    Given Open applicatoin url
    When user below data "<message>"

    Examples: 
      | message  |
      | scenario |
      | outline  |
