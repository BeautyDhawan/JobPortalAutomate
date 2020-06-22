package com.crm.qa.testcases;

import com.crm.qa.base.TestBasenew;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.loginpage;
import com.crm.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//Testcases should be independent the r separated.
//before each testcase launch the browser and login
//@Test....execute test case
//after each testcase close the browser

public class HomePageTest  extends TestBasenew {
    loginpage page;
    HomePage homePage;
    TestUtil util;
    ContactsPage contactsPage;
    public HomePageTest(){
        super();
    }

    @BeforeSuite
    public void setUp() throws InterruptedException {
        initialization();
        util = new TestUtil();
        contactsPage = new ContactsPage();
        loginpage page= new loginpage();
        page.userlogin(prop.getProperty("username"),prop.getProperty("password"));
            Thread.sleep(10000);
          homePage =  page.clickonloginbtn(); //returning the object of homepage
        Thread.sleep(10000);
        }

        @Test(priority = 1)
    public void varifyHomePage() throws InterruptedException {
      String homepagetitle = homePage.verifyhomepagetitle();
            Assert.assertEquals(homepagetitle,"CRMPRO", "homepage title not match");
       Thread.sleep(10000);

        }
        @Test(priority = 2)
       public void userlabel() throws InterruptedException {

        Assert.assertTrue(homePage.varifyusernamelable(),"label is not matched");


      Thread.sleep(3000);
        }


        @Test(priority = 3)
        public void ContactsPage(){


    //   util.switchtoframe();
            contactsPage  =  homePage.clickonContacts();

        }


    @AfterSuite
    public void teardwon(){
        driver.quit();
    }

    }

