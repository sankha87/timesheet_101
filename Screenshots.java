package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screenshots implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();	
		EventFiringWebDriver efw = new EventFiringWebDriver(BaseClass.driver);		
		File src = efw.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\eclipse-workspace\\Framework108\\PassedScreen\\"
								+name+System.currentTimeMillis()+".jpeg");
		try {
			FileUtils.copyFile(src, des);
			} catch (IOException e) {
			System.out.println("screenshot not copied");
			e.printStackTrace();
			}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();	
		EventFiringWebDriver efw = new EventFiringWebDriver(BaseClass.driver);		
		File src = efw.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\eclipse-workspace\\Framework108\\FailedScreen\\"
							+name+System.currentTimeMillis()+".jpeg");
		try {
			FileUtils.copyFile(src, des);
			} catch (IOException e) {
				System.out.println("screenshot not copied");
				e.printStackTrace();
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	
	
}
