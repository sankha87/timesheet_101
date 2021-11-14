package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pages.HomePage;
import pages.LoginPage;

public class BaseClass {
  public static WebDriver driver;
  @Parameters({"browser"})
  @BeforeClass				// preconditions
  public void launchBrowser(String browser) {
	  if(browser.equalsIgnoreCase("Chrome")){
System.setProperty("webdriver.chrome.driver", "C:\\browser drivers\\chromedriver.exe");
 		 driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("Firefox")) {
System.setProperty("webdriver.gecko.driver", "C:\\browser drivers\\geckodriver.exe");
	 	 driver = new FirefoxDriver();
	  }
	  else if(browser.equalsIgnoreCase("Edge")) {
System.setProperty("webdriver.edge.driver", "C:\\browser drivers\\edgedriver.exe");
	 	 driver = new EdgeDriver();
	  }
	  else {
System.setProperty("webdriver.chrome.driver", "C:\\browser drivers\\chromedriver.exe");
	 	 driver = new ChromeDriver();
	  }
driver.get(Constants.URL);
SeleniumUtils.pageload(20);
  }
  
  
@BeforeMethod
public void loginToApp() {
	LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
	lp.login();
	Reporter.log("Login success", true);
}

@AfterMethod
public void logOutFromApp() {
	HomePage hp = PageFactory.initElements(driver, HomePage.class);
	hp.logOut();
	Reporter.log("Logout success", true);
}
  
  
  
  @AfterClass
  public void tearDown() {
	  driver.manage().deleteAllCookies();
	  driver.quit();
  }
	
}
