Feature: As a user I want to be able to use login page

  @test
  @smoke
    @id1
  Scenario: Login with valid credentials
    Given open the Login page
    When user enters "standard_user" to Username field
    And user enters "secret_sauce" to Password field
    And user clicks login button
    Then current url corresponds to "https://www.saucedemo.com/inventory.html"

  @positive
    @id2
  Scenario Outline: Login with all valid credentials
    Given open the Login page
    When user enters "<username>" to Username field
    And user enters "secret_sauce" to Password field
    And user clicks login button
    Then current url corresponds to "https://www.saucedemo.com/inventory.html"
    Examples:
      | username                |
      | standard_user           |
      | locked_out_user         |
      | problem_user            |
      | performance_glitch_user |

  @positive
  @id3
  Scenario: Check that all images are displayed
    Given open the Login page
    Then Logo is displayed
    And Title image is displayed

  @negative
  @id4
  Scenario: Login with incorrect credentials
    Given open the Login page
    When user enters "incorrect" to Username field
    And user enters "incorrect" to Password field
    And user clicks login button
    Then error message is displayed