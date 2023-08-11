import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;

public class WebElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver
        driver.quit();
    }


    @Test
    public void testAddRemoveElements() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();

        for (int i = 0; i < 3; i++) {
           driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();

        }
        WebElement lastDelete = driver.findElement(By.xpath("//*[@id=\"elements\"]/button[3]"));
        System.out.println(lastDelete.getText());

        java.util.List<WebElement> addedDeleteButtons = driver.findElements(By.cssSelector("button[class^='added']"));
        WebElement lastAddedDeleteButton = addedDeleteButtons.get(addedDeleteButtons.size() - 1);
        System.out.println("Last 'Delete' button using cssSelector: " + lastAddedDeleteButton.getText());

        WebElement lastManualDeleteButton = driver.findElement(By.xpath("(//button[contains(@class, 'manually') and contains(text(), 'Delete')])[last()]"));
        System.out.println("Last 'Delete' button element with findElement() using relative XPath: " + lastManualDeleteButton.getText());
        driver.navigate().to("http://the-internet.herokuapp.com/challenging_dom");

        WebElement LoremElement = driver.findElement(By.xpath("//td[text()='Apeirian9']/preceding-sibling::td[text()='Iuvaret9']"));
        System.out.println(LoremElement.getText());

        WebElement apeirian9Element = driver.findElement(By.xpath("//td[text()='Apeirian9']"));

        WebElement loremElement = apeirian9Element.findElement(By.xpath("following-sibling::td[1]"));
        String loremValue = loremElement.getText();
        System.out.println(loremValue);

    }

}