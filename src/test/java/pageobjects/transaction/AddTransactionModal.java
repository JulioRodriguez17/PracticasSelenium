package pageobjects.transaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTransactionModal {

    private By addTransactionButton = By.xpath("//button[text()='Añadir transacción']");
    private By transactionDateInput = By.id("date");
    private By transactionAmountInput = By.id("amount");
    private By transactionDescriptionInput = By.id("description");
    private By addSubmitButton = By.xpath("//button[text()='Guardar']");

    private WebDriver driver;

    public AddTransactionModal(WebDriver driver) {
        this.driver = driver;
    }

    public void addTransaction(String date, String amount, String description){
            driver.findElement(addTransactionButton).click();

            driver.findElement(transactionDateInput).sendKeys(date);
            driver.findElement(transactionAmountInput).sendKeys(amount);
            driver.findElement(transactionDescriptionInput).sendKeys(description);

            driver.findElement(addSubmitButton).click();


    };
}
