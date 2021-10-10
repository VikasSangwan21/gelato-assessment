Feature: To do list

  Background:
    Given I am on To Do Home Page

  @ToDo @TC_001
  Scenario: The User should be able to add tasks to the To Do list
    When I enter "Task 1" to ToDo list
    Then I should see "Task 1" is added to ToDo list
    When I enter "Task 2" to ToDo list
    Then I should see "Task 2" is added to ToDo list
    Then I should see total 2 items added to ToDo List
    And I should see 2 items left is displayed in the list footer
    
  @ToDo @TC_002
  Scenario: The User should be able to complete a task
    When I enter "Task 1" to ToDo list
    Then I should see "Task 1" is added to ToDo list
    When I complete the first task
    Then I should see the first task is marked as completed
    
  @ToDo @TC_003
  Scenario: The User should be able to delete a task
    When I enter "Task 1" to ToDo list
    Then I should see "Task 1" is added to ToDo list
    When I delete the task
    Then I should see the task is deleted from the list
    
  @ToDo @TC_004
  Scenario: The User should be able filter the task according to status
    When I enter "Task 1" to ToDo list
    Then I should see "Task 1" is added to ToDo list
    When I enter "Task 2" to ToDo list
    Then I should see "Task 2" is added to ToDo list
    When I enter "Task 3" to ToDo list
    Then I should see "Task 3" is added to ToDo list
    When I enter "Task 4" to ToDo list
    Then I should see "Task 4" is added to ToDo list
    Then I should see total 4 items in the ToDo List
    When I complete the first task
    And I click on "Active" filter
    Then I should not see "Task 1" in the to do list
    And I should see total 3 items in the ToDo List
    When I click on "Completed" filter
    Then I should not see "Task 2" in the to do list
    And I should not see "Task 3" in the to do list
    And I should not see "Task 4" in the to do list
    And I should see total 1 items in the ToDo List
    When I click on "All" filter
    Then I should see total 4 items in the ToDo List
    
  @ToDo @TC_005
  Scenario: The User should be able to clear completed tasks from the list
    When I enter "Task 1" to ToDo list
    Then I should see "Task 1" is added to ToDo list
    When I enter "Task 2" to ToDo list
    Then I should see "Task 2" is added to ToDo list
    When I enter "Task 3" to ToDo list
    Then I should see "Task 3" is added to ToDo list
    Then I should see total 3 items in the ToDo List
    When I complete the first task
    And I click on Clear completed link
    Then I should see total 2 items in the ToDo List
    
  @ToDo @TC_006
  Scenario: The User should be able to edit a task
    When I enter "Task 1" to ToDo list
    Then I should see "Task 1" is added to ToDo list
    When I edit the task to "Updated Task 1"
    Then I should see "Updated Task 1" is displayed in ToDo list
    
    
	@ToDo @TC_007
  Scenario: The User should be able to see all the required labels on home page
    Then I should see todos heading on the top of the page
    And I should see a textbox with "What needs to be done?" placeholder
    And I should see instructions "Double-click to edit a todo" in footer
    And I should see info "Created by petehunt" in footer
    And I should see info "Part of TodoMVC" in footer
    
    
    
    
    
