import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class JSexecutor {

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
    public void todo() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[3]"));
        Actions builder = new Actions(driver);
        builder.clickAndHold().moveToElement(element).perform();
        WebElement element2 =driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[3]/span/i"));
        element2.click();
        js.executeScript("arguments[0].remove()", element);
        // zustad ver gavige romeli gzit wameshala da orive gzit davwere
    }
    @Test
    public void scroll(){
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"zone2\"]"));
        builder.clickAndHold().moveToElement(element1).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element1 );
        builder.clickAndHold().moveToElement(element1).perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(element1.getText());
        String expectedText = "1 Entries";

        String actualText = (String) js.executeScript("return arguments[0].textContent;", element1);
        actualText=actualText.trim();
        System.out.println(actualText);

        if (actualText.equals(expectedText)) {
            System.out.println("Text validation successful!");
        } else {
            System.out.println("Text validation failed.");
        }

    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
