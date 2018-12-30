package module1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.library.common.DriverClass;

public class Prog2 extends BaseClass {
	
	@DataProvider()
	public Object[][] getData() throws Exception
	{
		String[][] data=elib.getTableArray("xxxx", "xxxxxx");
		
		return data;
		
	}
	//added
	@Test(priority=-1)
	public void loginTest() throws Exception
	{
		slog.startTest(htmlreport,sc.stepNumber(),this.getClass().getSimpleName());
		DriverClass.d.get(url);
		System.out.println("browser launched");
		slog.passStep("Browser Launched", resultPath);
		System.out.println("browser launched");
		obj.hobj.txt_uid().sendKeys("xxxx");
		
		slog.passStep("User name Ente'xxxred", resultPath);
		obj.hobj.txt_pass().sendKeys("xxxx");
		slog.passStep("Password Entered", resultPath);
		//obj.hobj.btn_login().click();
		slog.passStep("Login button clicked", resultPath);
		
		
		slog.endTest();
	}
	@Test()
	public void createAccount() throws Exception
	{
		slog.startTest(htmlreport,sc.stepNumber(),this.getClass().getSimpleName());
		DriverClass.d.get(url);
		
		slog.passStep("Browser Launched", resultPath);
		obj.hobj.txt_uid().sendKeys("xxxx");

		obj.lobj.txt_firstname().clear();
		obj.lobj.txt_firstname().sendKeys("Anji");
		
		slog.passStep("First name entered", resultPath);
		
		obj.lobj.txt_createpwd().clear();
		obj.lobj.txt_createpwd().sendKeys("xxxx");
		slog.passStep("new pwd entered", resultPath);
		
		slog.endTest();
	
	}

}
