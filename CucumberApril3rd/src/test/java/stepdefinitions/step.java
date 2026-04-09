package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class step {

	@Given("User is on the login page")
	public void checkLoginPage() {
		System.out.println("User is on the login page");
	}

	@When("User enters credentials")
	public void userLogin() {
		System.out.println("User enters credentials");
	}

	@Then("User is on the home page")
	public void homePage() {
		System.out.println("User is on the home page");
	}

	@Given("User is on the Automation Practice Home Page")
	public void automationHome() {
		System.out.println("User is on the Automation Practice Home Page");
	}

	@When("User searches for an item")
	public void search() {
		System.out.println("User searches for an item");
	}

	@Then("Results are displayed on the screen")
	public void results() {
		System.out.println("Results are displayed on the screen");
	}

}
