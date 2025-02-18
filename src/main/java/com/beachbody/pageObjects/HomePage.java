package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath="//span[text()='My wishlists']")
    private WebElement myWishList;

    @FindBy(xpath = "//span[text()='Order history and details']")
    private WebElement orderHistory;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

//    WebDriver driver;
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//    }

//    private By myWishList = By.xpath("//span[text()='My wishlists']");
//    private By orderHistory=By.xpath("//span[text()='Order history and details']");
//
//    WebElement myWishListButton = driver.findElement(myWishList);
//    WebElement orderHistoryButton=driver.findElement(orderHistory);


    public boolean validateMyWishList() throws Throwable {
        return action.isDisplayed(getDriver(), myWishList);
    }

    public boolean validateOrderHistory() throws Throwable {
        return action.isDisplayed(getDriver(), orderHistory);
    }

    public String getCurrURL() throws Throwable {
        String homePageURL=action.getCurrentURL(getDriver());
        return homePageURL;
    }



}
