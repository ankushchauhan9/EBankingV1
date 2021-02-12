package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

   Properties prop;
   public ReadConfig(){

       File src = new File("./Configuration/config.properties");
       try{
           FileInputStream inputStream = new FileInputStream(src);
           prop = new Properties();
           prop.load(inputStream);
       }catch(Exception e){
            System.out.println(e.getMessage());
       }
   }

     public String getApplicationURL(){
        String url = prop.getProperty("baseURL");
        return url;
     }

     public String getUserName(){
         String usrname = prop.getProperty("username");
         return usrname;
     }

    public String getPassword(){
        String pwd = prop.getProperty("password");
        return pwd;
    }

     public String getChromedriverPath(){
         String chromeDriverPath = prop.getProperty("chromepath");
         return chromeDriverPath;
     }

    public String getFirefoxdriverPath(){
        String firefoxDriverPath = prop.getProperty("firefoxpath");
        return firefoxDriverPath;
    }

    public String getIEdriverPath(){
        String ieDriverPath = prop.getProperty("iepath");
        return ieDriverPath;
    }

    public String getedgedriverPath(){
        String edgeDriverPath = prop.getProperty("edge");
        return edgeDriverPath;
    }

}
