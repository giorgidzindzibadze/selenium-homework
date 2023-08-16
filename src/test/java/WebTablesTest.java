import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void WebTablesTestAutomation(){
        driver.get("http://techcanvass.com/Examples/webtable.html");
        driver.manage().window().maximize();

        WebElement rsa = driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr[2]/td[3]"));
        System.out.println(rsa.getText());


    }

    @AfterMethod
    public void after() {
        driver.quit();
    }

}
