package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

    // Localizadores de elementos en la página de inicio
    @FindBy(id = "mainSearchbar")
    WebElement searchBox;

    @FindBy(xpath = "//button[i[@class='icon-zoom']]")
    WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Categorías')]")
    WebElement displayMenu;
    @FindBy(linkText = "Belleza")
    WebElement beautyCategory;

    @FindBy(xpath = "//a[contains(text(),'Perfumes Hombre')]")
    WebElement mensPerfumes;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Método para buscar un producto
    public void searchProduct (String product){
        enterText(searchBox, product);
        clickElement(searchButton);
    }




    // Método para expandir el menú de categorías
    public void expandCategoryMenu () {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickElement(displayMenu);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.moveToElement(beautyCategory).perform();
    }

    // Método para seleccionar "Perfumes de Hombre"
    public void selectMensPerfumes () {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(mensPerfumes));
        clickElement(mensPerfumes);
    }
}