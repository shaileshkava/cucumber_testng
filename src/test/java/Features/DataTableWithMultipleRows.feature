Feature: verify different messages in enter message form

  Scenario: Verify multiple time messages in textbox
    Given Open applicatoin url
    When enter message as following and verify message
      | message |
      | lorem   |
      | ipsum   |
    And enter following message
      | message  |
      | shailesh |
