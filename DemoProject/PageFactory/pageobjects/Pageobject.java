package pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.library.common.DriverClass;
import com.login.or.HomePage;

public class Pageobject {
	
	
		//public static WebDriver d;
		public static HomePage hobj=null;
		public static void pom()
		{
			hobj=PageFactory.initElements(DriverClass.d, HomePage.class);
			
		}
	}



