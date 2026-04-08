package Sec19_project.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project.AbastractComponents.AbstractComponent;

//ProductCatalogue inherits all methods from AbstractComponent
public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;

	// Constructor
	public ProductCatalogue(WebDriver driver) {
		// Calls parent constructor
		super(driver);
		// Intitialization
		this.driver = driver;
		// Initializes all @FindBy elements
		PageFactory.initElements(driver, this);
	}

	// PageFactory - Product List
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	// Locators
	By productsList = By.cssSelector(".mb-3");
	By addToCartBtn = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By animation = By.cssSelector(".ng-animating");

	// Method to get product list
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsList);
		return products;
	}

	// Get product by name
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(p -> p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}

	// Add Product to cart
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCartBtn).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(animation);
		waitForSpinnerToDisappear();
	}
}
/*
 * Why both By and @FindBy? Good question — interview favorite 👉 By
 * productslist Used for wait logic, Works with ExpectedConditions 👉 @FindBy
 * products Used for element interaction, Cleaner code via PageFactory
 * 
 */