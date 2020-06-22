package com.crm.qa.testcases;

import com.crm.qa.base.TestBasenew;
import com.crm.qa.pages.signup;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class signuppagetest extends TestBasenew {
    signup page ;  // define in class lvel so we can use it throughout the program

    public signuppagetest(){
        super();  // it will call testbase class constructor
    }
    @BeforeSuite
    public void setup() throws InterruptedException {
        initialization();
        page = new signup();
        Thread.sleep(10000);
    }
    @Test(priority = 1)
    public void signupTitleCheck() throws InterruptedException {
    String title =  page.validatesignuppagetitle();
    Assert.assertEquals(title,"Free CRM #1 cloud software for any business large or small");
  //  Thread.sleep(10000);
    }
    @Test(priority = 2)
    public void checkLogo() throws InterruptedException {
       boolean img =  page.validatecrmimage();
       Assert.assertTrue(img);
      // Thread.sleep(10000);
    }
    @Test(priority = 3)
    public void signupclick() throws InterruptedException {
        page.clickonsignup();

    }

    @Test(priority = 4)
    public void signuptest() throws InterruptedException {
       driver.get("https://register.freecrm.com/register/");   // thi is for bcz this element is in this iframe so first we have to move this iframe

       page.signup(prop.getProperty("email"),prop.getProperty("phone"));


        Thread.sleep(10000);
    }
    @AfterSuite
    public void teardown(){
        driver.quit();
    }
}
