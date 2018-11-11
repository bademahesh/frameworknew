package com.library.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFetch {
	public static String browser,env,sprint,release,uid,pwd,resultPath,url; 
	public static void propertiesFetch(String path) throws IOException
	{
		FileInputStream fis=new FileInputStream(path);
		Properties p=new Properties();
		p.load(fis);
		url=p.getProperty("url");
		browser=p.getProperty("browser");
		env=p.getProperty("enviroment");
		sprint=p.getProperty("sprint");
		release=p.getProperty("release");
		uid=p.getProperty("uid");
		pwd=p.getProperty("pwd");
		resultPath=p.getProperty("resultPath");
	}
}
