package com.login.or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {
	
	
	
	//txt_firstname 
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement txt_firstname;
	public WebElement txt_firstname()
	{
		return txt_firstname;
	}
	
	// txt_createpwd
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement txt_createpwd;
	public WebElement txt_createpwd()
	{
		return txt_createpwd;
	}
	

}
