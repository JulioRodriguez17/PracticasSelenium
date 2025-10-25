package pageobjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

        private By usernameInput = By.id("username");
        private By passwordInput = By.id("password");
        private By submitButton = By.xpath("//button[text()='Iniciar sesión']");
        private WebDriver driver;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        public void login(String username, String password) {
            this.driver.findElement(usernameInput).sendKeys(username);
            this.driver.findElement(passwordInput).sendKeys(password);
            this.driver.findElement(submitButton).click();
        }
}
