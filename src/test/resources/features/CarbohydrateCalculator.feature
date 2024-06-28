@CarbohydrateCalculator
Feature: Carbohydrate Calculator
  This feature allows users to calculate their daily carbohydrate intake based on various inputs such as age, sex,
  height, weight, and activity level. The calculator should provide accurate results for valid inputs and display
  appropriate error messages for invalid inputs.

  @PositiveTest
  Scenario Outline: Calculate daily carbohydrate intake with different inputs
    Given I open the Carbohydrate Calculator page
    When I enter age <age>
    And I select sex "<sex>"
    And I enter height <height>
    And I enter weight <weight>
    And I select activity level <activity>
    And I click on the Calculate button
    Then I should see the carbohydrate intake result

    Examples:
      | age | sex    | height | weight | activity |
      | 25  | male   | 175    | 70     | 2        |
      | 30  | female | 160    | 60     | 4        |
      | 40  | male   | 180    | 80     | 1        |

  @NegativeTest
  Scenario Outline: Attempt to calculate daily carbohydrate intake with invalid inputs
    Given I open the Carbohydrate Calculator page
    When I enter age <age>
    And I select sex "<sex>"
    And I enter height <height>
    And I enter weight <weight>
    And I select activity level <activity>
    And I click on the Calculate button
    Then I should see an error message "<errorMessage>"

    Examples:
      | age | sex    | height | weight | activity | errorMessage                             |
      | 0   | male   | 175    | 70     | 2        | Please provide an age between 18 and 80. |
      | 25  | male   | -175   | 70     | 2        | Please provide positive height value.    |
      | 25  | female | 175    | -70    | 2        | Please provide positive weight value.    |