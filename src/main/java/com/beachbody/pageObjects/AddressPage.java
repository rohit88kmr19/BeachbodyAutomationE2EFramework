package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {

    Action action = new Action();

    WebDriver driver;
    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    //    public AddressPage(WebDriver driver) {
//        this.driver = driver;
//    }
    public AddressPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ShippingPage clickOnCheckOut() throws Throwable {
        action.click(getDriver(), proceedToCheckOut);
        return new ShippingPage();
    }

}
