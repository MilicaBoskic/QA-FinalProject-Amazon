package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonCestaPage extends BaseHelper {

    public String quantityOne;
    public String quantityTwo;

    public String productTitleCart;
    public String productPrice;
    public String quantityTwoTramitarPedido;
    public String opticalPowerCart;

    public String oneUnitPrice;
    public String twoUnitsPrice;

    @FindBy (className = "sc-product-price")
    WebElement pricePerOneUnit;
    @FindBy(id = "sc-subtotal-amount-activecart")
    WebElement pricePerTwoUnits;
    @FindBy(id = "sc-subtotal-amount-buybox")
    WebElement pricePerTwoUnitsTramitarPedido;
    @FindBy(className = "a-button-input")
    WebElement proceedToCheckoutButton;
    @FindBy (className = "sc-product-title")
    WebElement productName;
    @FindBy (className = "sc-product-price")
    WebElement productPriceCesta;

    @FindBy (xpath = "/html/body/div[1]/div[4]/div[1]/div[8]/div/div[2]/div[4]/div/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/ul/li[6]/span/span[2]")
    WebElement opticalPower;


    WebDriver driver;
    public AmazonCestaPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void printProductTitleInCart() {
        wdWait.until(ExpectedConditions.visibilityOf(productName));
        System.out.println("Product title in cart is: "+productName.getText());
        productTitleCart = productName.getText();
    }

    private void printProductPriceCesta() {
        wdWait.until(ExpectedConditions.visibilityOf(productPriceCesta));
        System.out.println("Product price in cart is: "+productPriceCesta.getText());
        productPrice = productPriceCesta.getText();
    }

    //    private void printPricePerOneUnit() {
//        wdWait.until(ExpectedConditions.visibilityOf(pricePerOneUnit));
//        System.out.println("Price of 1 unit: "+pricePerOneUnit.getText());
//        oneUnitPrice = pricePerOneUnit.getText();
//    }
//
//    private void printPricePerTwoUnits() {
//        wdWait.until(ExpectedConditions.visibilityOf(pricePerTwoUnits));
//        System.out.println("Price of 2 units: "+pricePerTwoUnits.getText());
//        twoUnitsPrice = pricePerTwoUnits.getText();
//    }

//    private void printPricePerTwoUnitsTramitarPedido() {
//        wdWait.until(ExpectedConditions.visibilityOf(pricePerTwoUnitsTramitarPedido));
//        System.out.println("Price of 2 units (2): "+pricePerTwoUnitsTramitarPedido.getText());
//        quantityTwoTramitarPedido = pricePerTwoUnitsTramitarPedido.getText();
//    }


//    public void printProductOpticalPowerInCart() {
//        wdWait.until(ExpectedConditions.visibilityOf(opticalPower));
//        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[1]/div[8]/div/div[2]/div[4]/div/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/ul/li[6]/span/span[2]")));
//        System.out.println("Optical power is: "+opticalPower.getText());
//        opticalPowerCart = opticalPower.getText();
//    }

//    public void clickOnTramitarPedidoButton() { proceedToCheckoutButton.click(); }

    public void proceedToCheckout() {
        printProductTitleInCart();
        printProductPriceCesta();
//        printPricePerOneUnit();
//        printPricePerTwoUnits();
//        printPricePerTwoUnitsTramitarPedido();
//        printProductOpticalPowerInCart();
//        clickOnTramitarPedidoButton();
    }

}