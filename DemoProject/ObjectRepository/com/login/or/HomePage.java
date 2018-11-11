package com.login.or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement txt_uid;
	public WebElement txt_uid()
	{
		return txt_uid;
	}
	@FindBy(xpath="//input[@id='pass']")
	private WebElement txt_pass;
	public WebElement txt_pass()
	{
		return txt_pass;
	}
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement btn_login;
	public WebElement btn_login()
	{
		return btn_login;
	}
	
	
	
}
