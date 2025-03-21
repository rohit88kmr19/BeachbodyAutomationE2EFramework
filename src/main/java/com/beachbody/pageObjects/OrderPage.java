package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {
    Action action = new Action();

    WebDriver driver;
//    public OrderPage(WebDriver driver) {
//        this.driver = driver;
//    }


    @FindBy(xpath="//td[@class='cart_unit']/span/span")
    private WebElement unitPrice;

    @FindBy(id="total_price")
    private WebElement totalPrice;

    @FindBy(xpath="//span[text()='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    public OrderPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public double getUnitPrice() {
        String unitPrice1=unitPrice.getText();
        String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalUnitPrice=Double.parseDouble(unit);
        return finalUnitPrice/100;
    }

    public double getTotalPrice() {
        String totalPrice1=totalPrice.getText();
        String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice=Double.parseDouble(tot);
        return finalTotalPrice/100;
    }

    public LoginPage clickOnCheckOut() throws Throwable {
        action.click(getDriver(), proceedToCheckOut);
        return new LoginPage();
    }



}
