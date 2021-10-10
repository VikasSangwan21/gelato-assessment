package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.util.Strings;

import base.GlobalTestData;
import base.Setup;

public class ToDo_HomePage extends Setup {

    public ToDo_HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    
    Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(100))
            .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
    // Elements
    @FindBy(how = How.CSS, using = "input.new-todo")
    public WebElement NEW_TO_DO;
    @FindBy(how = How.CSS, using = "ul.todo-list>li:last-of-type>div>label")
    public WebElement LAST_ADDED_TASK;
    @FindBy(how = How.CSS, using = "ul.todo-list>li")
    public List<WebElement> LIST_ITEMS;
    @FindBy(how = How.CSS, using = "footer>span.todo-count")
    public WebElement FOOTER_TO_DO_COUNT;
    @FindBy(how = How.CSS, using = "ul.todo-list>li:first-of-type>div>input")
    public WebElement FIRST_TASK_COMPLETED_CHECKBOX;
    @FindBy(how = How.CSS, using = "ul.todo-list>li:first-of-type")
    public WebElement FIRST_TASK;
    @FindBy(how = How.CSS, using = "button.destroy")
    public WebElement DELETE_TASK;
    @FindBy(how = How.XPATH, using = "//a[.='All']")
    public WebElement FILTER_ALL;
    @FindBy(how = How.XPATH, using = "//a[.='Active']")
    public WebElement FILTER_ACTIVE;
    @FindBy(how = How.XPATH, using = "//a[.='Completed']")
    public WebElement FILTER_COMPLETED;
    @FindBy(how = How.CSS, using = "button.clear-completed")
    public WebElement CLEAR_COMPLETED;
    @FindBy(how = How.CSS, using = "footer.info p")
    public List<WebElement> FOOTER_INFO;
    @FindBy(how = How.CSS, using = "h1")
    public WebElement HEADING;
    @FindBy(how = How.CSS, using = "[for='toggle-all']")
    public WebElement TOGGLE_ALL;
	
	
    public void validatePageTitle(String title){
    	Assert.assertEquals(driver.getTitle(), title);
    }
    
    public void enterItemToList(String task) {
    	try {
        	NEW_TO_DO.sendKeys(task+Keys.RETURN);
    	}catch(Exception e) {
            Assert.fail("Cannot find New To Do textbox");
    	}
    }
    
    public void validateTaskAddedToList(String task) {
    	try {
    		Assert.assertEquals(LAST_ADDED_TASK.getText(), task);
    	}catch(Exception e) {
            Assert.fail("Cannot find New Task");
    	}
    }
    
    public void validateNoOfTasksInToDoList(int numberOfTask) {
    	try {
    		Assert.assertEquals(LIST_ITEMS.size(), numberOfTask);
    	}catch(Exception e) {
            Assert.fail("Cannot find Task List");
    	}
    }
    
    public void validateListFooterforRemainingTasks(int numberOfTask) {
    	try {
    		Assert.assertTrue(FOOTER_TO_DO_COUNT.getText().contains(Integer.toString(numberOfTask)));
    		Assert.assertTrue(FOOTER_TO_DO_COUNT.getText().contains("items"));
    		Assert.assertTrue(FOOTER_TO_DO_COUNT.getText().contains("left"));
    	}catch(Exception e) {
            Assert.fail("Cannot find footer");
    	}
    }
    
    public void completeTask() {
    	try {
    		FIRST_TASK_COMPLETED_CHECKBOX.click();
    	}catch(Exception e) {
            Assert.fail("Cannot find first task");
    	}
    }
    
    public void validateTaskIsMarkedCompleted() {
    	try {
    		Assert.assertEquals(FIRST_TASK.getAttribute("class"), "completed");
    	}catch(Exception e) {
            Assert.fail("Cannot find first task");
    	}
    }
    
    public void deleteTask() {
    	try {
    		Actions actions = new Actions(driver);
    		actions.moveToElement(FIRST_TASK);
    		actions.moveToElement(DELETE_TASK);
    		actions.click().build().perform();
    	}catch(Exception e) {
            Assert.fail("Cannot find Delete task");
    	}
    }
    
    public void validateTaskIsDeleted() {
    	try {
    		Assert.assertEquals(LIST_ITEMS.size(), 0);
    	}catch(Exception e) {
    		Assert.fail(e.getMessage()	);
    	}
    }
    
    public void filterTaskUsingStatus(String Status) {
    	try {
    		switch(Status) {
    		case "All":
    			FILTER_ALL.click();
    			break;
    		case "Completed":
    			FILTER_COMPLETED.click();
    			break;
    		case "Active":
    			FILTER_ACTIVE.click();
    			break;
    		default:
    			break;
    		}
    		
    	}catch(Exception e) {
            Assert.fail("Unable to filter tasks");
    	}
    }
    
    public void clearCompletedTask() {
    	try {
    		CLEAR_COMPLETED.click();
    	}catch(Exception e) {
            Assert.fail("Cannot find Clear Completed");
    	}
    }
    
    public void editTask(String updatedTask) {
    	try {
    		Actions actions = new Actions(driver);
    		actions.doubleClick(FIRST_TASK).perform();
    		actions.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
    		actions.keyUp(Keys.CONTROL).perform();
    		actions.sendKeys(Keys.DELETE+updatedTask+Keys.RETURN).perform();
    	}catch(Exception e) {
            Assert.fail("Cannot find Clear Completed");
    	}
    }
    
    public void validateToDosHeading() {
    	try {
    		Assert.assertEquals(HEADING.getText(), "todos");
    	}catch(Exception e) {
            Assert.fail("Page heading not displayed");
    	}
    }
    
    public void validateTextboxPlaceholder(String placeholder) {
    	try {
    		Assert.assertTrue(NEW_TO_DO.isDisplayed());
    		Assert.assertEquals(NEW_TO_DO.getAttribute("placeholder"), placeholder);
    	}catch(Exception e) {
            Assert.fail("Textbox not displayed");
    	}
    }
    
    public void validateTaskNotDisplayedInToDoList(String task) {
    	try {
    		boolean flag = false;
    		for(WebElement ele : LIST_ITEMS) {
    			if(ele.getText().equals(task)) {
    				flag = true;
    			}
    		}
    		Assert.assertFalse(flag);
    	}catch(Exception e) {
            Assert.fail("Textbox not displayed");
    	}
    }
    
    public void validatePageFooter(String info) {
    	try {
    		boolean flag = false;
    		for(WebElement ele : FOOTER_INFO) {
    			if(ele.getText().replace("\n", "").equals(info)) {
    				flag = true;
    			}
    		}
    		Assert.assertTrue(flag);
    	}catch(Exception e) {
            Assert.fail("Page footer not displayed");
    	}
    }
    
    public void toggleAll() {
    	try {
    		TOGGLE_ALL.click();
    	}catch(Exception e) {
            Assert.fail("Toggle All button not found");
    	}
    }
    
    public void validateAllTaskStatus(String status) {
    	try {    
    		switch(status) {
    		case "completed":
    			for(WebElement el : LIST_ITEMS) {
    				Assert.assertEquals(el.getAttribute("class"), "completed");
    			}
    			break;
    		case "to do":
    			for(WebElement el : LIST_ITEMS) {
    				Assert.assertNotEquals(el.getAttribute("class"), "completed");
    			}
    			break;
    		}
    	}catch(Exception e) {
            Assert.fail("Toggle All button not found");
    	}
    }

}

