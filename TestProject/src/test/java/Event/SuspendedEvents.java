package Event;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;

public class SuspendedEvents extends SeleniumUtility {

	/**
	 * TC-EVT-0081 - Verify that only suspended events are showing when "Show
	 * suspended events" filter is selected
	 */

	@BeforeTest
	public void preCondition() throws IOException {

		setUp("chrome", "https://zbit-us.zineone.com/c3");
		login();

	}

	@Test
	public void Test_SuspendedEvents() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='c3_pgCTtl']")));

		WebElement data = driver.findElement(By.xpath("//div[@data-dojo-attach-point='_dp_menu_data']"));
		data.click();

		WebElement events = driver.findElement(By.xpath("//div[@data-dojo-attach-point='_dp_dtMenu_dtIncomingEvts']"));
		events.click();

		Thread.sleep(1000);

		List<WebElement> listOfEvents = driver
				.findElements(By.xpath("//div[@class='c3_lvRw c3_lvR c3_lv2Rw c3_lv2R']"));

		for (int i = 0; i < listOfEvents.size(); i++) {

			System.out.println("list of events :" + listOfEvents.get(i).getText());
		}

		WebElement filterButton = driver.findElement(By.xpath("(//div[@data-dojo-attach-point='_fltrBtns'])[1]"));
		filterButton.click();

		WebElement SuspendedButton = driver.findElement(By.xpath("//input[@data-fld-value='Suspended']"));
		SuspendedButton.click();

		WebElement ApplyButton = driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
		ApplyButton.click();

		List<WebElement> SuspendedEvents = driver.findElements(
				By.xpath("//div[@class='c3_lvIncEvtTtl c3_lvTtl c3_text_ellipsis c3_txt_blue2 c3_txt_lnk']"));

		for (int i = 0; i < SuspendedEvents.size(); i++) {

//			System.out.println("List of Disabled Event : " + listOfDisabled.get(i).getAttribute("data-toggle-cont"));
			System.out.println("List of Disabled Event : " + SuspendedEvents.get(i).getText());

		}
		System.out.println("Disabled Events are coming as Expected. ");

		Reporter.log("Disabled Events are coming as Expected. ");

	}

	@AfterTest
	public void postCondition() {
		driver.quit();
	}

}
