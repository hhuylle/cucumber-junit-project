Feature: Cucumber Data Tables implementation practices


  Scenario: List of fruits and vegetables I like
    Then user should see below list
      | orange     |
      | apple      |
      | grape      |
      | strawberry |
      | blueberry  |
      | tomato     |
      | spinach    |
      | eggplant   |

    # To beautify the pipes above: Ctrl + Alt + L

  #Create a new scenario where we list the type of pets we love
  #Print out all the strings in the list

  Scenario: List of animals I love
    Then I share my list's love
      | Dog        |
      | Cat        |
      | Lion       |
      | Pander     |
      | Polar Bear |
      | Eagle      |
      | Cobra      |
      | Tiger      |


  Scenario: Officer reads data about driver
    Then officer is able to see any data he wants
      | name    | Jane        |
      | surname | Doe         |
      | age     | 29          |
      | address | somewhere   |
      | state   | TX          |
      | zipcode | 12345       |
      | phone   | 123-456-789 |

  @dataTables
  Scenario: user should be able to see all 12 months dropdown
    Given user is on the dropdown page
    Then user should see below info of month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |