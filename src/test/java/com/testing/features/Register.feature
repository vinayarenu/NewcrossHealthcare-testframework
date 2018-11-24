Feature: Registration

  As an end user
  I want to register
  So that I can apply for a role in Newcross Healthcare

  Background:
    Given User is on the home page

#happy path scenario
  @register @smoke
  Scenario Outline:Verify user should be able to register successfully with valid data
    When user enters email as "<Email>"
    And enters password as "<Password>"
    And enters password confirmation as "<Password confirmation>"
    And selects all checkboxes
    And selects register
    #Then user should navigate to personal details page
    When enters all personal details "<Title>"and"<FirstName>"and"<LastName>"and"<mobile no>"
    And enters postcode "<postcode>"
    And selects Lookup address"<Lookup Address>"
    And selects next button
    #Then user should navigate to Qualifications & Training page
    When selects Add Qualification
    And fills the qualification form details "<Date completed>"and"<At this time I completed>"and"<Care Related Qualifications>"
    And selects add button
    And clicks next button
    #Then user should navigate to history page
    Examples:
      | Email                     | Password | Password confirmation | Title | FirstName | LastName | mobile no     | postcode | Lookup Address | Date completed | At this time I completed | Care Related Qualifications |
      | johnPeter012018@gmail.com | john123  | john123               | Mr    | john      | peter    | +447455566666 | ig11xg   | 19a Green Lane | 2018-02        | Qualification            | NVQ/SVQ Level 1             |

#unhappy path scenario
  @register1 @smoke
  Scenario Outline: Verify user should not be able to register successfully with invalid password
    When user enters email as "<Email>"
    And enters password as "<Password>"
    And enters password confirmation as "<Password confirmation>"
    Then user should see error message"<message>"
    Examples:
      | Email                | Password | Password confirmation | message                            |
      | john022018@gmail.com | john     | john                  | Password is less than 7 characters |

 #unhappy path scenario
  @register2 @smoke
  Scenario Outline: Verify user should not be able to register successfully with no mobile number
    When user enters email as "<Email>"
    And enters password as "<Password>"
    And enters password confirmation as "<Password confirmation>"
    And selects all checkboxes
    And selects register
    #Then user should navigate to personal details page
    When enters all personal details "<Title>"and"<FirstName>"and"<LastName>"and"<mobile no>"
    And enters postcode "<postcode>"
    And selects Lookup address"<Lookup Address>"
    And selects next button
    Then user should see mobile error message in personal details"<message>"
    Examples:
      | Email                     | Password | Password confirmation | Title | FirstName | LastName | mobile no | postcode | Lookup Address | message                                 |
      | johnPeter032018@gmail.com | john123  | john123               | Mr    | john      | peter    |           | ig11xg   | 19a Green Lane | This is not a valid mobile phone number |

    #unhappy path scenario
  @register3 @smoke
  Scenario Outline: Verify user should not be able to register successfully with no firstname
    When user enters email as "<Email>"
    And enters password as "<Password>"
    And enters password confirmation as "<Password confirmation>"
    And selects all checkboxes
    And selects register
    #Then user should navigate to personal details page
    When enters all personal details "<Title>"and"<FirstName>"and"<LastName>"and"<mobile no>"
    And enters postcode "<postcode>"
    And selects Lookup address"<Lookup Address>"
    And selects next button
    Then user should see firstname error message in personal details"<message>"
    Examples:
      | Email                     | Password | Password confirmation | Title | FirstName | LastName | mobile no     | postcode | Lookup Address | message                |
      | johnPeter062018@gmail.com | john123  | john123               | Mr    |           | peter    | +447455566666 | ig11xg   | 19a Green Lane | This field is required |

     #unhappy path scenario
  @register4 @smoke
  Scenario Outline: Verify user should not be able to register successfully with no lastname
    When user enters email as "<Email>"
    And enters password as "<Password>"
    And enters password confirmation as "<Password confirmation>"
    And selects all checkboxes
    And selects register
    #Then user should navigate to personal details page
    When enters all personal details "<Title>"and"<FirstName>"and"<LastName>"and"<mobile no>"
    And enters postcode "<postcode>"
    And selects Lookup address"<Lookup Address>"
    And selects next button
    Then user should see lastname error message in personal details"<message>"
    Examples:
      | Email                     | Password | Password confirmation | Title | FirstName | LastName | mobile no     | postcode | Lookup Address | message                |
      | johnPeter082018@gmail.com | john123  | john123               | Mr    | john      |          | +447455566666 | ig11xg   | 19a Green Lane | This field is required |
