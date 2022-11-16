package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class home_Dashboard {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		String url = "https://zbit-us.zineone.com/c3";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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

		// Selecting Desire TimeRange.

		WebElement calender = driver.findElement(By.xpath("(//div[@data-dojo-attach-point='timeRangeBox'])[1]"));

		calender.click();

		WebElement last7days = driver.findElement(By.xpath("(//div[@id='opLast7Days'])"));

		// WebElement today = driver.findElement(By.xpath("//div[@class='day-item
		// is-today is-start-date']"));

		Actions act = new Actions(driver);

		// act.doubleClick(today).perform();

		last7days.click();

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// TotalSessionsPerDay
		String totalSession_day = driver.findElement(By.xpath("(//div[@class='c3_chCrdNum c3_txt_c'])[2]")).getText();
		System.out.println("this is the totalSession_day for last 7 Days = " + totalSession_day);
		Assert.assertEquals(totalSession_day, "8");

		// TotalUsersPerDay
		String totalUsers_day = driver.findElement(By.xpath("(//div[@class='c3_chCrdNum c3_txt_c'])[3]")).getText();
		System.out.println("this is the totalUsers_day for last 7 Days = " + totalUsers_day);
		Assert.assertEquals(totalUsers_day, "4");

		// TotalActionsPerDay
		String totalActions_day = driver.findElement(By.xpath("(//div[@class='c3_chCrdNum c3_txt_c'])[4]")).getText();
		System.out.println("this is the totalActions_day for last 7 Days = " + totalActions_day);
		Assert.assertEquals(totalActions_day, "3");

		// CVR
		String CVR = driver.findElement(By.xpath("(//div[@class='c3_chCrdNum c3_txt_c'])[5]")).getText();
		System.out.println("this is the CVR for last 7 Days = " + CVR);
		Assert.assertEquals(CVR, "28.1%");

		// RPV
		String RPV = driver.findElement(By.xpath("(//div[@class='c3_chCrdNum c3_txt_c'])[6]")).getText();
		System.out.println("this is the RPV for last 7 Days = " + RPV);
		Assert.assertEquals(RPV, "$119");

		String AOV = driver.findElement(By.xpath("(//div[@class='c3_chCrdNum c3_txt_c'])[7]")).getText();
		System.out.println("this is the AOV for last 7 Days = " + AOV);
		Assert.assertEquals(AOV, "$468");
		
		
		
	}

}
