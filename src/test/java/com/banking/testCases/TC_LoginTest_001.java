package com.banking.testCases;

import com.banking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {


        logger.info("URL is open");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("username is entered");
        lp.setPassword(password);
        logger.info("password is entered");
        lp.clickSubmit();

        if(driver.getTitle().equals("Guru99 Bank manager Homepage")){
               Assert.assertTrue(true);
               logger.info("Login test passed");
        }else{
            captureScreen(driver, "loginTest");
            Assert.assertFalse(false);
            logger.info("login test failed");
        }

    }


}
