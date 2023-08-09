
Feature: Etsy search functionality
  Agile Story: User should be able to type and keyword and see relevant information


  Scenario: Etsy Title Verification
    Given user is on the Etsy homepage
    Then user should see title is as expected
    #expectedTitle: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  Scenario: Etsy Search Functionality Title Verification (without parameterization)
    Given user is on the Etsy homepage
    When user type Wooden Spoon in the search box
    And user click search button
    Then user see Wooden spoon in the Title

  Scenario: Etsy Search Functionality Title Verification (with parameterization)
    Given user is on the Etsy homepage
    When user type "Wooden Spoon" in the search box
    And user click search button
    Then user see "Wooden spoon - Etsy" in the Title
