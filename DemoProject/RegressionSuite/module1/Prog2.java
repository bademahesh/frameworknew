package module1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.library.common.DriverClass;

public class Prog2 extends BaseClass {
	
	@DataProvider(name="logindata")
	public Object[][] getData() throws Exception
	{
		String[][] data=elib.getTableArray("xxxx", "xxxxxx");
		
		return data;
		
	}
	@DataProvider(name="basicsearchdata")
	public Object[][] getData2() throws Exception
	{
		String[][] data=elib.getTableArray("xxxx", "xxxxxx");
		
		return data;
		
	}
	
	@Test(dataProvider="basicsearchdata")
	public void loginTest(String uname,String pwd) throws Exception
	{
		slog.startTest(htmlreport,sc.stepNumber(),"TestCase");
		DriverClass.d.get(url);
		slog.passStep("Browser Launched", resultPath);
		obj.hobj.txt_uid().sendKeys(uname);
		slog.passStep("User name Entered", resultPath);
		obj.hobj.txt_pass().sendKeys(pwd);
		slog.passStep("Password Entered", resultPath);
		obj.hobj.btn_login().click();
		slog.passStep("Login button clicked", resultPath);
		slog.endTest();
	}
	

}
