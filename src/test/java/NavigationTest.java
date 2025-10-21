import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest {

    @Test
    public void navigationToGoogle() throws InterruptedException {
        WebDriver driverUpdated = new ChromeDriver();

        driverUpdated.get("https://google.com");

        Thread.sleep(3000);
        driverUpdated.quit();
    }

    @Test
    public void fillOutRegistrationForm() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/julrodr117/Java/mini-web-apps/registration/register.html");
        Thread.sleep(3000);

        WebElement fieldname = driver.findElement(By.cssSelector("#name"));
        fieldname.sendKeys("Test");
        Thread.sleep(3000);

        driver.quit();
    }

}



