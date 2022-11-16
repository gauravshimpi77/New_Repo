package Event;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;

public class TCEVT0082 extends SeleniumUtility {

	/**
	 * TC-EVT-0082 Verify that Enrichment Code is opening when we click on the
	 * Status Icon of Suspended Events
	 */
	@BeforeTest
	public void preCondition() throws IOException {

		setUp("chrome", "https://zbit-us.zineone.com/c3");
		login();

	}

	@Test
	public void Test_EnrichedCodeStatusIcon() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='c3_pgCTtl']"))));

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
		System.out.println(+listOfEvents.size() + " : are there.");

		WebElement filterButton = driver.findElement(By.xpath("(//div[@data-dojo-attach-point='_fltrBtns'])[1]"));
		filterButton.click();

		WebElement EnrichedButton = driver.findElement(By.xpath("//input[@data-fld-value='Enriched']"));
		EnrichedButton.click();

		WebElement ApplyButton = driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
		ApplyButton.click();

		List<WebElement> listOfEnriched = driver.findElements(
				By.xpath("//div[@class='c3_lvIncEvtTtl c3_lvTtl c3_text_ellipsis c3_txt_blue2 c3_txt_lnk']"));

		for (int i = 0; i < listOfEnriched.size(); i++) {

			System.out.println("List of Enriched Event : " + listOfEnriched.get(i).getText());

		}

		WebElement suspendedEvent = driver.findElement(By.xpath(
				"//div[@class='c3_lvIncEvtStatus c3_flex_center_1 btn-icn-sq-no-bdr btn-icn-sq-26 c3_btn c3-c-red50']"));

		suspendedEvent.click();

		WebElement customProcessingScript = driver.findElement(By.xpath("(//div[@class='c3_sxn_h'])[3]"));

		if (customProcessingScript.isDisplayed()) {
			System.out.println("we click on the Status Icon of Suspended Events, its showing Processing script.");
		} else {
			System.out.println("custom processing script is not displayed.");
		}
	}

	@AfterTest
	public void postCondition() {
		driver.close();
	}

}
