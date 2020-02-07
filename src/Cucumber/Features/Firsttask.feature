Feature: Add new address

  Scenario Outline: Fill up required information

    Given User is logged in to the shop
    When Logged user goes to address
    And User add "<alias>" and "<address>" and "<city>" and "<post code>" and "<country>" and "<phone>"
    And User saves all information
    And and can see, that this address "<alias>" and  "<address>" and "<city>" and "<post code>" and "<country>" and "<phone>" is correct
    Then Logged user deleted address and can see "Address successfully deleted!"

    Examples:
      | alias | address    | city   | post code | country        | phone      |
      | Inny1  | 33A Street | London | 32 300    | United Kingdom | 2256879436 |