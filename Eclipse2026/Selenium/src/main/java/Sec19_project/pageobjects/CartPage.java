package Sec19_project.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project.AbastractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		// Calls parent constructor
		super(driver);
		// Intitialization
		this.driver = driver;
		// Initializes all @FindBy elements
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutElement;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;

	public List<WebElement> getCartProducts() {
		return cartProducts;
	}

	public Boolean VerifyingProductDisplay(String productName) {
		Boolean match = cartProducts.stream()
				.anyMatch(product -> product.getText().trim().equalsIgnoreCase(productName.trim()));
		return match;
	}

	public CheckoutPage goToCheckout() {
		// Wait for cart products to appear
		waitForElementToAppear(By.cssSelector(".cartSection h3"));

		// Wait for any spinner to disappear
		waitForSpinnerToDisappear();

		// Use JS click to avoid overlay issues
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutElement);
		return new CheckoutPage(driver);
	}

}