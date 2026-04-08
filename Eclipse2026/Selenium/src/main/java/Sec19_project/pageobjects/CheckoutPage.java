package Sec19_project.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.AbastractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		// Calls parent constructor
		super(driver);
		// Intitialization
		this.driver = driver;
		// Initializes all @FindBy elements
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action__submit")
	WebElement submit;
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;

	// no webElement
	By results = By.cssSelector(".ta-results");

	public CheckoutPage selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;

	}

	public void submitOrder() {
		submit.click();
		return;

	}

	public String getConfirmationMessage() {
		By confirmationMsg = By.cssSelector(".hero-primary");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMsg));
		return driver.findElement(confirmationMsg).getText();
	}
}
