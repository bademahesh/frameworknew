package com.library.common;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.base.BaseClass;

public class CommonLibrary extends BaseClass{
//added new bash adddd
	public void implicitWait()
	{
		DriverClass.d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public void browserLaunch(String browser)
	{
		switch(browser)
		{
		case "chrome": System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Browserdrivers//chromedriver.exe");
		DriverClass.d=new ChromeDriver();
		break;
		}
		
	}
	public void driverclose()
	{
		DriverClass.d.close();
	}
	public void screenShotSelenium(String path,String imgname,String teststepnum) throws IOException
	{
		String dpath=path+imgname+teststepnum+".jpg";
		EventFiringWebDriver edriver=new EventFiringWebDriver(DriverClass.d);
		File srcimg=edriver.getScreenshotAs(OutputType.FILE);
		File desc2path=new File(dpath);
		FileUtils.copyFile(srcimg, desc2path);
	}
	public String windowScreenshot(String path,String imgname,String teststepnum) throws Exception, AWTException
	{
		
		BufferedImage image=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		String descpath=path+imgname+teststepnum+".jpg";
		ImageIO.write(image, "jpg", new File(descpath));
		return teststepnum;
		
	}
	
	public String getDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		return dateFormat.format(dt).toString();
		
	}
	
	public boolean isElementPresent(By by) {
	    try {
	    	DriverClass.d.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  public boolean isAlertPresent() {
	    try {
	    	DriverClass.d.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	
	
}
