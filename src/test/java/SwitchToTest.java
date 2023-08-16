import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchToTest {

    WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void switchToTestAutomation(){
        driver.get(" http://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();

        driver.switchTo().frame(0);


        WebElement element= driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        element.clear();
        element.sendKeys("Here Goes");
        driver.switchTo().defaultContent();
        WebElement alignCenterButton = driver.findElement(By.xpath("//button[contains(@title, 'Align center')]"));
        alignCenterButton.click();

        driver.navigate().to("https://demoqa.com/alerts");
        WebElement element1 =driver.findElement(By.xpath("//*[@id=\"alertButton\"]"));
        element1.click();
        driver.switchTo().alert().accept();






    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
