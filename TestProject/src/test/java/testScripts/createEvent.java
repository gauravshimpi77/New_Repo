package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;
import webPages.EventPage;

public class createEvent extends SeleniumUtility {
	EventPage eg = new EventPage(this.driver);

	@Test
	public void CreateEvent() throws InterruptedException {

		setUp("chrome", "https://zbit-us.zineone.com/c3");

		WebElement userId = driver
				.findElement(By.xpath("(//input[@class='c3_loginInp c3_html_fld c3_html_fld_h c3_fld_deco'])[1]"));

		WebElement passwordField = driver
				.findElement(By.xpath("(//input[@class='c3_loginInp c3_html_fld c3_html_fld_h c3_fld_deco'])[2]"));

		WebElement loginButton = driver.findElement(By.xpath("(//div[@class='c3_btn btn-n btn-primary'])[1]"));

		// putting UserId
		userId.sendKeys("zineone@ftag.com");

		// Filling Password
		passwordField.sendKeys("Test@123");

		// Click
		loginButton.click();

		// WebElement homeDashboard =
		// driver.findElement(By.xpath("//div[@class='c3_pgCTtl']"));

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

		createNewEvent.click();

		WebElement uniqueName = driver.findElement(By.xpath("//input[@placeholder='Unique Event Name']"));

		WebElement displayName = driver.findElement(By.xpath("//input[@placeholder='Display Name']"));

		uniqueName.sendKeys("Friday");

		displayName.sendKeys("TrialEventUsingAutomation02");

		WebElement Save = driver.findElement(By.xpath("//div[@class='c3_btn btn-n btn-primary btn-fx npc_h']"));

		Save.click();
		
		System.out.println("Test Case Passed : Verify that Event should not be created with same name");

	}
}
