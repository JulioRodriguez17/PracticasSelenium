import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationTest {

    private static int counter1 = 0;
    private static int counter2 = 0;
    private WebDriver driver;

    @BeforeEach
    public void setup(){
        counter1++;
        System.out.println("Ejecutando antes de cada test: "+counter1);
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown(){
        counter2++;
        System.out.println("Ejecutando despues de cada test: "+counter2);

        if(driver != null){
            driver.quit();
        }
    }


    @Test
    public void navigationToGoogle() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(3000);
    }

    @Test
    public void fillOutRegistrationForm() throws InterruptedException {
        //driver.get("file:///Users/julrodr117/Java/mini-web-apps/registration/register.html");
        driver.get("file:\\D:\\Badak\\Curso Selenium\\mini-web-apps\\registration\\register.html");
        Thread.sleep(3000);

        String name = "Julio";
        String lastName = "Rodr";
        String age = "24";
        String country = "Mexico";
        String email = "johndue@gmail.com";

        WebElement fieldname = driver.findElement(By.cssSelector("#name"));
        fieldname.sendKeys(name);

        WebElement fieldLastName = driver.findElement(By.cssSelector("#last-name"));
        fieldLastName.sendKeys(lastName);

        WebElement fieldAge = driver.findElement(By.cssSelector("#age"));
        fieldAge.sendKeys(age);

        Select selectCountry = new Select(driver.findElement(By.cssSelector("#country")));
        selectCountry.selectByVisibleText(country);

        WebElement fieldSex = driver.findElement(By.cssSelector("#sex-m"));
        fieldSex.click();

        WebElement fieldEmail = driver.findElement(By.cssSelector("#email"));
        fieldEmail.sendKeys(email);

        WebElement checkMonday = driver.findElement(By.cssSelector("#monday"));
        checkMonday.click();

        WebElement checkFriday = driver.findElement(By.cssSelector("#friday"));
        checkFriday.click();

        File profileImage = new File("src/test/resources/Caifanes.jpg");
        driver.findElement(By.cssSelector("#picture")).sendKeys(profileImage.getAbsolutePath());

        WebElement saveButton = driver.findElement(By.cssSelector("#save-btn"));
        Thread.sleep(3000);
        saveButton.click();

        Thread.sleep(3000);

        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        String currentName = driver
                .findElement(By.cssSelector("#summary-details > p:nth-child(1)")).getText();

        String currentlastName = driver
                .findElement(By.cssSelector("#summary-details > p:nth-child(2)")).getText();

        String currentAge = driver
                .findElement(By.cssSelector("#summary-details > p:nth-child(3)")).getText();

        String currentCountry = driver
                .findElement(By.cssSelector("#summary-details > p:nth-child(4)")).getText();

        String currentEmail = driver
                .findElement(By.cssSelector("#summary-details > p:nth-child(6)")).getText();

        assertThat(currentEmail).contains(email);
        assertThat(currentCountry).contains(country);

        Thread.sleep(3000);

    }

    @Test
    public void assertJTest() {
        List<String> tools = List.of("Selenium", "Playwright", "RestAssured");
    }

    @Test
    public void closeBrowserTest(){
        //driver.get("file:///Users/julrodr117/Java/mini-web-apps/registration/register.html");
        driver.get("file:\\D:\\Badak\\Curso Selenium\\mini-web-apps\\registration\\register.html");

        String name = "Julio";

        WebElement fieldname = driver.findElement(By.cssSelector("#foo"));
        fieldname.sendKeys(name);
    }




}



