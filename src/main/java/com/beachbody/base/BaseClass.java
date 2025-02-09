package com.beachbody.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public  class BaseClass {

    public static Properties prop;
    // Declare ThreadLocal Driver
    public static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    //    //loadConfig method is to load the configuration
//    @BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
//    public void loadConfig() {
//        ExtentManager.setExtent();
//        DOMConfigurator.configure("log4j.xml");
    @BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
    public void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "Config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setDriver(WebDriver driverRef) {
        driver.set((RemoteWebDriver) driverRef);
    }

    public static WebDriver getDriver() {
        // Get Driver from threadLocalmap
        return driver.get();
    }

    // Unload
    public static void unload() {
        driver.remove();
    }

    public static void down() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }

    public void launchApp(String browserName) {
        WebDriver localDriver;
        // String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--guest");
//            options.addArguments("--start-maximized");
//            options.addArguments("--remote-allow-origins=*");
            setDriver(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("FireFox")) {
//            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("--guest");
//            options.addArguments("--start-maximized");
//            options.addArguments("--remote-allow-origins=*");
            setDriver(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("IE")) {
//            InternetExplorerOptions options = new InternetExplorerOptions();
//            options.addArguments("--guest");
//            options.addArguments("--start-maximized");
//            options.addArguments("--remote-allow-origins=*");
            setDriver(new InternetExplorerDriver());
        }
        //Maximize the screen
        getDriver().manage().window().maximize();
        //Delete all the cookies
        getDriver().manage().deleteAllCookies();
        //Implicit TimeOuts
        getDriver().manage().timeouts().implicitlyWait
                (Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        //PageLoad TimeOuts
        getDriver().manage().timeouts().pageLoadTimeout
                (Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
        //Launching the URL
        getDriver().get(prop.getProperty("url"));
    }

    @AfterSuite(groups = {"Smoke", "Regression", "Sanity"})
    public void afterSuite() {
        // ExtentManager.endReport();
        System.out.println("Test execution completed. Allure report generated.");
    }
}