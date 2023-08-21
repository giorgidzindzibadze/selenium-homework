import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AutoComplete {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void autoCompleteAutomation(){
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        element.sendKeys("Automation");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li[@role='presentation']"));

//       print all suggestions
        for (WebElement suggestion : suggestions) {
            System.out.println(suggestion.getText());
        }

        if (!suggestions.isEmpty()) {
            WebElement lastSuggestion = suggestions.get(suggestions.size() - 1);
            lastSuggestion.click();
        }

    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
