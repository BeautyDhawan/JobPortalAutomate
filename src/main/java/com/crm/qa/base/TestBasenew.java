package com.crm.qa.base;

import com.crm.util.WebEventListner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBasenew {
    //Static variables are initialized only once ,
    // at the start of the execution. These variables will be initialized first,
    // before the initialization of any instance variables


    // golbal variable for using in child and other class
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListner listner;


    public TestBasenew() {
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("C:\\Users\\Beauty\\IdeaProjects\\QuickerJobs\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initialization() throws InterruptedException {
        String browsername = prop.getProperty("browser");
        if (browsername.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Beauty\\Desktop\\New\\geckodriver.exe");
        }

        e_driver = new EventFiringWebDriver(driver);
        //now create the object of Eventlisterner to register it with EventFireWebDriver;

        listner = new WebEventListner();
        e_driver.register(listner);
        driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        //  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        Thread.sleep(10000);
        //  driver.get(prop.getProperty("url"));
        driver.get(prop.getProperty("urlforlogin"));

    }
}




