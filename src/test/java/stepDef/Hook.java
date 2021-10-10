package stepDef;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends Setup {
    Logger logger = LoggerFactory.getLogger(Hook.class);

    @Before
    public void openBrowser() throws InterruptedException {
        logger.info("Test Started");
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed() & driver!=null) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
        	if(driver!=null) {
                driver.quit();
        	}
            logger.info("Test Ended");
        }
    }
}
