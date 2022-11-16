package TriggerExperiences;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;

public class TC_TIA_0047 extends SeleniumUtility {

	// Verify that length of TI name is limited

	@Test
	public void TI_NameLength_Test() {
		setUp("chrome", "https://zbit-us.zineone.com/c3");

		WebElement userId = driver
				.findElement(By.xpath("(//input[@class='c3_loginInp c3_html_fld c3_html_fld_h c3_fld_deco'])[1]"));

		WebElement passwordField = driver
				.findElement(By.xpath("(//input[@class='c3_loginInp c3_html_fld c3_html_fld_h c3_fld_deco'])[2]"));

		WebElement loginButton = driver.findElement(By.xpath("(//div[@class='c3_btn btn-n btn-primary'])[1]"));

		userId.sendKeys("zineone@ftag.com");

		passwordField.sendKeys("Test@123");
		
		loginButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='c3_pgCTtl']")));
		
		WebElement experiences = driver.findElement(By.xpath("//div[@data-dojo-attach-point='_dp_menu_experience']"));
		
		experiences.clear();
		
		WebDriverWait waitTI = new WebDriverWait(driver, Duration.ofSeconds(20));
		waitTI.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), 'Triggered Experiences')])[2]")));
		
		WebElement TriggeredExperiences = driver.findElement(By.xpath("(//*[contains(text(), 'Triggered Experiences')])[2]"));
		
		TriggeredExperiences.click();
		
		
	}

}
