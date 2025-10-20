import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest {

    @Test
    public void navigationToGoogle() throws InterruptedException {
        WebDriver driverUpdated = new ChromeDriver();

        driverUpdated.get("https://google.com");

        Thread.sleep(3000);
        driverUpdated.quit();
    }


}



