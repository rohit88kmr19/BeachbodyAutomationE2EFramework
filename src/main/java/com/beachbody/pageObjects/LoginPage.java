package com.beachbody.pageObjects;

import com.beachbody.actionDriver.Action;
import com.beachbody.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.beachbody.base.BaseClass.getDriver;

public class LoginPage extends BaseClass {

//    @FindBy(id="email")
//    private WebElement userName;
//
//    @FindBy(id="passwd")
//    private WebElement password;
//
//    @FindBy(id="SubmitLogin")
//    private WebElement signInBtn;
//
//    @FindBy(name="email_create")
//    private WebElement emailForNewAccount;
//
//    @FindBy(name="SubmitCreate")
//    private WebElement createNewAccountBtn;
//
//    public LoginPage() {
//        PageFactory.initElements(getDriver(), this);
//    }


    Action action = new Action();

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userName= By.id("email");
    private By passWord= By.id("passwd");
    private By signInBtn= By.id("SubmitLogin");
    private By emailForNewAccount= By.name("email_create");
    private By createNewAccountBtn= By.name("SubmitCreate");

    WebElement userNameField= driver.findElement(userName);
    WebElement passWordField=driver.findElement(passWord);
    WebElement signInBtnElement =driver.findElement(signInBtn);
    WebElement emailForNewAccountField = driver.findElement(emailForNewAccount);
    WebElement createNewAccountbtnField = driver.findElement(createNewAccountBtn);

    public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
        action.scrollByVisibilityOfElement(getDriver(), userNameField);
        action.type(userNameField, uname);
        action.type(passWordField, pswd);
        action.JSClick(getDriver(), signInBtnElement);
        Thread.sleep(2000);
        homePage=new HomePage(driver);
        return homePage;
    }

    public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
        action.scrollByVisibilityOfElement(getDriver(), userNameField);
        action.type(userNameField, uname);
        action.type(passWordField, pswd);
        action.click(getDriver(), signInBtnElement);
        Thread.sleep(2000);
        addressPage=new AddressPage();
        return addressPage;
    }

    public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
        action.type(emailForNewAccountField, newEmail);
        action.click(getDriver(), createNewAccountbtnField);
        return new AccountCreationPage();
    }




}
