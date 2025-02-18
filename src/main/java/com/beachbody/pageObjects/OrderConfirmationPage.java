package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {

    Action action = new Action();

    WebDriver driver;
//    public OrderConfirmationPage(WebDriver driver) {
//        this.driver = driver;
//    }

    @FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
    private WebElement confirmMessag;

    public OrderConfirmationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String validateConfirmMessage() {
        String confirmMsg=confirmMessag.getText();
        return confirmMsg;
    }




}
