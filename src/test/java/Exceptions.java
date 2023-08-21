import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exceptions {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }
    @Test
    public void exceptionAutomation() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("timerAlertButton"));
        element.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            System.out.println("TimeoutException was not thrown.");
        } catch (TimeoutException e) {
            System.out.println("TimeoutException was thrown: " + e.getMessage());
        }

        try {
            driver.switchTo().alert().accept();
            System.out.println("NoAlertPresentException was not thrown.");
        } catch (Exception e) {
            System.out.println("NoAlertPresentException was thrown and handled: " + e.getMessage());
        }

        try {
            element.click();
            System.out.println("StaleElementReferenceException was not thrown.");
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException was thrown: " + e.getMessage());
        }
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
