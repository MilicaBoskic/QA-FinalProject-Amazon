package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomePage extends BaseHelper {

//    @FindBy (id = "nav-global-location-popover-link")
//    WebElement location;
//    @FindBy (id = "GLUXZipUpdateInput")
//    WebElement enterLocation;
//    @FindBy (id = "GLUXZipUpdate")
//    WebElement confirmLocation;

    @FindBy (id = "sp-cc-accept")
    WebElement popUp;
    @FindBy (id = "searchDropdownBox")
    WebElement searchDropDownBox;
    @FindBy (id = "twotabsearchtextbox")
    WebElement searchTextBox;
    @FindBy (id = "nav-search-submit-button")
    WebElement submitLoope;

    WebDriver driver;
    public AmazonHomePage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToPage() { driver.get("https://www.amazon.es/");}

    private void clickOnPopUp() { popUp.click();}

//    private void changeLocation() {
//        wdWait.until(ExpectedConditions.visibilityOf(location));
//        location.click();
//    }
//
//    private void enterNewLocation() {
//        wdWait.until(ExpectedConditions.visibilityOf(enterLocation));
//        enterLocation.sendKeys("28010");
//    }
//    private void confirmNewLocation() {
//        confirmLocation.click();
//    }

    private void chooseProductCategory() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchDropdownBox")));
        Select selector = new Select(searchDropDownBox);
        selector.selectByVisibleText("Salud y cuidado personal");
    }

    private void enterSearchTermInSearchBox(String searchTerm) { searchTextBox.sendKeys(searchTerm); }

    private void clickOnSubmitLoope() {submitLoope.click();}

    public void searchProduct(String searchTerm) {
        navigateToPage();
        clickOnPopUp();
//            changeLocation();
//            enterNewLocation();
//            confirmNewLocation();
        chooseProductCategory();
        enterSearchTermInSearchBox(searchTerm);
        clickOnSubmitLoope();
    }

}