package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.WebDriver;

public class AccountCreationPage extends BaseClass {

    Action action = new Action();

    WebDriver driver;
    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
    }
}
