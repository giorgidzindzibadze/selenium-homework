import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebFormsTest {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void WebFormsAutomation(){
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");
        driver.manage().window().maximize();

        Select languageDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-1\"]")));
        languageDropdown.selectByVisibleText("SQL");

        WebElement selectedLanguage = languageDropdown.getFirstSelectedOption();
        if (selectedLanguage.getText().equals("SQL")) {
            System.out.println("Selected language is: " + selectedLanguage.getText());
        } else {
            System.out.println("Selected language is not SQL.");
        }

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']:not(:checked)"));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }

        WebElement yellowRadio = driver.findElement(By.cssSelector("input[value='yellow']"));
        yellowRadio.click();

        WebElement orangeOption = driver.findElement(By.cssSelector("option[value='orange']"));
        if (!orangeOption.isEnabled()) {
            System.out.println("Orange option is disabled.");
        } else {
            System.out.println("Orange option is enabled.");
        }

    }

    @AfterMethod
    public void after(){
        driver.quit();
    }

}
