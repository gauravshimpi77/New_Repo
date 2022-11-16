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

public class ShowAllEvents extends SeleniumUtility {

	/**
	 * TC-EVT-0078 - Verify that all events are showing when "Show all events"
	 * filter is selected
	 */

	@BeforeTest
	public void preCondition() throws IOException {

		setUp("chrome", "https://zbit-us.zineone.com/c3");
		login();

	}

	@Test(priority = 1)
	public void Test_ShowAllEvents() throws InterruptedException {

		// WebElement homeDashboard =
		// driver.findElement(By.xpath("//div[@class='c3_pgCTtl']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

		WebElement clearButton = driver
				.findElement(By.xpath("//div[@class='c3_txt_lnk1 c3_fs14 c3_btn c3_rows_nowrap btn-lbl c3_pd_4v']"));
		clearButton.click();

		WebElement ApplyButton = driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
		ApplyButton.click();

		List<WebElement> AllEvents = driver.findElements(
				By.xpath("//div[@class='c3_lvIncEvtTtl c3_lvTtl c3_text_ellipsis c3_txt_blue2 c3_txt_lnk']"));

		for (int i = 0; i < AllEvents.size(); i++) {

			System.out.println("List of Events : " + AllEvents.get(i).getText());

		}

	}

	@Test(priority = 2)
	public void testDisabledEvents() throws InterruptedException {

		/**
		 * TC-EVT-0079 - Verify that only disabled events are showing when "Show
		 * disabled events" filter is selected
		 */

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[@class='c3_pgCTtl']")));
		 */

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

		WebElement DisabledButton = driver.findElement(By.xpath("//input[@data-fld-value='Disabled']"));
		DisabledButton.click();

		WebElement ApplyButton = driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
		ApplyButton.click();

		List<WebElement> listOfDisabled = driver.findElements(
				By.xpath("//div[@class='c3_lvIncEvtTtl c3_lvTtl c3_text_ellipsis c3_txt_blue2 c3_txt_lnk']"));

		for (int i = 0; i < listOfDisabled.size(); i++) {

			System.out.println("List of Disabled Event : " + listOfDisabled.get(i).getText());

		}
		System.out.println("Disabled Events are coming as Expected. ");

		Reporter.log("Disabled Events are coming as Expected. ");

	}

	@Test(priority = 3)
	public void testEnabledEvents() throws InterruptedException {

		/**
		 * TC-EVT-00 - Verify that only Enabled events are showing when "Show Enabled
		 * events" filter is selected
		 */

		// WebElement homeDashboard =
		// driver.findElement(By.xpath("//div[@class='c3_pgCTtl']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

	@Test(priority = 4)
	public void Test_EnrichedCode() throws InterruptedException {

		/**
		 * 
		 * TC-EVT-0080 : Verify that only Enriched events are showing when "Show
		 * Enriched events" filter is selected
		 */

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

			System.out.println("List of Enriched Event : " + listOfEnriched.get(i).isDisplayed());

		}

		System.out.println("Enriched Events are : " + listOfEnriched.size());

		System.out.println("Enriched Events are coming as Expected.");

		Reporter.log("Enriched Events are coming as Expected. ");

	}

	@Test(priority = 5)
	public void Test_SuspendedEvents() throws InterruptedException {

		/**
		 * TC-EVT-0081 - Verify that only suspended events are showing when "Show
		 * suspended events" filter is selected
		 */

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
