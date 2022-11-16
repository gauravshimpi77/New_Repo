package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	 WebDriver driver;

	public LoginPage(WebDriver d) {
		driver = d;
	}

	 By userId = By.xpath("(//input[@class='c3_loginInp c3_html_fld c3_html_fld_h c3_fld_deco'])[1]");

	By passwordField = By.xpath("(//input[@class='c3_loginInp c3_html_fld c3_html_fld_h c3_fld_deco'])[2]");

	By loginButton = By.xpath("(//div[@class='c3_btn btn-n btn-primary'])[1]");

	public void enterUserId(String username) {
		driver.findElement(userId).sendKeys(username);

	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);

	}

	public void clickOnLogin() {
		driver.findElement(passwordField).click();

	}

}
