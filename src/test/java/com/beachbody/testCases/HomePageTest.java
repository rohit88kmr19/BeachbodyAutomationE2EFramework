package com.beachbody.testCases;

import com.beachbody.Utility.Log;
import com.beachbody.base.BaseClass;
import com.beachbody.dataProvider.DataProviders;
import com.beachbody.pageObjects.HomePage;
import com.beachbody.pageObjects.IndexPage;
import com.beachbody.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends BaseClass {


    private IndexPage indexPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(@Optional("chrome")String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void wishListTest(String uname, String pswd) throws Throwable {
        Log.startTestCase("wishListTest");
        indexPage= new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        homePage=loginPage.login(uname,pswd,homePage);
        boolean result=homePage.validateMyWishList();
        Assert.assertTrue(result);
        Log.endTestCase("wishListTest");
    }

    @Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
        Log.startTestCase("orderHistoryandDetailsTest");
        indexPage= new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        homePage=loginPage.login(uname,pswd,homePage);
        boolean result=homePage.validateOrderHistory();
        Assert.assertTrue(result);
        Log.endTestCase("orderHistoryandDetailsTest");
    }


}
