package com.beachbody.testCases;

import com.beachbody.Utility.Log;
import com.beachbody.base.BaseClass;
import com.beachbody.pageObjects.AddToCartPage;
import com.beachbody.pageObjects.IndexPage;
import com.beachbody.pageObjects.OrderPage;
import com.beachbody.pageObjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrderPageTest extends BaseClass {

    private IndexPage index;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProvider.class)
    public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
        Log.startTestCase("verifyTotalPrice");
        index = new IndexPage();
        searchResultPage = index.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnCheckOut();
        Double unitPrice = orderPage.getUnitPrice();
        Double totalPrice = orderPage.getTotalPrice();
        Double totalExpectedPrice = (unitPrice * (Double.parseDouble(qty))) + 2;
        Assert.assertEquals(totalPrice, totalExpectedPrice);
        Log.endTestCase("verifyTotalPrice");

    }

}
