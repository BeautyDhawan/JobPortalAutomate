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

public class ContactTest extends TestBasenew {

    TestUtil util;
    loginpage page;
    HomePage homePage;
    ContactsPage contactPage;

    public ContactTest(){
        super();
    }

    @BeforeSuite
    public void setup() throws InterruptedException {
        initialization();
        util = new TestUtil();
        Thread.sleep(2000);
        contactPage = new ContactsPage();
        Thread.sleep(3000);
        page = new loginpage();
        Thread.sleep(3000);
        page.userlogin(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(3000);
        homePage = page.clickonloginbtn();
        Thread.sleep(3000);
        util.switchtoframe();
        Thread.sleep(3000);
        contactPage = homePage.clickonContacts();
        Thread.sleep(3000);

    }
      @Test(priority = 1)
      public void verifyContactsPageLabe() throws InterruptedException {
        driver.get("https://classic.freecrm.com/index.cfm?CFID=1021604&CFTOKEN=51253288&jsessionid=48309a0f901be5e0b16d684935761312392d");
        util.switchtoframe();
         Assert.assertTrue(contactPage.verifycontactslabel(), "contact label missing");


         Thread.sleep(3000);
        }

        @Test(priority = 2)
    public void checkboxcheck() throws InterruptedException {

         //   WebDriverWait wait = new WebDriverWait(driver, 3);
         ///   WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[4]/td[1]/input")));
        //    checkbox.click();

       contactPage.selectcheckbox("abhi sahu");

    }


        @AfterSuite
    public void teardown(){
        driver.quit();
        }
    }


