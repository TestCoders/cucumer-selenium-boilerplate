@myStore
Feature: AutomationStore

  @verifyMenuOptions
  Scenario: Verify the options for menu
    Given the site "Automation practise store" is open
    When I open the "Women" menu
    Then I can see the menu items:
      | TOPS            |
      | T-shirts        |
      | Blouses         |
      | DRESSES         |
      | Casual Dresses  |
      | Evening Dresses |
      | Summer Dresses  |