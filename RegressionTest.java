package testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TasksPage;
import utilities.BaseClass;
import utilities.ExcelLib;

@Listeners(utilities.Screenshots.class)
public class RegressionTest extends BaseClass{
	@Test
	public void createCustomerTest() throws Exception
	{
		HomePage hp = PageFactory.initElements(BaseClass.driver, HomePage.class);
		hp.navigateToTask();
		Thread.sleep(3000);
//		Assert.assertEquals(BaseClass.driver.getTitle(), "actiTIME -  Task List", "Title is not matching");
		Reporter.log("Navigated to Tasks page", true);
		
		ExcelLib exe = new ExcelLib();
		String name = exe.readStringData("Customer", 14, 0);
		TasksPage tp = PageFactory.initElements(BaseClass.driver, TasksPage.class);
		tp.createCustomer(name);
		Reporter.log("Customer created successfully", true);
		Thread.sleep(4000);
	}
	
	@Test
	public void deleteCustomer() throws Exception {
		HomePage hp = PageFactory.initElements(BaseClass.driver, HomePage.class);
		hp.navigateToTask();
		Thread.sleep(3000);
//		Assert.assertEquals(BaseClass.driver.getTitle(), "actiTIME -  Task List", "Title is not matching");
		Reporter.log("Navigated to Tasks page", true);
		ExcelLib exe = new ExcelLib();
		String name = exe.readStringData("Customer", 14, 0);
		TasksPage tp = PageFactory.initElements(BaseClass.driver, TasksPage.class);
		tp.deleteCustomer(name);
	}
}