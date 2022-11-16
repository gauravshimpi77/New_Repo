package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtility {

	public static WebDriver driver;
	protected static Properties properties;
	protected static Actions act;
	protected static String filePath;
	protected static WebDriverWait wait;
	protected static FileInputStream fis;
	protected static TakesScreenshot ts;

	public WebDriver setUp(String browserName, String appURL) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(appURL);
		return driver;
	}

	/*
	 * 
	 * // public static WebDriver getDriver() { // // return driver; // }
	 * 
	 */
	public void login() throws IOException {
		FileInputStream fis = new FileInputStream("./src/main/resources/testData/testData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String uName=prop.getProperty("userName");
		String pwd=prop.getProperty("password");
		WebElement userId = driver
				.findElement(By.xpath("(//input[@class='c3_loginInp c3_html_fld c3_html_fld_h c3_fld_deco'])[1]"));

		WebElement passwordField = driver
				.findElement(By.xpath("(//input[@class='c3_loginInp c3_html_fld c3_html_fld_h c3_fld_deco'])[2]"));

		userId.sendKeys(uName);
		passwordField.sendKeys(pwd);

		WebElement loginButton = driver.findElement(By.xpath("(//div[@class='c3_btn btn-n btn-primary'])[1]"));

		loginButton.click();

//		return prop;
	}

	public void waitForElementDisplayed(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	public void typeInput(WebElement element, String input) {
		waitForElementDisplayed(element);
		element.clear();
		element.sendKeys(input);
	}

	public void performDragAndDrop(WebElement source, WebElement target) {
		act.dragAndDrop(source, target).build().perform();
	}

	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickOnElement(WebElement element) {
		waitForElementToBeClickable(element);
		element.click();
	}

	public void performMouseOver(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void performRightClickOperation(WebElement element) {
		act.moveToElement(element).contextClick(element).build().perform();
	}

	public static void takeScreenshotOfThePage(String location) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(location));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isElementExist(WebElement element) {
		waitForElementDisplayed(element);
		System.out.println("this " + element + " is Present.");
		return element.isDisplayed();
	}

	public boolean isCheckBoxSelected(WebElement element) {
		waitForElementDisplayed(element);
		return element.isSelected();
	}

}
