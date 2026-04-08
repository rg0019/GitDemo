package Sec19_project.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import project.AbastractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// Intitialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory Element is FindBy
	@FindBy(id = "userEmail")
	WebElement userEmail;
	@FindBy(id = "userPassword")
	WebElement Password;
	@FindBy(id = "login")
	WebElement submit;
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public ProductCatalogue login(String email, String password) {
		userEmail.sendKeys(email);
		Password.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	public String getErrorMessage() {
		waitForwebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}