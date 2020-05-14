@exampleFeature
Feature: Example

  @loadpage
  Scenario: Open DuckDuckGo
    Given the site "DuckDuckGo" is open
    Then the searchbar is enabled

  @search
  Scenario: Search with DuckDuckGo
    Given the site "DuckDuckGo" is open
    When I search for "duck"
    Then I can see the search results for "duck"