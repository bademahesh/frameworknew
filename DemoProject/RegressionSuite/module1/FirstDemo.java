package module1;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.library.common.CommonLibrary;
import com.library.common.ExcelLib;
import com.library.common.ResultReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class FirstDemo {
	public static ExtentTest test;
	public static ExtentReports report;
	public static  WebDriver d;
	public static String path="D:"+"\\results\\"+"ExtentReportResults";
	public static String spath="D:\\screenshots";
	static ResultReport r=new ResultReport();
	static CommonLibrary lib=new CommonLibrary();
	ExcelLib elib=new ExcelLib();
	
	
	public static String rpath=path+lib.getDateTime()+".html";
	String xlpath="D:\\"+"demo.xlsx";
	@BeforeClass
	public static void startTest()
	{
		
	report = new ExtentReports(rpath);
	test = report.startTest("Demo Extent reports");
	}
	@BeforeMethod
	public void init()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Browserdrivers//chromedriver.exe");
		d=new ChromeDriver();
		
		//ChromeDriver d=new ChromeDriver();
		d.get("https://www.google.co.in");
		
	}
	@DataProvider()
	public Object[][] getData() throws Exception
	{
		
		String[][] data=elib.getTableArray(xlpath, "demo");
		return data;
		
	}
	@Test(dataProvider="getData")
	public void extentReportsDemo(String uname,String pwd)
	{
		System.out.println(uname);
		System.out.println(pwd);
	if(d.getTitle().equals("Google"))
	{
		test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	else
	{
	test.log(LogStatus.FAIL, "Test Failed");
	}
	}
	@AfterMethod
	public void afterMethod() throws IOException
	{
		d.close();
		report.endTest(test);
		report.flush();
		r.AutomationReport(rpath, "12.3",spath, "QA", "18.10", "Jenkins");
		
		
	}
	
	}
	

	


