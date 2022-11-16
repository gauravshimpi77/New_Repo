package testScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLoginPage extends SeleniumUtility {

	@Test
	public static void HomePage() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String url = "https://zbit-us.zineone.com/c3";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // feature of selenium4

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

		WebElement homeDashboard = driver.findElement(By.xpath("//div[@class='c3_pgCTtl']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(homeDashboard));

		WebElement data = driver.findElement(By.xpath("//div[@data-dojo-attach-point='_dp_menu_data']"));
		data.click();

		WebElement events = driver.findElement(By.xpath("//div[@data-dojo-attach-point='_dp_dtMenu_dtIncomingEvts']"));
		events.click();

		WebElement manageEventsStrip = driver.findElement(By.xpath("//div[@data-dojo-attach-point='_tabsCont']"));

		WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait01.until(ExpectedConditions.elementToBeClickable(manageEventsStrip));

		List<WebElement> featureStrip = driver
				.findElements(By.xpath("//div[@class='c3_incEvtListBar c3_align_center c3_pd_16 c3_pd-v_0b']/div/div"));

		for (int i = 0; i < featureStrip.size(); i++) {

			System.out.println("Create New Button :" + featureStrip.get(i).getAttribute("data-dojo-attach-point"));

			System.out.println(" is Displayed :" + featureStrip.get(i).isDisplayed());

			System.out.println(" is Enabled :" + featureStrip.get(i).isEnabled());

		 //	System.out.println(" is Selected :" + featureStrip.get(i).isSelected());
		}
	}
}
