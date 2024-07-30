package stepsdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.RegistrationandLogin;

public class Registration {
	
	WebDriver driver;
	RegistrationandLogin obj;
	
	
	@Given("browser open")
	public void browser_open() {
		
	System.out.println("Browser is open");	
	String projecturl= System.getProperty("user.dir");
	System.out.println("Project path is "+projecturl);
	System.setProperty("WebDriver.chrome.driver", projecturl+"/src/test/resources/driver/chromedriver.exe");
	driver=new ChromeDriver();
	
	}

	@Given("Go to proper Url")
	public void go_to_proper_url() {
		
		System.out.println("Go to project Url"); 
		obj=new RegistrationandLogin(driver);
		obj.projecturl();
	}

	@When("Users enters details (.*) and (.*)$")
	public void  users_enters_details(String FirstName,String LastName) throws InterruptedException {
		
		System.out.println("User enters details");
		obj.registrationfillup(FirstName, LastName);
		
	    
	}
	@When("user gives (.*) and (.*) and (.*)$")
	public void user_gives(String Email,String Password,String ConfirmPassword) {
		
		System.out.println("User enters remaining details");
		obj.registrationfillup1(Email, Password, ConfirmPassword);
		
	
	}
	    

	@When("Click on registerbutton")
	public void click_on_registerbutton() {
		
		System.out.println("Click on click on registrationbutton");
		obj.registersubmitbutton();
	   
	}

	@Then("Users should enter a dashboard page")
	public void users_should_enter_a_dashboard_page() {
	 
		System.out.println("Verify dashboard section");
		obj.verifydashboard();
	}

	@Then("Also check logout button present or not")
	public void also_check_logout_button_present_or_not() {
		
		System.out.println("logout button click");
		obj.verifylogout();
		
		
	    
	}


}
