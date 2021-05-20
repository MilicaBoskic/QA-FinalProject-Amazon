package tests;

import pages.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AmazonTest extends BaseTest {

    @Test
    public void SearchFunctionality() throws InterruptedException {

        String searchTerm = "Guitarricadelafuente";

        AmazonSearchPage searchPage = new AmazonSearchPage(driver);
        searchPage.searchProduct(searchTerm);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("s-desktop-width-max")));
        WebElement resultsList = driver.findElement(By.className("s-desktop-width-max"));

        Assert.assertTrue("Search term is not found",
                resultsList.getText().contains("Guitarricadelafuente"));

        //due to visual confirmation
        Thread.sleep(4000);
    }


    @Test
    public void addItemToCart() throws InterruptedException {

        // HOMEPAGE
        String searchTerm = "BAUSCH + LOMB - Biotrue® ONEday - Lentes de contacto de reemplazo diario";

        AmazonHomePage homepage = new AmazonHomePage(driver);
        homepage.searchProduct(searchTerm);

        //RESULTS
        AmazonResultsPage results = new AmazonResultsPage(driver);
        results.chooseProduct();

        // PRODUCT DETAIL
        AmazonProductDetailPage detailPage = new AmazonProductDetailPage(driver);
        detailPage.changeAttributes();

        String productTitleDetailPage = detailPage.productName;
        String productPriceDetailPage = detailPage.productPrice;

        // ADDED PRODUCT
        AmazonAddedProductPage addedProduct = new AmazonAddedProductPage(driver);
        addedProduct.clickOnCestaButton();

        // CESTA
        AmazonCestaPage cesta = new AmazonCestaPage(driver);
        cesta.proceedToCheckout();

        String productTitleCesta = cesta.productTitleCart;
        String productPriceCesta = cesta.productPrice;

//        String quantityTwoPrice = cesta.quantityTwo;
//        String quantityTwoTramitarPedidoPrice = cesta.quantityTwoTramitarPedido;
//

        // ASSERT

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-cart-count")));
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));

        Assert.assertTrue("Cart is empty.",
                cartCount.getText().contains("1"));

        Assert.assertEquals("Titles are not equal",productTitleDetailPage,productTitleCesta);
        Assert.assertEquals("Prices are not equal",productPriceDetailPage,productPriceCesta);


//        cesta.oneUnitPrice = cesta.oneUnitPrice.replace(" €", "");
//        cesta.twoUnitsPrice = cesta.twoUnitsPrice.replace(" €", "");

//        double pricePerOneUnit = Double.parseDouble(cesta.oneUnitPrice);
//        double totalPrice = Double.parseDouble(cesta.twoUnitsPrice);
//        double quantity = 2;
//
//        Assert.assertEquals(totalPrice, pricePerOneUnit * quantity, 001);

        //due to visual confirmation
        Thread.sleep(4000);
    }

    @Test
    public void removeItemFromCart() throws InterruptedException {

        // HOMEPAGE
        String searchTerm = "BAUSCH + LOMB - Biotrue® ONEday - Lentes de contacto de reemplazo diario";

        AmazonHomePage homepage = new AmazonHomePage(driver);
        homepage.searchProduct(searchTerm);

        //RESULTS
        AmazonResultsPage results = new AmazonResultsPage(driver);
        results.chooseProduct();

        // PRODUCT DETAIL
        AmazonProductDetailPage detailPage = new AmazonProductDetailPage(driver);
        detailPage.changeAttributes();

        // ADDED PRODUCT
        AmazonAddedProductPage addedProductPage = new AmazonAddedProductPage(driver);
        addedProductPage.clickOnCestaButton();

        // CESTA
        AmazonCestaPage cesta = new AmazonCestaPage(driver);
        cesta.proceedToCheckout();

        // DELETE PRODUCT

        AmazonDeleteProductPage deleteProduct = new AmazonDeleteProductPage(driver);
        deleteProduct.deleteProductFromCart();


        // ASSERT

        //message
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("sc-your-amazon-cart-is-empty")));
        WebElement cartIsEmpty = driver.findElement(By.className("sc-your-amazon-cart-is-empty"));

        Assert.assertTrue("Product has not been removed from cart.",
                cartIsEmpty.getText().contains("Tu cesta de Amazon está vacía"));

        // cart icon
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-cart-count")));
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));

        Assert.assertTrue("Cart is not empty.",
                cartCount.getText().contains("0"));

        //due to visual confirmation
        Thread.sleep(4000);
    }
}