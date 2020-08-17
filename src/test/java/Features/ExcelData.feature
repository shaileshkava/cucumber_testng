Feature: Excel data reader

  Scenario: Get data from excel and submit into form
    Given Open applicatoin url
    When Enter message from this excel and verify message
      | Path                                      | SheetIndex |
      | src/test/resources/TestData/TestData.xlsx |          0 |
      
   Scenario: Get data from excel and submit into form123
    Given Open applicatoin url
    When Enter message from this excel and verify message
      | Path                                      | SheetIndex |
      | src/test/resources/TestData/TestData.xlsx |          0 |   