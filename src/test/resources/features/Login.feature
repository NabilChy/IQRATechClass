Feature: login functionality
  Scenario: validate login functionality with valid username and valid password
    Given navigate to the application
    When I enter valid username and valid password
    |username|password|
    |FirstTry|Y2vKQgDzdcSSqi3|
    And I click on login button

  Scenario Outline: validate login functionality with different <username> and  <password>
    Given navigate to the application
    When I enter valid "<username>" and valid "<password>" from testData table
    And I click on login button
    Then I am able to verify the homepage with "<username>"
    Examples:
      |username|password|
      |FirstTry|Y2vKQgDzdcSSqi3|
      |user123|user123@gmail.com|

#  Scenario: validate login functionality with valid username and invalid password
#    Given navigate to the application
#    When I enter valid username and invalid password
#    And I click on login button
#    Then I am unable to verify the homepage
#
#  Scenario: validate login functionality with invalid username and valid password
#    Given navigate to the application
#    When I enter invalid username and valid password
#    And I click on login button
#    Then I am unable to verify the homepage
#
#  Scenario: validate login functionality with invalid username and invalid password
#    Given navigate to the application
#    When I enter invalid username and invalid password
#    And I click on login button
#    Then I am unable to verify the homepage