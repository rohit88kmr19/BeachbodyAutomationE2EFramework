package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BaseClass {

    Action action = new Action();

    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }



}
