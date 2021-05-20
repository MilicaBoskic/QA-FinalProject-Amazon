package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonResultsPage extends BaseHelper {

    public String productTitle;

    @FindBy (className = "a-text-bold")
    WebElement resultsForSearchTerm;
    @FindBy (className = "s-result-list")
    WebElement productsHolder;
    @FindBy (className = "s-image")
    WebElement product;

    WebDriver driver;
    public AmazonResultsPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void productTitleInSearchBox() {
        wdWait.until(ExpectedConditions.visibilityOf(resultsForSearchTerm));
//        System.out.println("Product title in search box is: "+resultsForSearchTerm.getText());
        productTitle = resultsForSearchTerm.getText();
    }


    private void clickOnProduct() {
        wdWait.until(ExpectedConditions.visibilityOf(product));
        product.click();

//        wdWait.until(ExpectedConditions.visibilityOf(productsHolder));
//        List<WebElement> products = productsHolder.findElements(By.tagName("div"));
//        System.out.println("Search results: "+products.size());
//
//        wdWait.until(ExpectedConditions.visibilityOf(product));
//        WebElement firstProduct = products.get(0);
//        WebElement product = firstProduct.findElement(By.className("s-image"));
//        js.executeScript("arguments[0].click();",product);

    }

    public void chooseProduct() {
        productTitleInSearchBox();
        clickOnProduct();
    }

}