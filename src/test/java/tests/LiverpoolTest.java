package tests;

import org.testng.annotations.*;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiverpoolTest {
    WebDriver driver;
    SearchPage searchPage;
    SearchResultPage searchResultPage;
    ProductPage productPage;

    @BeforeMethod
    public void setUp() {
        // Configura el driver de Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.liverpool.com.mx");
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testSearchPlayStation() {
        searchPage.searchProduct("playstation");
        searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.verifyResultsContainPlayStation());
        searchResultPage.selectPlayStation5();
        productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getProductTitle(), "Consola PS5 de 1 TB edición bundle");
        Assert.assertNotNull(productPage.getProductPrice());
    }

    @Test
    public void testSearchSmartTv() {
        searchPage.searchProduct("smart tv");
        searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.isSmartTvTitleDisplayed());
        Assert.assertTrue(searchResultPage.isSizeFilterDisplayed());
        Assert.assertTrue(searchResultPage.isPriceFilterDisplayed());
        Assert.assertTrue(searchResultPage.isBrandFilterDisplayed());
        searchResultPage.applyFilters();
        Assert.assertTrue(searchResultPage.getResultsCount() > 0);
    }

    @Test
    public void testSelectMensPerfumes() {
        searchPage.expandCategoryMenu();
        searchPage.selectMensPerfumes();
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.applyFiltersPerfum();
        Assert.assertTrue(searchResultPage.getResultsCount() > 0);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
