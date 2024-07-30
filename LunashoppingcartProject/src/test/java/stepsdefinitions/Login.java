package stepsdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.RegistrationandLogin;

public class Login {
	
	WebDriver driver;
	RegistrationandLogin login;
	
	@Given("open a browser")
	public void open_a_browser() {
		
		System.out.println("Browser is open");	
		String projecturl= System.getProperty("user.dir");
		System.out.println("Project path is "+projecturl);
		System.setProperty("WebDriver.chrome.driver", projecturl+"/src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
	    
	}

	@Given("Go to project login page")
	public void go_to_project_login_page() {
		System.out.println("This is signin page");
		login=new RegistrationandLogin(driver);
		login.signuppage();
		
	    
	}

	@When("user type (.*) and (.*)$")
	public void user_type_name1_and(String email, String password) {
		
		System.out.println("using credentials");
		login.logincredebtials(email, password);
		
	   
	}

	@When("Click on signin button")
	public void click_on_signin_button() {
		
		System.out.println("Click on signin button");
		login.signin();
	    
	}

	@Then("verify user enter into dashboard or not")
	public void verify_user_enter_into_dashboard_or_not() throws InterruptedException {
	   
		System.out.println("Verify login or not");
		login.verifylogin();
	}

	@Then("logout option present or not")
	public void logout_option_present_or_not() {
		
		System.out.println("Logout button present or not");
		
		login.verifylogout();
	    
	}


}
