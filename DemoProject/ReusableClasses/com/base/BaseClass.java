package com.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.library.common.CommonLibrary;
import com.library.common.DriverClass;
import com.library.common.ExcelLib;
import com.library.common.PropertiesFetch;
import com.library.common.ResultReport;
import com.library.common.StepCounter;
import com.library.common.StepResultLogger;

import pageobjects.Pageobject;
public class BaseClass extends PropertiesFetch{
	//objects
	public static ResultReport r=new ResultReport();
	public static CommonLibrary clib=new CommonLibrary();
	public static ExcelLib elib=new ExcelLib();
	public  Pageobject obj=new Pageobject();
	public static StepResultLogger slog=new StepResultLogger();
	public static StepCounter sc=new StepCounter();
	public PropertiesFetch p=new PropertiesFetch();
	public  DriverClass driver=new DriverClass();
	
	//resources
	public static String propfile="demo.properties";
	//public static String path="D:\\ExtentReports\\ExtentReportResults";
	public static String spath="D:\\screenshots";
	public static String htmlreport="";
	public static String browser,env,sprint,release,uid,pwd,resultPath,url; 
	@BeforeTest
	public void startTest() throws Exception
	{
		System.out.println("Before Test");
		PropertiesFetch.propertiesFetch(propfile);
		url=PropertiesFetch.url;
		browser=PropertiesFetch.browser;
		env=PropertiesFetch.env;
		sprint=PropertiesFetch.sprint;
		release=PropertiesFetch.release;
		uid=PropertiesFetch.uid;
		pwd=PropertiesFetch.pwd;
		resultPath=PropertiesFetch.resultPath+"\\reports\\";
		htmlreport=PropertiesFetch.resultPath+"\\reports\\";
	}
	
	@BeforeMethod
	public void init()
	{
		sc.resetStepCount();
		System.out.println("Before Method");
		resultPath=resultPath+"\\screenshots\\"+this.getClass().getName()+"\\"+clib.getDateTime();
		htmlreport=htmlreport+"\\extentreport\\"+this.getClass().getName()+".html";;
		clib.browserLaunch(browser);
		obj.pom();
		//clib.implicitWait();
	}
	@AfterMethod
	public void afterMethod() throws IOException
	{
		System.out.println("After Method");
		clib.driverclose();
		sc.resetStepCount();
		r.AutomationReport(htmlreport, "12.3",spath, "QA", "18.10", "Jenkins");
		
	}
	


}
