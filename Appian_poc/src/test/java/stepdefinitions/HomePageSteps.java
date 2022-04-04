package stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.qa.util.ConfigReader;
import com.qa.util.Util;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;

public class HomePageSteps {

	HomePage homePage;
	WebDriver driver;
	String PRODUCT = "apple iphone 13";
	ConfigReader configReader;
	Properties prop;
	String Actual;
	String Expected;

	@Given("^I launch Chrome Browser$")
	public void i_launch_chrome_browser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Given("user is on Login page")
	public void user_is_on_home_page()

	{
		homePage = new HomePage(driver);
		System.out.println("i am on home page ");

	}

	@When("User Enter UserName")
	public void user_enter_user_name() throws InterruptedException {

		configReader = new ConfigReader();
		prop = configReader.init_prop();
		String UserName = prop.getProperty("phonenumber");

		homePage.EnterUsername(UserName);

	}

	@When("I click on continue button")
	public void i_click_on_continue_button() {

		homePage.submit();
	}

	@When("I click on signin button")
	public void i_click_on_signin_button() {
		homePage.Sign_in();
	}

	@When("User Enter Password")
	public void user_enter_password() {
		String Password = prop.getProperty("password");
		homePage.EnterPassword(Password);

	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		homePage.submit();
	}

	@Then("I should see Home Page")
	public void i_should_see_home_page() {

		homePage.Amazon_Logo();
	}

	@When("I search product")
	public void i_search_product() {
		homePage.Search_product_name(PRODUCT);
	}

	@Then("I verfiy List of product")
	public void i_verfiy_list_of_product()

	{
		homePage.verify_test();

	}

	@When("I click on List of product")
	public void i_click_on_list_of_product() {
		homePage.getfirstproducttext();
		homePage.click_product();
	}

	@Then("I verify The product selected")
	public void i_verify_the_product_selected() 
	{

		homePage.compareProducts();
	}

	@When("I click on buynow")
	public void i_click_on_buynow() {
		homePage.Buynow();
	}

	@Then("I should see address details screen")
	public void i_should_see_address_details_screen() {
		
		homePage.Address_page();
	}
}
