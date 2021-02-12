package com.banking.testCases;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass {


    @Test (dataProvider = "LoginData")
    public void loginDDT(String usrnm, String pwd){
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(usrnm);
        lp.setPassword(pwd);
        lp.clickSubmit();

        if(isAlertPresent() == true){
              driver.switchTo().alert().accept();
              driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warn("Invalid credentials");
        }else{
            Assert.assertTrue(true);
            lp.clickLogOut();
            driver.switchTo().alert().accept();
            logger.info("user successfully logout");
        }

    }

    @DataProvider(name="LoginData")
    public Object[][] getData() throws IOException {

         String path = System.getProperty("user.dir")+"/src/test/java/com/banking/testData/LoginData.xlsx";
         int rowNumber = XLUtils.getRowCount(path,"Sheet1");
         int cellNumber = XLUtils.getCellCount(path, "Sheet1", rowNumber);
         String loginData[][] = new String[rowNumber][cellNumber];

         for(int i = 1; i<=rowNumber; i++){
             for(int j = 0; j<cellNumber; j++){
                 loginData[i-1][j] = XLUtils.getCellData(path,"Sheet1", i, j);
             }
         }
           return loginData;
    }


}
