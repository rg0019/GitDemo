package Sec19_project.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project.AbastractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutElement;

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;

	public Boolean VerifyOrderDisplay(String productName) {
		Boolean match = productNames.stream()
				.anyMatch(product -> product.getText().trim().equalsIgnoreCase(productName.trim()));
		return match;
	}

}
