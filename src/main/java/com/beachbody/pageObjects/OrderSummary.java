package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends BaseClass {

    Action action= new Action();

    @FindBy(xpath="//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrderBtn;

    public OrderSummary() {
        PageFactory.initElements(getDriver(), this);
    }

    public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
        action.click(getDriver(), confirmOrderBtn);
        return new OrderConfirmationPage();
    }
}
