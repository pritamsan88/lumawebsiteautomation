package stepsdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.Carttocheckout;
import pageobjectmodel.RegistrationandLogin;

public class CarttoCheckout {
	
	WebDriver driver=null;
	RegistrationandLogin login;
	Carttocheckout cart;
	
	@Given("Startup browser")
	public void startup_browser() {
		
		System.out.println("Browser is open");	
		String projecturl= System.getProperty("user.dir");
		System.out.println("Project path is "+projecturl);
		System.setProperty("WebDriver.chrome.driver", projecturl+"/src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
	   
	}

	@Given("Go to shopping cart website")
	public void go_to_shopping_cart_website() {
		
		System.out.println("Go to shopping ----------------------------------- cart website");	
		login= new RegistrationandLogin(driver);
		login.projecturl1();
		driver.manage().window().maximize();
		
	    
	}

	@When("Product select from menu")
	public void product_select_from_menu() throws InterruptedException {
		System.out.println("Product select --------------------------------------from menu");
		cart =new Carttocheckout(driver);
		Thread.sleep(2000);
		cart.menuselect1();
		
	    
	}

	@When("Add to cart section")
	public void add_to_cart_section() throws InterruptedException {
		System.out.println("Add to cart ------------------------------------------- section");
		cart.addtocart();
		cart.verifycartcounter();
		Thread.sleep(2000);
	   
	}

	@When("Another product select from menu")
	public void another_product_select_from_menu() throws InterruptedException {
		System.out.println("Another product --------------------------------------- add in the cart");
		//cart.anotherproduct();
		//cart.anotherproductadd();
	   cart.anotherproduct();
	   cart.menproduct();
	   cart.verifycartcounter();
	}

	@When("go to cart section")
	public void go_to_cart_section() {
		
		System.out.println("Next we have to  --------------------------------------- go to cart section");
		cart.cartsection();
	    
	}

	@When("Click on check out option")
	public void click_on_check_out_option() throws InterruptedException {
	   
		System.out.println("Next we have to  --------------------------------------- go to CHeckout section");
		cart.checkoutsection();
		Thread.sleep(2000);
	}

	@When("user sigin their account (.*) and (.*)$")
	public void user_sigin_their_account(String email,String password) throws InterruptedException {
		
		System.out.println("Now --------------------------------------- users enter email and password");
	    cart.withoutlogincheckoutsigninbutton();
	    Thread.sleep(2000);
	    login.checkoutloginfunctionality(email,password);
	    Thread.sleep(2000);
	   
	}

	@When("choose address")
	public void choose_address() throws InterruptedException {
		System.out.println("Choose address----------------------------- and click next button");
		cart.shipping();
	   
	}

	@When("Click on place order")
	public void click_on_place_order() throws InterruptedException {
		
		System.out.println("oreder place---------------order details check-------");
	    cart.reviewpayment();
	}

	@Then("validate order is placed I see confirmation message")
	public void validate_order_is_placed_i_see_confirmation_message() throws InterruptedException {
	    System.out.println("After order place ------------------------ verify alert");
	    cart.afterorderplaceconfirmation();
	    cart.finaladdtocart();
	}

	@Then("Go to my account to order check order details placed or not")
	public void go_to_my_account_to_order_check_order_details_placed_or_not() {
	    
	}

}
