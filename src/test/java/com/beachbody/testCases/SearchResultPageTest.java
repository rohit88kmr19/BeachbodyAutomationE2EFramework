package com.beachbody.testCases;

import com.beachbody.Utility.Log;
import com.beachbody.base.BaseClass;
import com.beachbody.dataProvider.DataProviders;
import com.beachbody.pageObjects.IndexPage;
import com.beachbody.pageObjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchResultPageTest extends BaseClass {


    private IndexPage index;
    private SearchResultPage searchResultPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(@Optional("chrome")String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
    public void productAvailabilityTest(String productName) throws Throwable {
        Log.startTestCase("productAvailabilityTest");
        index = new IndexPage();
        searchResultPage = index.searchProduct(productName);
        boolean result = searchResultPage.isProductAvailable();
        Assert.assertTrue(result);
        Log.endTestCase("productAvailabilityTest");

    }
}
