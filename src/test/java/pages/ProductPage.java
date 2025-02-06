package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Página de producto, hereda de pages.BasePage
public class ProductPage extends BasePage {

    @FindBy(css = "h1.a-product__information--title")
    WebElement productTitle;

    @FindBy(xpath = "//p[@class='a-product__paragraphDiscountPrice m-0 d-inline']")
    WebElement productPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Obtiene el título del producto
    public String getProductTitle() {
        return getElementText(productTitle);
    }

    // Obtiene el precio del producto
    public String getProductPrice() {
        return getElementText(productPrice);
    }
}
