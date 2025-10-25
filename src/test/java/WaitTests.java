import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void implicitWaitTest(){
        driver.get("file://D:\\Badak\\Curso Selenium\\esperas.html");

        WebElement loadMessageButton = driver.findElement(By.id("loadBtn"));
        loadMessageButton.click();

        WebElement successMessageAlert = driver.findElement(By.cssSelector("div.alert-success"));
        String successMessage = successMessageAlert.getText();

        System.out.println("Success Message is: " + successMessage);
    }

    @Test
    public void explicitWaitTest(){
        driver.get("file://D:\\Badak\\Curso Selenium\\esperas.html");

        WebElement loadMessageButton = driver.findElement(By.id("loadBtn"));
        loadMessageButton.click();

        WebElement successMessageAlert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-success"))
        );

        String successMessage = successMessageAlert.getText();
        System.out.println("Success Message is: " + successMessage);
    }

    @Test
    public void fluentWaitTest(){
        driver.get("file://D:\\Badak\\Curso Selenium\\esperas.html");

        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                                                             .pollingEvery(Duration.ofSeconds(1))
                                                             .ignoring(NoSuchElementException.class);

        WebElement loadMessageButton = driver.findElement(By.id("loadBtn"));
        loadMessageButton.click();

        WebElement successMessageAlert = fluentWait
                .until(dry -> dry.findElement(By.cssSelector("div.alert-success")));

        String successMessage = successMessageAlert.getText();
        System.out.println("Success Message is: " + successMessage);
    }
}
