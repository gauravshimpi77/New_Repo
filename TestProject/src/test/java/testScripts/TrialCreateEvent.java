package testScripts;

import org.testng.annotations.Test;

import Utilities.SeleniumUtility;
import webPages.LoginPage;

public class TrialCreateEvent extends SeleniumUtility {

	@Test
	public void CreateEvent01() {

		setUp("chrome", "https://zbit-us.zineone.com/c3");
		LoginPage LoginP = new LoginPage(driver);
		LoginP.enterUserId("zineone@ftag.com");
		LoginP.enterPassword("Test@123");
		LoginP.clickOnLogin();

	}

}
