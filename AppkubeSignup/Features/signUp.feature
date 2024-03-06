Feature: signUp

  Scenario: Successful sigUp with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://appkube.synectiks.net"
    When I fill in the sign-up form with valid information
    And I agree to the terms of service
    And I click the sign-up button
    Then I fill company name
    And I click the Next button
    And User navigate to login page
    And I fill in the login form with the signed-up username and password
    And I click the login button
    When User click to icon
    And I click to logout button

  Scenario: Unsuccessful sign with invalid Credentials
    Given User Lanuch Chrome browser
    When User opens URL1 "https://appkube.synectiks.net"
    When User fill in the sign-up form with invalid information
    And User click the sign-up button
    Then User see an error message in each input field 
    And User enter with valid information
    And User click on the sign-up button1
    When User fill invalid or duplicate company name
    And User Click on next buttons
    Then User get an error message displayed 
    And close browser
