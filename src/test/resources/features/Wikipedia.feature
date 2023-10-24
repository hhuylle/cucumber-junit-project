
Feature: Wikipedia search feature
  TC-1


  Scenario: Wikipedia Search Functionality Title Verification
    Given user is on the Wikipedia homepage
    When user types "Steve Jobs" in Wikipedia search box
    And user click Wiki search box
    Then user sees "Steve Jobs" is in the Wikipedia title


  Scenario: Wikipedia Search Functionality Header Verification
    Given user is on the Wikipedia homepage
    When user types "Steve Jobs" in Wikipedia search box
    And user click Wiki search box
    Then user sees "Steve Jobs" is in the main header


  Scenario: Wikipedia Search Functionality Image Header Verification
    Given user is on the Wikipedia homepage
    When user types "Steve Jobs" in Wikipedia search box
    And user click Wiki search box
    Then user sees "Steve Jobs" is in the image header

  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality with Scenario Outline
    Given user is on the Wikipedia homepage
    When user types "<searchValue>" in Wikipedia search box
    And user click Wiki search box
    Then user sees "<expectedTitle>" is in the Wikipedia title
    Then user sees "<expectedMainHeader>" is in the main header
    Then user sees "<expectedImageHeader>" is in the image header

    @ceos
    Examples: search values we are going to be using in this scenario outlines
      | searchValue   | expectedTitle | expectedMainHeader | expectedImageHeader |
      | Steve Jobs    | Steve Jobs    | Steve Jobs         | Steve Jobs          |
      | Donald Trump  | Donald Trump  | Donald Trump       | Donald Trump        |
      | Keanu Reeves  | Keanu Reeves  | Keanu Reeves       | Keanu Reeves        |
      | Sundar Pichai | Sundar Pichai | Sundar Pichai      | Sundar Pichai       |

    @scientists
    Examples:
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader |
      | Marie Curie     | Marie Curie     | Marie Curie        | Marie Curie         |
      | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein     |

