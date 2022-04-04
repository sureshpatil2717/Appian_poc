package pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.qa.util.Util;

public class HomePage {
	WebDriver driver;
	String PRODUCT = "apple iphone 13";
	Util util;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='ap_password']")

	WebElement password;

	@FindBy(xpath = "//*[@id=\"continue\"]")

	WebElement Continue_button;

	@FindBy(xpath = "//*[@id='ap_email']")

	WebElement Phonenumber;

	@FindBy(xpath = "//*@id='add-to-cart-button']")
	WebElement Add_cart;

	@FindBy(xpath = "(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")
	WebElement click_on_product;

	@FindBy(xpath = "//*[@id=\"signInSubmit\"]")
	WebElement Signin;

	@FindBy(xpath = "//*[@href=\"/-/en/ref=nav_logo\"]")
	WebElement Logo;
	
	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	WebElement Search_product;
	
	@FindBy(xpath = "//*[@class='a-size-large product-title-word-break']")
	WebElement SelectedProduct;
	
	@FindBy(xpath = "//*[@id='buy-now-button']")
	WebElement Click_buynow;
	
	@FindBy(xpath = "//*[text()='Select a delivery address']")
	WebElement Address_page;
	
	
	
	
	String firstValue;

	public void EnterUsername(String name) throws InterruptedException {

		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(Phonenumber));
		Phonenumber.sendKeys(name);

	}

	public void EnterPassword(String name) {
		password.sendKeys(name);

	}

	public void Buynow() {
		
		Click_buynow.click();

	}
	
	public void Address_page()
	{
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(Address_page));
		Address_page.isDisplayed();
	}
	public void submit() {
		Continue_button.click();

	}

	public void Sign_in() {
		Signin.click();

	}

	public void click_on_Iphone() {
		click_on_product.click();
	}

	public void Add_cart() {
		Add_cart.click();

	}
	public void Amazon_Logo() {
		util = new Util();
		util.explicit_wait(driver, Logo);
		Logo.isDisplayed();

	}
	public void Search_product_name(String name)
	{
		Search_product.click();
		Search_product.sendKeys(name);
		Search_product.sendKeys(Keys.ENTER);
	}
	

	public void verify_test() {
		try {

			List<WebElement> After = driver
					.findElements(By.xpath("//*[@class=\"a-size-medium a-color-base a-text-normal\"]"));

			System.out.println(After.size());
			for (int i = 0; i < After.size(); i++) {
				String temp = After.get(i).getText();
				SoftAssert Assert = new SoftAssert();
				if ((temp.toLowerCase().contains(PRODUCT.toLowerCase()))) {
					Assert.assertTrue(true);
					System.out.println(PRODUCT + " is displayed on Product Title: " + temp);
					Assert.assertTrue(true, PRODUCT + " is displayed on  Product Title: " + temp);

				} else {
					Assert.assertTrue(false, PRODUCT + " is not displayed on Product Title: " + temp);

				}

			}

		} catch (Exception e) {
			Assert.assertTrue(false);

		}

	}
	
	public void click_product()
	{
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(click_on_product));
		click_on_product.click();
	}
	
	public String getfirstproducttext() {
		firstValue = click_on_product.getText();
		return firstValue;
	}
	
	public void compareProducts() {
		String secondValue = SelectedProduct.getText();
		System.out.println(firstValue);
		System.out.println(secondValue);
		Assert.assertEquals(firstValue, secondValue);
	}
	
	

}
