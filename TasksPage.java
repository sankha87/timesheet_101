package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.BaseClass;
import utilities.SeleniumUtils;
// all the business logic will be available in Page class
public class TasksPage {
	
	@FindBy(xpath="//div[text()='Add New']")
	public WebElement addNewBtn;
	
	@FindBy(xpath="//div[contains(text(),'New Customer')]")
	public WebElement newCustomerBtn;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	public WebElement customerNameTxtBox;
	
	@FindBy(xpath="//div[text()='Create Customer']")
	public WebElement createCustomerBtn;
	
	@FindBy(xpath="(//input[@placeholder='Start typing name ...'])[1]")
	public WebElement searchbar;
	
	@FindBy(xpath="(//div[@class='editButton'])[9]")
	public WebElement editBtn;
	
	@FindBy(xpath="(//div[text()='ACTIONS'])[1]")
	public WebElement actionsBtn;
	
	@FindBy(xpath="(//div[text()='Delete'])[2]")
	public WebElement deleteBtn;
	
	@FindBy(xpath="//span[text()='Delete permanently']")
	public WebElement deletePermanent;
	
	public void createCustomer(String customerName) throws InterruptedException{
		addNewBtn.click();
		newCustomerBtn.click();
		Thread.sleep(4000);
		SeleniumUtils.waitTillElementVisibile(10, customerNameTxtBox);
		SeleniumUtils.enterValue(customerNameTxtBox, customerName);
		createCustomerBtn.click();
	}
	
	public void deleteCustomer(String customerName) throws InterruptedException {
		SeleniumUtils.enterValue(searchbar, customerName);
		Thread.sleep(4000);
WebElement e = BaseClass.driver.findElement(By.xpath("//span[text()='"+customerName+"']"));
		SeleniumUtils.mouseHovering(e);
WebElement gearicon=BaseClass.driver.findElement(By.xpath("(//div[text()='"+customerName+"']/following-sibling::div)[2]"));
		SeleniumUtils.waitTillElementVisibile(10, gearicon);
		SeleniumUtils.mouseHovering(gearicon);
		gearicon.click();
		Thread.sleep(3000);
		actionsBtn.click();
		deleteBtn.click();
		deletePermanent.click();
		Thread.sleep(4000);
	}
}
