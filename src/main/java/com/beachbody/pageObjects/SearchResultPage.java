package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

    Action action= new Action();

    @FindBy(xpath="//*[@id=\"center_column\"]//img")
    private WebElement productResult;

    public SearchResultPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isProductAvailable() throws Throwable {
        return action.isDisplayed(getDriver(), productResult);
    }

    public AddToCartPage clickOnProduct() throws Throwable {
        action.click(getDriver(), productResult);
        return new AddToCartPage();
    }


}
