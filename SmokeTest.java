package testScripts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.BaseClass;

@Listeners(utilities.Screenshots.class)
public class SmokeTest extends BaseClass{
	@Test
	public void ST() throws InterruptedException {
		Thread.sleep(7000);
		Reporter.log("Smoke test executed", true);
	}
}