package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BaseClass {
    Action action = new Action();

    WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }



}
