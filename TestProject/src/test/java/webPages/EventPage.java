package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.SeleniumUtility;

public class EventPage extends SeleniumUtility {

	public WebDriver driver;

	public EventPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@data-dojo-attach-point='createEventAttribute']")
	public WebElement createEventButton;

	@FindBy(xpath = "//div[@data-dojo-attach-point='_testEventsBtn']")
	public WebElement injectEventButton;

	@FindBy(xpath = "//div[@data-dojo-attach-point='_eventLogBtn']")
	public WebElement watchStreamButton;

	@FindBy(xpath = "//div[@data-dojo-attach-point='_srchC']")
	public WebElement searchField;

	@FindBy(xpath = "//div[@data-dojo-attach-point='_fltrBtns']")
	public WebElement filterButton;

	public WebElement getCreateEventButton() {
		return createEventButton;
	}

	public WebElement getInjectEventButton() {
		return injectEventButton;
	}

	public WebElement getWatchStreamButton() {
		return watchStreamButton;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getFilterButton() {
		return filterButton;
	}

	public boolean checkElements() {

		isElementExist(getCreateEventButton());
		isElementExist(getFilterButton());
		isElementExist(getInjectEventButton());
		return isElementExist(getWatchStreamButton());
	}

}
