package Event;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;

public class UnableToCreateEvent extends SeleniumUtility {

	/**
	 * TC-EVT-0104 : Verify that event cannot be created with name ab.cd
	 */

	@BeforeTest
	public void preCondition() throws IOException {
		setUp("chrome", "https://zbit-us.zineone.com/c3");
		login();
	}

	@Test
	public void unableToCreateEvent() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='c3_pgCTtl']")));

		WebElement data = driver.findElement(By.xpath("//div[@data-dojo-attach-point='_dp_menu_data']"));
		data.click();
		
		WebElement events = driver.findElement(By.xpath("//div[@data-dojo-attach-point='_dp_dtMenu_dtIncomingEvts']"));
		events.click();

		Thread.sleep(1000);

		WebElement createNewEvent = driver.findElement(By.cssSelector("[data-dojo-attach-point=createEventAttribute]"));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.elementToBeClickable(createNewEvent));

		Thread.sleep(3000);

		createNewEvent.click();

		WebElement uniqueName = driver.findElement(By.xpath("//input[@placeholder='Unique Event Name']"));

		WebElement displayName = driver.findElement(By.xpath("//input[@placeholder='Display Name']"));

		uniqueName.sendKeys("ab.cd");

		displayName.sendKeys("TrialEventUsingAutomation02");

		WebElement Save = driver.findElement(By.xpath("//div[@class='c3_btn btn-n btn-primary btn-fx npc_h']"));

		Save.click();

		String popUpMessege = driver.findElement(By.xpath("//div[@data-dojo-attach-point='_content']")).getText();

		System.out.println("Pop_up Message : " + popUpMessege);

		String ActualMessage = popUpMessege;

		String expectedMessage = "Invalid name";
		Assert.assertTrue(ActualMessage.contains(expectedMessage));

	}

	@AfterTest
	public void postCondition() {
		driver.quit();
	}
}
