package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.WebDriver;

public class OrderSummary extends BaseClass {

    Action action = new Action();

    WebDriver driver;
    public OrderSummary(WebDriver driver) {
        this.driver = driver;
    }


}
