package stepDef;

import org.openqa.selenium.WebElement;

import base.GlobalTestData;
import base.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.ToDo_HomePage;

public class ToDo_Steps extends Setup {
	 ToDo_HomePage HOME; 

	@Given("I am on To Do Home Page")
	public void i_am_on_to_do_home_page() throws InterruptedException {	
		driver = initDriver(); 
        driver.get(GlobalTestData.url);
        HOME = new ToDo_HomePage(driver);
		HOME.validatePageTitle("React • TodoMVC");
	}
	
	@When("I enter {string} to ToDo list")
	public void i_enter_to_to_do_list(String task) {
		HOME.enterItemToList(task);
	}
	
	@Then("I should see {string} is added/displayed to/in ToDo list")
	public void i_should_see_is_added_to_to_do_list(String task) {
		HOME.validateTaskAddedToList(task);
	}
	
	@Then("I should see total {int} items added/in to/the ToDo List")
	public void i_should_see_total_items_added_to_to_do_list(Integer numberOfTask) {
		HOME.validateNoOfTasksInToDoList(numberOfTask);
	}
	
	@Then("I should see {int} items left is displayed in the list footer")
	public void i_should_see_items_left_is_displayed_in_the_list_footer(Integer numberOfTask) {
		HOME.validateListFooterforRemainingTasks(numberOfTask);
	}
	
	@When("I complete the first task")
	public void i_complete_the_first_task() {
		HOME.completeTask();
	}
	
	@Then("I should see the first task is marked as completed")
	public void i_should_see_the_first_task_is_marked_as_completed() {
		HOME.validateTaskIsMarkedCompleted();
	}
	
	@When("I delete the task")
	public void i_delete_the_task() {
		HOME.deleteTask();
	}
	
	@Then("I should see the task is deleted from the list")
	public void i_should_see_the_task_is_deleted_from_the_list() {
		HOME.validateTaskIsDeleted();
	}

	@When("I click on {string} filter")
	public void i_click_on_filter(String status) {
		HOME.filterTaskUsingStatus(status);
	}
	
	@When("I click on Clear completed link")
	public void i_click_on_clear_completed_link() {
		HOME.clearCompletedTask();
	}
	
	@When("I edit the task to {string}")
	public void i_edit_the_task(String upadatedTask) {
		HOME.editTask(upadatedTask);
	}
	
	@Then("I should see todos heading on the top of the page")
	public void i_should_see_todos_heading_on_the_top_of_the_page() {
		HOME.validateToDosHeading();
	}
	
	@Then("I should see a textbox with {string} placeholder")
	public void i_should_see_a_textbox_with_placeholder(String placeholder) {
		HOME.validateTextboxPlaceholder(placeholder);
	}
	
	@Then("I should see instructions/info {string} in footer")
	public void i_should_see_instructions(String info) {
		HOME.validatePageFooter(info);
	}
	
	@Then("I should not see {string} in the to do list")
	public void i_should_not_see_in_the_to_do_list(String task) {
		HOME.validateTaskNotDisplayedInToDoList(task);
	}
	
	@When("I click on toggle all button")
	public void i_click_on_toggle_all_button() {
		HOME.toggleAll();
	}
	@Then("I should see the status of all tasks changes to {string}")
	public void i_should_see_the_status_of_all_tasks_changes_to(String status) {
		HOME.validateAllTaskStatus(status);
	}
	
}
	
