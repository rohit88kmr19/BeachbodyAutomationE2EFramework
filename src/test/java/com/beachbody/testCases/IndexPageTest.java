package com.beachbody.testCases;

import com.beachbody.Utility.Log;
import com.beachbody.base.BaseClass;
import com.beachbody.pageObjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.beachbody.base.BaseClass.getDriver;

public class IndexPageTest extends BaseClass {


    private IndexPage indexPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(@Optional("chrome")String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Smoke")
    public void verifyLogo() throws Throwable {
        Log.startTestCase("verifyLogo");
        indexPage= new IndexPage(getDriver());
        boolean result=indexPage.validateLogo();
        Assert.assertTrue(result);
        Log.endTestCase("verifyLogo");
    }

    @Test(groups = "Smoke")
    public void verifyTitle() {
        Log.startTestCase("verifyTitle");
        String actTitle=indexPage.getMyStoreTitle();
        Assert.assertEquals(actTitle, "My Shop");
        System.out.println("The actual title of Store is-->"+actTitle);
        Log.endTestCase("verifyTitle");
    }

}
