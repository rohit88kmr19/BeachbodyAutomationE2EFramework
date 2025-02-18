package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    Action action = new Action();

    @FindBy(id="email")
    private WebElement userName;

    @FindBy(id="passwd")
    private WebElement password;

    @FindBy(id="SubmitLogin")
    private WebElement signInBtn;

    @FindBy(name="email_create")
    private WebElement emailForNewAccount;

    @FindBy(name="SubmitCreate")
    private WebElement createNewAccountBtn;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }
//
//    WebDriver driver;
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//    }

//    private By userName= By.id("email");
//    private By passWord= By.id("passwd");
//    private By signInBtn= By.id("SubmitLogin");
//    private By emailForNewAccount= By.name("email_create");
//    private By createNewAccountBtn= By.name("SubmitCreate");
//
//    WebElement userNameField= driver.findElement(userName);
//    WebElement passWordField=driver.findElement(passWord);
//    WebElement signInBtnElement =driver.findElement(signInBtn);
//    WebElement emailForNewAccountField = driver.findElement(emailForNewAccount);
//    WebElement createNewAccountbtnField = driver.findElement(createNewAccountBtn);

    public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
        action.scrollByVisibilityOfElement(getDriver(), userName);
        action.type(userName, uname);
        action.type(password, pswd);
        action.JSClick(getDriver(), signInBtn);
        Thread.sleep(2000);
        homePage=new HomePage();
        return homePage;
    }

    public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
        action.scrollByVisibilityOfElement(getDriver(), userName);
        action.type(userName, uname);
        action.type(password, pswd);
        action.click(getDriver(), signInBtn);
        Thread.sleep(2000);
        addressPage=new AddressPage();
        return addressPage;
    }

    public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
        action.type(emailForNewAccount, newEmail);
        action.click(getDriver(), createNewAccountBtn);
        return new AccountCreationPage();
    }




}
