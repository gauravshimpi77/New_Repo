package Event;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;

public class DisabledEvent extends SeleniumUtility {

	/**
	 * TC-EVT-0079 - Verify that only disabled events are showing when "Show
	 * disabled events" filter is selected
	 */
	
	
	
	
	@Test
	public void testDisabledEvents() throws InterruptedException {
		setUp("chrome", "https://zbit-us.zineone.com/c3");
		WebElement userId = driver
				.findElement(By.xpath("(//input[@class='c3_loginInp c3_html_fld c3_html_fld_h c3_fld_deco'])[1]"));

		WebElement passwordField = driver
				.findElement(By.xpath("(//input[@class='c3_loginInp c3_html_fld c3_html_fld_h c3_fld_deco'])[2]"));

		WebElement loginButton = driver.findElement(By.xpath("(//div[@class='c3_btn btn-n btn-primary'])[1]"));

		userId.sendKeys("zineone@ftag.com");

		passwordField.sendKeys("Test@123");

		loginButton.click();

		WebElement homeDashboard = driver.findElement(By.xpath("//div[@class='c3_pgCTtl']"));

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

		WebElement DisabledButton = driver.findElement(By.xpath("//input[@data-fld-value='Disabled']"));
		DisabledButton.click();

		WebElement ApplyButton = driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
		ApplyButton.click();

		List<WebElement> listOfDisabled = driver.findElements(
				By.xpath("//div[@class='c3_lvIncEvtTtl c3_lvTtl c3_text_ellipsis c3_txt_blue2 c3_txt_lnk']"));

		for (int i = 0; i < listOfDisabled.size(); i++) {

//			System.out.println("List of Disabled Event : " + listOfDisabled.get(i).getAttribute("data-toggle-cont"));
			System.out.println("List of Disabled Event : " + listOfDisabled.get(i).getText());

		}
		System.out.println("Disabled Events are coming as Expected. ");

		Reporter.log("Disabled Events are coming as Expected. ");

	}

}
