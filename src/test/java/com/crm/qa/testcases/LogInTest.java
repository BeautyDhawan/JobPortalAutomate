package com.crm.qa.testcases;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.loginpage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LogInTest extends com.crm.qa.base.TestBasenew{

    loginpage page;
    HomePage homepage;

    public  LogInTest(){
        super();

    }

    @BeforeSuite
    public void setup() throws InterruptedException {
        initialization();
        page = new loginpage();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
   public void userloginTest() throws InterruptedException {
        page.userlogin(prop.getProperty("username"),prop.getProperty("password"));
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void loginclick() throws InterruptedException {
      homepage =  page.clickonloginbtn();   // it will give us homepage object so we can save in homepage object

    }

    @AfterSuite
    public void teardown(){
        driver.quit();
    }
}
