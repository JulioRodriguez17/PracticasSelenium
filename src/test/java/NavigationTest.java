import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        fieldname.sendKeys("Julio");

        WebElement fieldLastName = driver.findElement(By.cssSelector("#last-name"));
        fieldLastName.sendKeys("Rodr");

        WebElement fieldAge = driver.findElement(By.cssSelector("#age"));
        fieldAge.sendKeys("24");

        Select selectCountry = new Select(driver.findElement(By.cssSelector("#country")));
        selectCountry.selectByVisibleText("Mexico");

        Thread.sleep(3000);
        driver.quit();
    }

}



