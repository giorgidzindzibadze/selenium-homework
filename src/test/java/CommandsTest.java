import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class CommandsTest {
    WebDriver driver;

    public CommandsTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    @Test
    public void testDynamicControls() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        element.click();
        Boolean entext = wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        WebElement enabledText = driver.findElement(By.id("message"));
        WebElement inputField = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/input"));
        if (inputField.isEnabled() && enabledText.getText().equals("It's enabled!")) {
            WebElement disableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
            if (disableButton.isDisplayed()) {
                inputField.sendKeys("Bootcamp");
                inputField.clear();
            }
        } else {
            System.out.println("Try something else");
        }


        driver.navigate().to(" http://the-internet.herokuapp.com/drag_and_drop");
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        int columnAY = columnA.getLocation().getY();
        int columnBY = columnB.getLocation().getY();

        if (columnAY == columnBY) {
            System.out.println("Y coordinates of Column A and Column B are the same.");
        } else {
            System.out.println("Y coordinates of Column A and Column B are different.");
        }

    }

}