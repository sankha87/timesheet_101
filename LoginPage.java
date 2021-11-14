package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;
import utilities.SeleniumUtils;

public class LoginPage {
	@FindBy(id="username")
	public WebElement userNameTxtBox;
	
	@FindBy(name="pwd")
	public WebElement passwordTxtBox;
	
	@FindBy(id="loginButton")
	public WebElement loginBtn;
	
	/*
	 * This method is to perform login operation
	 * @author = empID
	 * */
	
	public void login() {
		SeleniumUtils.enterValue(userNameTxtBox, Constants.USERNAME);
		SeleniumUtils.enterValue(passwordTxtBox, Constants.PASSWORD);
		loginBtn.click();
	}
}
