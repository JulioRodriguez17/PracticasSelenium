import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.login.LoginPage;
import pageobjects.transaction.AddTransactionModal;

import java.time.Duration;

public class AddTransictionTests {

    private WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void addTransactionTest() throws InterruptedException {
        driver.get("file:\\D:\\Badak\\Curso Selenium\\mini-web-apps\\login\\login.html");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user","pass");

        AddTransactionModal addTransactionModal = new AddTransactionModal(driver);
        addTransactionModal.addTransaction("12/10/2025","400","Description test");

        Thread.sleep(3000);
    }

    @Test
    public void addTransactionWithLongDescriptionTest() throws InterruptedException {
        driver.get("file:\\D:\\Badak\\Curso Selenium\\mini-web-apps\\login\\login.html");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user","pass");

        AddTransactionModal addTransactionModal = new AddTransactionModal(driver);
        addTransactionModal.addTransaction("12/10/2025","400","Description test assfsafsaf dgdsaf tetareeadfdasdgadsgfag hdsdsg sdrsasf");

        Thread.sleep(3000);
    }

    @Test
    public void addTransactionWithBigAmountTest() throws InterruptedException {
        driver.get("file:\\D:\\Badak\\Curso Selenium\\mini-web-apps\\login\\login.html");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user","pass");

        AddTransactionModal addTransactionModal = new AddTransactionModal(driver);
        addTransactionModal.addTransaction("12/10/2025","4000000","Description test");

        Thread.sleep(3000);
    }
}
