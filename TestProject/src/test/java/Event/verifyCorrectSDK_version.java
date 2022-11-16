package Event;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;

public class verifyCorrectSDK_version extends SeleniumUtility {

	/**
	 * 
	 * TC-EVT-0090 Verify that, correct SDK Version is sent with the event
	 */

	@BeforeTest
	public void preCondition() throws IOException {
		setUp("chrome", "https://zbit-us.zineone.com/c3");
		login();
	}

	@Test
	public void verifyCorrectSDK() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='c3_pgCTtl']")));

		WebElement watchStreamHomePage = driver.findElement(By.xpath("//div[@data-dojo-attach-point='_watchLive']"));
		watchStreamHomePage.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://fta.zineone.com/sqe/HtmlSDKTestApp/html5/Home.html");

		WebElement apiKeys = driver.findElement(By.id("apikey"));

		String ApiCode = "zbit-us@0d1dccec-3719-4026-8695-d259fdfead70Z18059813029443623776";
		apiKeys.sendKeys(ApiCode);

		WebElement customerId = driver.findElement(By.id("customerId"));
		customerId.sendKeys("user04155");

		WebElement LoginButton = driver.findElement(By.xpath("//button[@onclick='initialize()']"));
		LoginButton.click();

		WebElement nextButton = driver.findElement(By.xpath("//button[@type='submit']"));
		nextButton.click();

		WebElement ManageTagButton = driver.findElement(By.xpath("//div[@id='imgdiv6']"));
		ManageTagButton.click();

		WebElement inputEventName = driver.findElement(By.id("eventname"));
		inputEventName.sendKeys("event1");

		WebElement sendEventButton = driver.findElement(By.xpath("//button[@onclick='sendcustomevent()']"));
		sendEventButton.click();

		String currentWindow = driver.getWindowHandle();
		System.out.println(currentWindow);
		Set<String> allWindows = driver.getWindowHandles();

		for (int i = 0; i < allWindows.size(); i++) {
			System.out.println(allWindows);
		}

		// Now iterate using Iterator
		Iterator<String> I1 = allWindows.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!currentWindow.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
				// driver.close();
			}

		}

		WebElement maximizeButton = driver.findElement(By.xpath("(//div[@class='c3_evtLogXpdIcn c3_fs14'])[1]"));
		maximizeButton.click();

		// driver.findElement(By.xpath("//*[contains(text(),'time')])[1]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement sdkVersion = driver.findElement(By.xpath("//div[@data-i-type='z1SDKVersion']"));

		js.executeScript("arguments[0].scrollIntoView();", sdkVersion);

		System.out.println("this is a Current SDK Version : " + sdkVersion.getText());

		Assert.assertEquals(sdkVersion.getText(), "4.211.2.1-beta", "Test Case Failed.");

	}

	@AfterTest
	public void postCondition() {
		driver.quit();
	}
}
