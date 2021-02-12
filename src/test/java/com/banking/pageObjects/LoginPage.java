package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
          this.ldriver = rdriver;
          PageFactory.initElements(rdriver, this);
    }

   @FindBy (name="uid")
    WebElement txtusername;

   @FindBy(name = "password")
    WebElement txtpassword;

   @FindBy (name="btnLogin")
    WebElement btnLogin;

   @FindBy (name="btnReset")
    WebElement btnReset;

   @FindBy (xpath = "//li//a[text()='Log out']")
   WebElement logOut;


   public void setUserName(String uname){
       txtusername.sendKeys(uname);
   }

   public void setPassword(String pwd){
       txtpassword.sendKeys(pwd);
   }

   public void clickSubmit(){
       btnLogin.click();
   }

   public void clickReset(){
       btnReset.click();
   }

   public void clickLogOut(){ logOut.click();}

}
