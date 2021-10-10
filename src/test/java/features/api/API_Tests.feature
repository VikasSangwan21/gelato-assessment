Feature: Test Json Placeholder API's
  
   Background:
    Given I set the base URI
  
  @API @JsonPlaceholder @TC_001
  Scenario: User is able to get a resource
    When I send the API request to get a resource
    Then I should get the response status as 200
    And I should get  "userId" as "1" in response body
    And I should get  "id" as "1" in response body
		And I should get  "title" as "sunt aut facere repellat provident occaecati excepturi optio reprehenderit" in response body
 		And I should get  "body" contains "quia et suscipit" in response body

 		
 	@API @JsonPlaceholder @TC_002
  Scenario: User is able to get all the resources
    When I send the API request to get all resources
    Then I should get the response status as 200
    And I should get 100 objects in response
    
  @API @JsonPlaceholder @TC_003
  Scenario: User is able to create a resource
    When I add "title, body" as "foo, bar" to request parameters
    When I add "userId" as 1 to request parameters
    And I send the API "post" request to create a resource
    Then I should get the response status as 201
    And I should get  "userId" as "1" in response body
    And I should get  "id" as "101" in response body
		And I should get  "title" as "foo" in response body
 		And I should get  "body" contains "bar" in response body
 		
  @API @JsonPlaceholder @TC_004
  Scenario: User is able to update a resource
    When I add "title, body" as "foo, bar" to request parameters
    When I add "userId" as 1 to request parameters
    When I add "id" as 1 to request parameters
    And I send the API "put" request to update a resource
    Then I should get the response status as 200
    And I should get  "userId" as "1" in response body
    And I should get  "id" as "1" in response body
		And I should get  "title" as "foo" in response body
 		And I should get  "body" contains "bar" in response body
 		
  @API @JsonPlaceholder @TC_005
  Scenario: User is able to patch a resource
    When I add "title" as "foo" to request parameters
    And I send the API "patch" request to patch a resource
    Then I should get the response status as 200
    And I should get  "userId" as "1" in response body
    And I should get  "id" as "1" in response body
		And I should get  "title" as "foo" in response body
 		
 	@API @JsonPlaceholder @TC_006
  Scenario: User is able to delete a resource
    When I send the API "delete" request to delete a resource
    Then I should get the response status as 200
 		
 		
 		
 		