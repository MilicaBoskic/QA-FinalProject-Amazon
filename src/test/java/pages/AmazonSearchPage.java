package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AmazonSearchPage extends BaseHelper {

    public String productTitle;

    @FindBy(id = "sp-cc-accept")
    WebElement popUp;
    @FindBy (id = "searchDropdownBox")
    WebElement searchDropDownBox;
    @FindBy (id = "twotabsearchtextbox")
    WebElement searchTextBox;
    @FindBy (id = "nav-search-submit-button")
    WebElement submitLoope;
    @FindBy(className = "a-color-state")
    WebElement resultsForSearchTerm;

    WebDriver driver;
    public AmazonSearchPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToPage() { driver.get("https://www.amazon.es/");}

    private void clickOnPopUp() { popUp.click();}

    private void chooseProductCategory() {

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchDropdownBox")));
        Select selector = new Select(searchDropDownBox);
        selector.selectByVisibleText("Música: CDs y vinilos");
    }

    private void enterSearchTermInSearchBox(String searchTerm) { searchTextBox.sendKeys(searchTerm); }

    private void clickOnSubmitLoope() {submitLoope.click();}

    public void searchProduct(String searchTerm) {
        navigateToPage();
        clickOnPopUp();
        chooseProductCategory();
        enterSearchTermInSearchBox(searchTerm);
        clickOnSubmitLoope();
    }
}
