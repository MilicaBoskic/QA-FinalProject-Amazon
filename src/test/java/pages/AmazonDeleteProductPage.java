package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonDeleteProductPage extends BaseHelper {

    @FindBy (className = "a-color-link")
    WebElement deleteButton;

    WebDriver driver;
    public AmazonDeleteProductPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void deleteProductFromCart(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("a-color-link")));
        js.executeScript("arguments[0].click();",deleteButton);
//        deleteButton.click();
    }

}
