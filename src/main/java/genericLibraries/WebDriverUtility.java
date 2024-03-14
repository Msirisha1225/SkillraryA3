package genericLibraries;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains reusable methods to perform driver related operations 
 * @author TRACK QSPIDERS
 */

public class WebDriverUtility {
	private static final String TakesScreenshot = null;
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	private Select select;
	
	/**
	 * This method launches the browser  and maximizes it
	 * @param browser
	 * @return
	 */
	public WebDriver launchAndMaximizeBrowser(String browser) {
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid Browser info");
		}
		driver.manage().window().maximize();
		return driver;
	}
	/**
	 * This method is used to navigate to the application
	 * @param url
	 */
	public void navigateToApp(String url) {
		driver.get(url);
	}
	/**
	 * This method is used to wait until element/elements are found
	 * @param time
	 */
	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	/**
	 * This method waits until the element is visible on the web page
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(long time,WebElement element) {
		wait = new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	/**
	 * This method waits until element is enabled to click
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicitWait(WebElement element,long time) {
		wait = new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * This method waits until title of the web page is displayed
	 * @param title
	 * @param time
	 * @return
	 */
	public Boolean explicitWait(String title,long time) {
		 wait = new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.titleContains(title));
		
	}
	
	// *********************CHAPTER 2******************************
	
	
	
	/**
	 * This method is used to mouse hover on an element
	 * @param element
	 */
	public void mouseHoverToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to double click on an element
	 * @param element
	 */
	public  void doubleClick(WebElement element) {
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * This method is used to right click on an element
	 * @param element
	 */
	public void  rightClick(WebElement element) {
		action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method is used to drag and drop on an element
	 * @param element
	 * @param target
	 */
	public void dragAndDrop(WebElement element, WebElement target) {
		action = new Actions(driver);
		action.dragAndDrop(element, target).perform();
	}
	
	// **************Drop Downs*******************
	
	/**
	 * This method is used to select an element from drop down based on index
	 * @param element
	 * @param index
	 */
	public void selectFromDropdown(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method is used to select an element from drop down based on value
	 * @param element
	 */
	public void selectFromDropdown(WebElement element) {
		select = new Select(element);
		select.selectByValue(null);
	}
	/**
	 * This method is used to select an element from drop down based on text
	 * @param element
	 * @param text
	 */
	public void selectFronDropdown(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	//********************ScreenShot********************************
	
	public <JavaUtility> void takeScreenshot(WebDriver driver,JavaUtility jutil,String className) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = ((Object) new File("./Screenshots/"+className+"_"+ jutil)).getCurrentTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
			
		}catch (IOException e) {
			e.
		}
	}
}

