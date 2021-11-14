package utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	public static void pageload(long time) {
			BaseClass.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public static void selectOptionByIndex(WebElement e, int index) {
			Select s = new Select(e);	
			s.selectByIndex(index);
	}
	public static void selectOptionByText(WebElement e, String text) {
			Select s = new Select(e);
			s.selectByVisibleText(text);
	}
	public static void mouseHovering(WebElement e) {
			Actions act = new Actions(BaseClass.driver);	
			act.moveToElement(e).perform();
	}
	public static void enterValue(WebElement e, String text) {
			if(e.isDisplayed() && e.isEnabled())
				e.sendKeys(text);
	}
	
	
	
	
	public static void pressEnter() {
			Actions act = new Actions(BaseClass.driver);
			act.sendKeys(Keys.ENTER).perform();
	}
	public static void pressTab() {
			Actions act = new Actions(BaseClass.driver);
			act.sendKeys(Keys.TAB).perform();
	}
	public static void pressEsc() {
			Actions act = new Actions(BaseClass.driver);
			act.sendKeys(Keys.ESCAPE).perform();
	}
	
	
	
	
	public static void acceptAlert() {
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.accept();
	}
	public static void dismissAlert() {
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.dismiss();
	}
	public static String getAlertMsg() {
		Alert alt = BaseClass.driver.switchTo().alert();
		return alt.getText();
	}
	
	
	
	
	
	public static void waitTillElementVisibile(int time, WebElement e) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, time);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	public static void waitForElementToBeClickableAndClick(int time, WebElement e) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();
	}
	public static void waitForStalenessOfAndClick(int time, By by) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(by)).click();
	}
	
	public static void waitForInvisibilityOfElementLocated(int time, By by) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}	// if we are using By as an argument, then we cannot perform click operation
	
	public static void waitForStalenessAndClick(int time, WebElement e) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, time);
		wait.until(ExpectedConditions.stalenessOf(e)); // it will look for the element
	}	// if we are using By as an argument, then we cannot perform click operation					
	
	
	
	
	
	public static Dimension getElementSize(WebElement e) {
		return e.getSize();
	}
	public static Point getElementPoint(WebElement e) {
		return e.getLocation();
	}
	public static Rectangle getRectangleDetails(WebElement e) {
		return e.getRect();
	}
	
	
	
	
	public static String getPageTitle() {
		String title = BaseClass.driver.getTitle();
		return title;
	}
	public static String getCurrentURLFromBrowser() {
		String url = BaseClass.driver.getCurrentUrl();
		return url;
	}
	public static String getAttributeOfWebElement(WebElement e, String attrib) {
		return e.getAttribute(attrib);
	}
	
	
	
	
	
	public static void mouseDragAndDrop(WebElement src, WebElement des) {
		Actions act = new Actions(BaseClass.driver);
		act.dragAndDrop(src, des).perform();
	}
	public static void mouseRightClick(WebElement src) {
		Actions act = new Actions(BaseClass.driver);
		act.contextClick(src).perform();
	}
	
	
	
	public static List<WebElement> fetchOptions(WebElement src){
		Select s = new Select(src);
		return s.getOptions();
	}
	public static List<WebElement> fetchAllSelectedOptions(WebElement src){
		Select s = new Select(src);
		return s.getAllSelectedOptions();
	}
	public static WebElement fetchFirstSelectedOption(WebElement src) {
		Select s = new Select(src);
		return s.getFirstSelectedOption();
	}
	
	
	
	
	public static void switchToFrameIndex(int index) {
		BaseClass.driver.switchTo().frame(index);
	}
	public static void switchToFrameName(String name) {
		BaseClass.driver.switchTo().frame(name);
	}
	public static void switchToFrameWebElement(WebElement w) {
		BaseClass.driver.switchTo().frame(w);
	}
	public static void switchToFrameDefault() {
		BaseClass.driver.switchTo().defaultContent();
	}
}
