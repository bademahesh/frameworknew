package com.library.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
	
	XSSFSheet sh;
	XSSFWorkbook wb;
	XSSFRow row;
	FileInputStream fis;
	
	// It returns perticular cell data
	public String getExcelData(String path,String sheetname,int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetname);
		row=sh.getRow(rownum);
		Cell c=row.getCell(colnum);
		String data=c.getStringCellValue().toString();
		wb.close();
		fis.close();
		return data;
		
	}

	//Get Row count
	public int getRowCount(String path,String sheetname) throws Exception
	{
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}
	
	//Get Column Count
	public int getColCount(String path,String sheetname) throws Exception
	{
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetname);
		int colcount=sh.getRow(0).getLastCellNum();
		wb.close();
		fis.close();
		return colcount;
	}
	//Get Data from entire sheet
	public String[][] getTableArray(String path,String sheetname) throws Exception
	{
		
		String [][] tabarray=null;
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetname);
		int totalrows=sh.getLastRowNum();
		int totalcols=sh.getRow(0).getLastCellNum();
		tabarray=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				tabarray[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue().toString();
			}
		}
		wb.close();
		fis.close();
		
	return tabarray;
	}
	//get RowNumber based on first cell value
	
	public int getRowNum(String path,String sheetname,String cellvalue) throws Exception
	{
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		int temp=-1;
		for(int r=1;r<=rowcount;r++)
		{
			Row temprow=sh.getRow(r);
			Cell c=temprow.getCell(0);
			if(c.getRichStringCellValue().toString().equalsIgnoreCase(cellvalue))
			{
				temp=r;
				break;
			}
			
		}
		wb.close();
		fis.close();
		
		return temp;
		
	}
	//Get Column header name with index
	public Map<String,Integer> mapHeader(String path,String sheetname) throws Exception
	{
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetname);
		int colcount=sh.getRow(0).getLastCellNum();
		Map<String,Integer> m=new HashMap<String,Integer>();
		for(int j=0;j<colcount;j++)
		{
			m.put(sh.getRow(0).getCell(j).getStringCellValue().toString(), j);
		}
		wb.close();
		fis.close();
		
		return m;
		
	}
	
}
