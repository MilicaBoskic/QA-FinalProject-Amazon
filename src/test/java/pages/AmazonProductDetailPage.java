package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AmazonProductDetailPage extends BaseHelper {

    public String productName;
    public String productPrice;
    public String opticalPowerDetailPage;

    @FindBy (id = "nav-global-location-popover-link")
    WebElement location;
    @FindBy (id = "GLUXZipUpdateInput")
    WebElement enterLocation;
    @FindBy (id = "GLUXZipUpdate")
    WebElement confirmLocation;

    @FindBy (id = "native_dropdown_selected_optical_power")
    WebElement dropdownOpticalPower;
    @FindBy (id = "native_optical_power_5")
    WebElement opticalPower_5;

    @FindBy (id="unit_count_1")
    WebElement unitButton;
    @FindBy (id = "buyNew_cbb")
    WebElement compraUnicaButton;
    @FindBy (id = "quantity")
    WebElement quantity;
    @FindBy (id = "add-to-cart-button")
    WebElement addToCartButton;
    @FindBy (id = "productTitle")
    WebElement productTitle;
    @FindBy (id = "newBuyBoxPrice")
    WebElement productPriceDP;


    WebDriver driver;
    public AmazonProductDetailPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // FILTERS

    private void chooseOpticalPower() {
        wdWait.until(ExpectedConditions.visibilityOf(dropdownOpticalPower));
        Select selector = new Select(dropdownOpticalPower);
        selector.selectByVisibleText("-1.5 Dioptrías");
//        System.out.println("Optical power is: "+opticalPower_5.getText());
        opticalPowerDetailPage = opticalPower_5.getText();
    }

    private void chooseUnits() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("unit_count_1")));
        wdWait.until(ExpectedConditions.elementToBeClickable(unitButton));

        unitButton.click();
    }

    // LOCATION

    private void changeLocation() {
        wdWait.until(ExpectedConditions.visibilityOf(location));
        location.click();
    }

    private void enterNewLocation() {
        wdWait.until(ExpectedConditions.visibilityOf(enterLocation));
        enterLocation.sendKeys("28010");
    }
    private void confirmNewLocation() {
        confirmLocation.click();
    }

    private void clickOnCompraUnicaButton() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("buyNew_cbb")));
//        wdWait.until(ExpectedConditions.elementToBeClickable(compraUnicaButton));
        js.executeScript("arguments[0].click();",compraUnicaButton);
    }

//    private void changeQuantity() {
//        wdWait.until(ExpectedConditions.visibilityOf(quantity));
//        Select selector = new Select(quantity);
//        selector.selectByValue("2");
//    }

    private void printProductTitle() {
        wdWait.until(ExpectedConditions.visibilityOf(productTitle));
        System.out.println("Product title on PDP is: "+productTitle.getText());
        productName = productTitle.getText();
    }

    private void printProductPriceDP() {
        wdWait.until(ExpectedConditions.visibilityOf(productPriceDP));
        System.out.println("Product title on PDP is: "+productPriceDP.getText());
        productPrice = productPriceDP.getText();
    }

    private void addToCart() {
        addToCartButton.click();
    }

    public void changeAttributes() {
        chooseOpticalPower();
        chooseUnits();
        changeLocation();
        enterNewLocation();
        confirmNewLocation();
        clickOnCompraUnicaButton();
//        changeQuantity();
        printProductTitle();
        printProductPriceDP();
        addToCart();
    }
}