package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

// Página de resultados de búsqueda, hereda de HomePage
public class SearchResultPage extends SearchPage {

    @FindBy(xpath = "//span[@class='a-title-section-leftMenu']")
    WebElement searchResultsContainer;
    @FindBy(xpath = "//a[contains(text(),'Consolas')]")
    WebElement consolaButton;

    @FindBy(xpath = "//h3[contains(text(),'Consola')][1]")
    WebElement playstation5Item;

    @FindBy(xpath = "//h3[contains(text(), 'Smart TV')][1]")
    WebElement smartTvTitle;

    @FindBy(css = "p.a-plp-results-title span")
    WebElement productCount;

    @FindBy(xpath = "//label[contains(text(),'Descuentos')]")
    WebElement filterSize;

    @FindBy(xpath = "//label[contains(text(),'Precios')]")
    WebElement filterPrice;

    @FindBy(xpath = "//label[contains(text(),'Marcas')]")
    WebElement filterBrand;

    @FindBy(id = "Tamao")
    WebElement viewMoreSizeButton;
    @FindBy(id = "Marcas")
    WebElement viewMoreBrandsButton;
    @FindBy(xpath = "//label[contains(text(),'Mas de $')]")
    WebElement radioPriceFilter;
    @FindBy(xpath = "//label[contains(text(),'55 pulgadas')]" )
    WebElement selectInches;
    @FindBy(xpath = "//label[contains(text(),'SONY')]" )
    WebElement selectBrandSony;

    @FindBy(xpath = "//label[contains(text(),'DIOR')]" )
    WebElement selectBrandDior;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    // Verifica que los resultados contienen PlayStation
    public boolean verifyResultsContainPlayStation() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return searchResultsContainer.getText().contains("Playstation");
    }

    // Selecciona PlayStation 5 en los resultados
    public void selectPlayStation5() {
        clickElement(consolaButton);
        clickElement(playstation5Item);
    }

    // Verifica si el título "Smart TV" está presente
    public boolean isSmartTvTitleDisplayed() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return isElementDisplayed(smartTvTitle);
    }

    // Verifica si el filtro de tamaño está visible
    public boolean isSizeFilterDisplayed() {
        return isElementDisplayed(filterSize);
    }

    // Verifica si el filtro de precio está visible
    public boolean isPriceFilterDisplayed() {
        return isElementDisplayed(filterPrice);
    }

    // Verifica si el filtro de marca está visible
    public boolean isBrandFilterDisplayed() {
        return isElementDisplayed(filterBrand);
    }

    // Aplica los filtros de búsqueda
    public void applyFilters() {
        clickElement(viewMoreSizeButton);
        clickElement(viewMoreBrandsButton);
        clickElement(radioPriceFilter);
        clickElement(selectInches);
        clickElement(selectBrandSony);

    }
    public void applyFiltersPerfum() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(viewMoreBrandsButton));
        clickElement(viewMoreBrandsButton);

        wait.until(ExpectedConditions.visibilityOf(selectBrandDior));
        clickElement(selectBrandDior);

    }

    // Obtiene la cantidad de resultados
    public int getResultsCount() {
        return Integer.parseInt(getElementText(productCount));
    }
}