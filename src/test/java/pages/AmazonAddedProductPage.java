package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonAddedProductPage extends BaseHelper {

    @FindBy (id = "hlb-view-cart-announce")
    WebElement cestaButton;

    WebDriver driver;
    public AmazonAddedProductPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCestaButton() {
        wdWait.until(ExpectedConditions.visibilityOf(cestaButton));
        cestaButton.click();
    }
}