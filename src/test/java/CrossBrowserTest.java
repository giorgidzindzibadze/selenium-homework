import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class CrossBrowserTest {
    WebDriver driver;


    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) throws Exception {

        if (browser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\giorg\\Desktop\\chrome-win64");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new Exception("Try another browser");
        }

    }

    @Test
    public void todo() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/ul/li[3]")));
            Actions builder = new Actions(driver);
            builder.clickAndHold(element).moveToElement(element).perform();
        element.click();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[3]/span/i"));
        element2.click();

    }

    @AfterTest
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }

    }
}
