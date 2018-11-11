package com.library.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ResultReport {
	
	public static void AutomationReport(String htmlfile,String sprint,String screenshots,String env,String release,String module) throws IOException
	{
		FileReader fr=new FileReader(htmlfile);
		BufferedReader br=new BufferedReader(fr);
		StringBuilder content=new StringBuilder(1024);
		String s;
		while((s=br.readLine())!=null)
		{
			content.append(s);
		}
		s=content.toString();
		s=s.replaceAll("http://extentreports.relevantcodes.com/", "");
		s=s.replaceAll("<span>ExtentReports", "Screenshots");
		s=s.replaceAll("http://extentreports.com/", "href=\""+screenshots+"\"");
		s=s.replaceAll("v2.41.1", "SBS Release:"+release);
		s=s.replaceAll("Tests", "Sprint:"+sprint+"|Environment:"+env);
		s=s.replaceAll("Automation Report", module);
		BufferedWriter bw=new BufferedWriter(new FileWriter(htmlfile));
		bw.write(s);
		br.close();
		bw.close();
	}

}
