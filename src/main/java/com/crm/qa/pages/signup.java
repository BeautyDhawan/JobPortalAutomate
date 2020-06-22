package com.crm.qa.pages;

import com.crm.qa.base.TestBasenew;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signup extends TestBasenew {

// page factory / OR(Object repository)
    @FindBy(css = ".page .txt-white")
    WebElement buttonclick;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name ="phone")
    WebElement phone;

    @FindBy(id = "terms")
    WebElement checkbox;

    @FindBy(css =".recaptcha-checkbox-checkmark")
    WebElement checkbox2;

    @FindBy(name ="action")
    WebElement signup;

    @FindBy(css =".brand-name")
    WebElement crmlogo;


/// initializing the pge objects
    public signup(){   // constructor creation
        // this pointing current class object
        PageFactory.initElements(driver, this);  // how will u initialize pagefactory...ans-pagefactory.initelement(means inititialize elements with driver and this means current class object)
    }

    // Actions

    public void clickonsignup(){
        buttonclick.click();
    }
    public String validatesignuppagetitle(){   // this method give u a gettitle in a string
        return driver.getTitle();
    }
    public boolean validatecrmimage(){
       return crmlogo.isDisplayed();
    }
    public void signup(String em, String ph) throws InterruptedException {
       email.sendKeys(em);
       phone.sendKeys(ph);
        checkbox.click();
        Thread.sleep(10000);


      // checkbox2.click();  // if its return any class object so we use return new homepage(class). and instead of void we use homepage
      //  System.out.println("button click or not"+ checkbox2.isSelected());
       // Thread.sleep(10000);

    }



}
