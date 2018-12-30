package pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.library.common.DriverClass;
import com.login.or.HomePage;
import com.login.or.Loginpage;

public class Pageobject {
	
	
		//public static WebDriver d;
		public static HomePage hobj=null;
		
		public static Loginpage lobj=null;
		public static void pom()
		{
			hobj=PageFactory.initElements(DriverClass.d, HomePage.class);
			
			lobj=PageFactory.initElements(DriverClass.d, Loginpage.class);
			
			
			
			
			
		}
	}



