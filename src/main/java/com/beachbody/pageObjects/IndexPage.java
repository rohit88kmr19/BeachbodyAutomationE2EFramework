package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IndexPage extends BaseClass {

    Action action = new Action();

    WebDriver driver;
//    public IndexPage(WebDriver driver) {
//        this.driver =driver;
//    }

    public IndexPage() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(xpath = "//a[@class='login']")
    WebElement signINBtn;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement myStoreLogo;

    @FindBy(id="search_query_top")
    private WebElement searchProductBox;

    @FindBy(name="submit_search")
    private WebElement searchButton;

//    private By signInBtn = By.xpath("//a[@class='login']");
//    private By myStoreLogo = By.xpath("//img[@class='logo img-responsive']");
//    private By searchProductBox = By.id("search_query_top");
//    private By searchButton = By.name("submit_search");

    public LoginPage clickOnSignIn() {
        //WebElement signInElement= driver.findElement(signInBtn);
       action.explicitWait(getDriver(),signINBtn,5);
        //Assert.assertNotNull(signInElement, "Sign In button not found!");
        //action.fluentWait(getDriver(), signInElement, 10);
        //action.mouseOverElement(getDriver(),signInElement);
        action.click(getDriver(), signINBtn);
        return new LoginPage();
    }

    public boolean validateLogo() throws Throwable {
       // WebElement myStoreLogoElement = driver.findElement(myStoreLogo);
        return action.isDisplayed(getDriver(), myStoreLogo);
    }


    public String getMyStoreTitle() {
        //driver.findElement(myStoreLogo);
        String myStoreTitle=getDriver().getTitle();
        return myStoreTitle;
    }

    public SearchResultPage searchProduct(String productName) throws Throwable {
        //WebElement searchProductElement = driver.findElement(searchProductBox);
       // WebElement searchButtonElement= driver.findElement(searchButton);
        action.type(searchProductBox, productName);
        action.scrollByVisibilityOfElement(getDriver(), searchButton);
        action.click(getDriver(), searchButton);
        Thread.sleep(3000);
        return new SearchResultPage();
    }


}
