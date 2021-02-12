package com.banking.testCases;

import com.banking.pageObjects.NewCustomerPage;
import com.banking.utilities.XLUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TC_AddNewCustomerTestDDT extends BaseClass{


    @Test
    public void getAllExcelData() throws IOException {
        String testData = System.getProperty("user.dir")+"/src/test/java/com/banking/testData/AddNewCustomer.xlsx";
        int rownum = XLUtils.getRowCount(testData, "Sheet1");
        int colnum = XLUtils.getCellCount(testData,"Sheet1", rownum);
        HashMap<Integer, ArrayList<String>> hmp = XLUtils.getAllExcelData(testData,"Sheet1", rownum, colnum);
        NewCustomerPage custInfo = new NewCustomerPage();
        for(Map.Entry<Integer, ArrayList<String>> itr : hmp.entrySet()){
            ArrayList<String> newCustList = (ArrayList)itr.getValue();
            for(int i= 0; i< newCustList.size(); i++){
                custInfo.newCustomerName(newCustList.get(i));
                custInfo.setGenderfrNewCust(listData);
                custInfo.setDobfrNewCust(listData);
                    System.out.println(listData);
            }
        }
    }

}
