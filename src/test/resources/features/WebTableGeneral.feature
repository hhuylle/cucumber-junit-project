@WT
Feature: Some of the general functionality verification

  Scenario: Dropdown options verification
   Given user is already logged in to The Web table app
   When user is on the “Order” page
   Then user sees below options under product dropdown
     | MoneyCog   |
     | Familybea |
     | Screenable |

  Scenario: Payment options scenario
    Given user is already logged in to The Web table app
    When user is on the “Order” page
    Then user see Visa as enabled payment options
    Then user see MasterCard as enabled payment options
    Then user see American Express as enabled payment options


  #PARAMETERIZED VERSION OF THE SCENARIO
  Scenario: Order place scenario
    Given user is already logged in to The Web table app
    When user is on the “Order” page
    Then user enters quantity "2"
    Then user clicks to calculate button
    Then user enters customer name "Jane Doe"
    Then user enters street "7th Street"
    Then user enters city "New York"
    Then user enters in state "New York"
    Then user enters in zip "12345"
    Then user select Payment Option "MasterCard"
    Then user enter credit card number "123456789123"
    Then user chooses expiration date "12/25"
    Then user clicks to process order button
    Then user should see "Jane Doe" in the first row if the web table

  @wip5
  #SCENARIO OUTLINE VERSION
  Scenario Outline: Order place scenario
    Given user is already logged in to The Web table app
    When user is on the “Order” page
    Then user enters quantity "<quantity>"
    Then user clicks to calculate button
    Then user enters customer name "<customerName>"
    Then user enters street "<street>"
    Then user enters city "<city>"
    Then user enters in state "<state>"
    Then user enters in zip "<zip>"
    Then user select Payment Option "<paymentType>"
    Then user enter credit card number "<cardNumber>"
    Then user chooses expiration date "<ExpDate>"
    Then user clicks to process order button
    Then user should see "<expectedName>" in the first row if the web table

    Examples:
      | quantity | customerName | street | city | state | zip   | paymentType | cardNumber       | ExpDate | expectedName |
      | 3        | John Doe     | 7th St | NY   | NY    | 12345 | Visa        | 123456789123     | 12/25   | John Doe     |
      | 3        | Jane Doe     | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | Jane Doe     |
      | 3        | Jack Doe     | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | Jack Doe     |
      #| 3        | Jen Doe      | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | Jen Doe      |
      #| 3        | Mike Doe     | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | Mike Doe     |
      #| 3        | Mary Doe     | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | Mary Doe     |

