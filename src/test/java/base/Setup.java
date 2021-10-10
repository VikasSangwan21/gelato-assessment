package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.util.Strings;

import java.util.concurrent.TimeUnit;

public class Setup {
    public static WebDriver driver;
    public static DesiredCapabilities caps = new DesiredCapabilities();

    public static WebDriver initDriver() throws InterruptedException {
    	String driverType = System.getProperty("browser");
    	if (Strings.isNullOrEmpty(driverType)) {
    		driverType = "ch";
        }
        if (driverType.equalsIgnoreCase("ch")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--test-type");
            options.addArguments("--disable-popup-bloacking");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-crash-reporter");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-in-process-stack-traces");
            options.addArguments("--disable-logging");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--log-level=3");
            options.addArguments("--output=/dev/null");
            System.setProperty("webdriver.chrome.silentOutput", "true");
            caps.setCapability(ChromeOptions.CAPABILITY, options);
            caps.setJavascriptEnabled(true); 
            driver = new ChromeDriver(options);
        } else if (driverType.equalsIgnoreCase("ff")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            caps.setCapability("moz:firefoxOptions", options);
            driver = new FirefoxDriver(options);
        } else if (driverType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.setCapability("InPrivate", true);
            driver = new EdgeDriver(options);
        } else if (driverType.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions options = new InternetExplorerOptions().setPageLoadStrategy(PageLoadStrategy.NONE);
            caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
            caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
            driver = new InternetExplorerDriver(options);
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(GlobalTestData.implicitWait, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("window.confirm = function(msg) { return true; }");
        Thread.sleep(1500);
        return driver;
    }

}
