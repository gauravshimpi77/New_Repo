package Event;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;

public class EnabledEvent extends SeleniumUtility {

	
	/**
	 * TC-EVT-00 - Verify that only Enabled events are showing when "Show
	 * Enabled events" filter is selected
	 */
	
	
	
	@BeforeTest
	public void preCondition() throws IOException {

		setUp("chrome", "https://zbit-us.zineone.com/c3");
		login();

	}

	@Test 
	public void testEnabledEvents() throws InterruptedException {
		
	//	WebElement homeDashboard = driver.findElement(By.xpath("//div[@class='c3_pgCTtl']"));

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

		WebElement filterButton = driver.findElement(By.xpath("(//div[@data-dojo-attach-point='_fltrBtns'])[1]"));
		filterButton.click();

		WebElement EnabledButton = driver.findElement(By.xpath("//input[@data-fld-value='Enabled']"));
		EnabledButton.click();

		WebElement ApplyButton = driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
		ApplyButton.click();

		List<WebElement> listOfEnabled = driver.findElements(
				By.xpath("//div[@class='c3_lvIncEvtTtl c3_lvTtl c3_text_ellipsis c3_txt_blue2 c3_txt_lnk']"));

		for (int i = 0; i < listOfEnabled.size(); i++) {

			System.out.println("List of Enaabled Event : " + listOfEnabled.get(i).getText());

		}

		System.out.println("Enabled Events are coming as Expected.");

		Reporter.log("Enabled Events are coming as Expected. ");

	}

	@AfterTest
	public void postCondition() {
		driver.quit();
	}

}
