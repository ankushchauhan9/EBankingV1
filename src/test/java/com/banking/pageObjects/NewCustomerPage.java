package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

    WebDriver driver;

    public NewCustomerPage(WebDriver rdriver){
        this.driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy (xpath = "//td//input[@name='name']")
    WebElement custname;

    @FindBy (xpath = "//td//input[@value='m']")
    WebElement mGender;

    @FindBy (xpath ="//td//input[@value='f']")
    WebElement fGender;

    @FindBy (id = "dob")
    WebElement dob;

    @FindBy (xpath = "//textarea[@name='addr']")
    WebElement address;

    @FindBy (xpath = "//td//input[@name='city']")
    WebElement city;

    @FindBy (xpath = "//td//input[@name='state']")
    WebElement state;

    @FindBy (xpath = "//td//input[@name='pinno']")
    WebElement pIN;

    @FindBy (xpath = "//td//input[@name='telephoneno']")
    WebElement telePhone;

    @FindBy (xpath = "//td//input[@name='emailid']")
    WebElement emailID;

    @FindBy (xpath = "//td//input[@name='password']")
    WebElement passWord;

    @FindBy (xpath = "//td//input[@name='sub' and @value='Submit']")
    WebElement submit;

    @FindBy (xpath = "//td//input[@name='res' and @value='reset']")
    WebElement reset;

    public void newCustomerName(String cusName){
        custname.sendKeys(cusName);
    }

    public void setGenderfrNewCust(String gen){
          if(gen.equals("m")){
                mGender.click();
          }else if(gen.equals("f")){
              fGender.click();
          }
    }

    public void setDobfrNewCust(String db){
        dob.sendKeys(db);
    }

    public void setAddressfrNewCust(String addr){
        address.sendKeys(addr);
    }

    public void setCityfrNewCust(String cty){
        city.sendKeys(cty);
    }

    public void setStatefrNewCust(String st){
        state.sendKeys(st);
    }

    public void setPInfrNewCust(String pin){
        pIN.sendKeys(pin);
    }

    public void setMobileNofrNewCust(String mobileno){
        telePhone.sendKeys(mobileno);
    }

    public void setEmailIdfrNewCust(String emailid){
        emailID.sendKeys(emailid);
    }

    public void setPwdfrNewCust(String pwd){
        passWord.sendKeys(pwd);
    }

    public void clickSubmitfrNewCust(){
        submit.click();
    }

    public void clickresetfrNewCust(){
        reset.click();
    }
}
