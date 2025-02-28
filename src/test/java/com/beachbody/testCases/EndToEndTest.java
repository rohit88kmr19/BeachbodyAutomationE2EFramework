package com.beachbody.testCases;

import com.beachbody.Utility.Log;
import com.beachbody.base.BaseClass;
import com.beachbody.dataProvider.DataProviders;
import com.beachbody.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class EndToEndTest extends BaseClass {

    private IndexPage index;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
    private LoginPage loginPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private OrderSummary orderSummary;
    private OrderConfirmationPage orderConfirmationPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(@Optional("chrome")String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    public void endToEndTest(String productName, String qty, String size) throws Throwable {
        Log.startTestCase("endToEndTest");
        index = new IndexPage();
        searchResultPage = index.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnCheckOut();
        loginPage = orderPage.clickOnCheckOut();
        addressPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), addressPage);
        shippingPage = addressPage.clickOnCheckOut();
        shippingPage.checkTheTerms();
        paymentPage = shippingPage.clickOnProceedToCheckOut();
        orderSummary = paymentPage.clickOnPaymentMethod();
        orderConfirmationPage = orderSummary.clickOnconfirmOrderBtn();
        String actualMessage = orderConfirmationPage.validateConfirmMessage();
        String expectedMsg = "Your order on My Store is complete.";
        Assert.assertEquals(actualMessage, expectedMsg);
        Log.endTestCase("endToEndTest");
    }


}
