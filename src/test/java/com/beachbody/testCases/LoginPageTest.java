package com.beachbody.testCases;

import com.beachbody.Utility.Log;
import com.beachbody.base.BaseClass;
import com.beachbody.dataProvider.DataProviders;
import com.beachbody.pageObjects.HomePage;
import com.beachbody.pageObjects.IndexPage;
import com.beachbody.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseClass {

    private IndexPage indexPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(@Optional("chrome") String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }
    @Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void loginTest(String uname, String pswd) throws Throwable {
        Log.startTestCase("loginTest");
        indexPage= new IndexPage(getDriver());
        Log.info("user is going to click on SignIn");
        loginPage=indexPage.clickOnSignIn();
        Log.info("Enter Username and Password");
        //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        homePage=loginPage.login(uname,pswd,homePage);
        String actualURL=homePage.getCurrURL();
        String expectedURL="http://automationpractice.com/index.php?controller=my-account";
        Log.info("Verifying if user is able to login");
        Assert.assertEquals(actualURL, expectedURL);
        Log.info("Login is Sucess");
        Log.endTestCase("loginTest");
    }

}
