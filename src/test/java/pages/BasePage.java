package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    // Método para ingresar texto en un campo
    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    // Método para obtener el texto de un elemento
    public String getElementText(WebElement element) {
        return element.getText();
    }

    // Método para verificar si un elemento está visible
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}
