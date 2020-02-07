Feature: SecondTask

  Scenario: Buy Hummingbird Sweater

    Given User is logged in to shop
    When User choose item
    And check discount
    And User choose size and quantity
      | size | quantity |
      | S    | 7       |
    And User choose checkout option
    And User confirm delivery address
    And User choose payment method
    And User choose obligation to pay
    And System will do screenshot with order Confirmation
    Then Check orders history



