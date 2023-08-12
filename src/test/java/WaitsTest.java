import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitsTest {

    WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void waitTestAutomation(){
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement element=driver.findElement(By.xpath("//*[@id=\"startStopButton\"]"));
        element.click();

        new WebDriverWait(driver,14).until(ExpectedConditions.attributeToBe(By.xpath("//*[@id=\"progressBar\"]/div"),"aria-valuenow", "100"));
        System.out.println("progress bar reach 100%");

    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
