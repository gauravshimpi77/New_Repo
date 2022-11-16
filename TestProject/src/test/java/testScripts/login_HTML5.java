package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login_HTML5 {

	@Test
	public static void login_HTML5() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://fta.zineone.com/sqe/HtmlSDKTestApp/html5/Home.html");

		WebElement apiKeys = driver.findElement(By.id("apikey"));

		String ApiCode = "zbit-us@0d1dccec-3719-4026-8695-d259fdfead70Z18059813029443623776";
		apiKeys.sendKeys(ApiCode);

		WebElement customerId = driver.findElement(By.id("customerId"));
		customerId.sendKeys("user04155");

		// LoginButton
		WebElement LoginButton = driver.findElement(By.xpath("//button[@onclick='initialize()']"));
		LoginButton.click();

		// NextButton
		WebElement nextButton = driver.findElement(By.xpath("//button[@type='submit']"));
		nextButton.click();

		WebElement bannerButton = driver.findElement(By.xpath("//img[@onclick='showBanner()']"));
		bannerButton.click();

	}

}
