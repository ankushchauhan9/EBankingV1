package com.banking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    public class XLUtils {

        public static FileInputStream fi;
        public static FileOutputStream fo;
        public static XSSFWorkbook wb;
        public static XSSFSheet ws;
        public static XSSFRow row;
        public static XSSFCell cell;



        public static int getRowCount(String xlfile,String xlsheet) throws IOException
        {
            fi=new FileInputStream(xlfile);
            wb=new XSSFWorkbook(fi);
            ws=wb.getSheet(xlsheet);
            int rowcount=ws.getLastRowNum();
            wb.close();
            fi.close();
            return rowcount;
        }


        public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
        {
            fi=new FileInputStream(xlfile);
            wb=new XSSFWorkbook(fi);
            ws=wb.getSheet(xlsheet);
            row=ws.getRow(rownum);
            int cellcount=row.getLastCellNum();
            wb.close();
            fi.close();
            return cellcount;
        }


        public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
        {
            fi=new FileInputStream(xlfile);
            wb=new XSSFWorkbook(fi);
            ws=wb.getSheet(xlsheet);
            row=ws.getRow(rownum);
            cell=row.getCell(colnum);
            String data;
            try
            {
                DataFormatter formatter = new DataFormatter();
                String cellData = formatter.formatCellValue(cell);
                return cellData;
            }
            catch (Exception e)
            {
                data="";
            }
            wb.close();
            fi.close();
            return data;
        }

        public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
        {
            fi=new FileInputStream(xlfile);
            wb=new XSSFWorkbook(fi);
            ws=wb.getSheet(xlsheet);
            row=ws.getRow(rownum);
            cell=row.createCell(colnum);
            cell.setCellValue(data);
            fo=new FileOutputStream(xlfile);
            wb.write(fo);
            wb.close();
            fi.close();
            fo.close();
        }

        public static HashMap getAllExcelData(String xlFile, String xlsheet,int rownum,int colnum) throws IOException {

            fi = new FileInputStream(xlFile);
            wb = new XSSFWorkbook(fi);
            ws = wb.getSheet(xlsheet);
            HashMap<Integer, ArrayList<String>> mp = new HashMap<Integer, ArrayList<String>>();
            ArrayList<String> xlRowList = null;
            String celldata;
            for(int i = 1; i<= rownum; i++){
                xlRowList = new ArrayList<String>();
                for(int j =0; j<colnum; j++){
                    celldata = getCellData(xlFile, xlsheet, i, j);
                    xlRowList.add(celldata);
                }
                mp.put(i,xlRowList);
            }
            return mp;
        }


    }
