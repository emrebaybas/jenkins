package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class StepDefinition {
	ChromeDriver driver;

	@Given("^User is on landing page$")
	public void user_is_on_landing_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//emrba//OneDrive//Masaüstü//Drivers//WebDrivers//chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("landing page is displayed");
	}

	@When("^User login into application with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_login_into_application_with_username_something_and_password_something(String strArg1,
			String strArg2) throws Throwable {

		driver.findElement(By.id("txtUsername")).sendKeys(strArg1);
		driver.findElement(By.id("txtPassword")).sendKeys(strArg2);
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("login successful");
	}

	@Then("^Home page is populated$")
	public void home_page_is_populated() throws Throwable {
		System.out.println("on the home page");
	}

	@And("^Cards are displayed$")
	public void cards_are_displayed() throws Throwable {
		System.out.println("cards are displayed");
	}

	@Then("^Error message is populated$")
	public void error_message_is_populated() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials"));
		System.out.println("Invalid credentials message is displayed");
	}

}
