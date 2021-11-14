package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.SeleniumUtils;

public class HomePage {
	
	@FindBy(id="logoutLink")
	public WebElement logoutlink;
	
	@FindBy(xpath="//div[text()='Tasks']")
	public WebElement tasksTab;
	
	@FindBy(xpath="//div[@title='All Customers']")
	public WebElement allCustomersTitle;
	
	public void logOut() {
		if(logoutlink.isDisplayed() && logoutlink.isEnabled())
			logoutlink.click();		
	}
	
	public void navigateToTask() {
		tasksTab.click();
	//	SeleniumUtils.waitTillElementVisibile(10, allCustomersTitle);
	}
}