package pageobjectmodel;

import java.time.Duration;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationandLogin {
	
	
	
	By registration_headerlink=By.linkText("Create an Account");
	By user_firstname=By.id("firstname");
	By user_LastName=By.id("lastname");
	By Email_registration=By.id("email_address");
	By password=By.id("password");
	By cofirmpassword=By.id("password-confirmation");
	By submitbutton=By.xpath("//span[contains(text(),('Create an Account'))]");
	By headermenu=By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span > button");
    By logout=By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']");
	By signinbuttonlocator=By.linkText("Sign In");
	By loginemailfield=By.id("email");
	By loginpassword=By.id("pass");
	By loginbutton=By.id("send2");
	By loginverify=By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.greet.welcome");
	By checkoutloginemail=By.id("login-email");
	By checkoutloginpassword=By.id("login-password");
	By checkoutsigninbutton1=By.xpath("*//div/button[@type='submit']");
	//*//div/button[@type='submit']
	///html/body/div[2]/main/div[2]/div/div[2]/div[1]/aside/div[2]/div/div/div/div[3]/form/div[2]/div[1]/button/span
	WebDriver driver;
	String url="https://magento.softwaretestingboard.com/";
	
   public RegistrationandLogin(WebDriver driver)
	{
		this.driver=driver;
	}

   public void projecturl1()
   {
	   driver.get(url);
   }
	public void projecturl()
	{
		 
		 driver.get(url);
		 driver.findElement(registration_headerlink).click();
		 
	}
	
	public void registrationfillup(String FirstName,String LastName) throws InterruptedException
	
	{
	 driver.findElement(user_firstname).sendKeys(FirstName);  
	 driver.findElement(user_LastName).sendKeys(LastName);
	 
	 Thread.sleep(1000);
	
	 
	}
	
	public void registrationfillup1(String Email,String Password,String ConfirmPassword)
	{
		driver.findElement(Email_registration).sendKeys(Email);
		 driver.findElement(password).sendKeys(Password);
		 driver.findElement(cofirmpassword).sendKeys(ConfirmPassword);
	}
	
	public void registersubmitbutton()
	{
		driver.findElement(submitbutton).click();
	}
	
	public void verifydashboard()
	{
		 String expectedurl="https://magento.softwaretestingboard.com/customer/account/";
		  String currenturl=driver.getCurrentUrl();
		  System.out.println("Url is"+currenturl);
		  if(currenturl.equalsIgnoreCase(expectedurl))
		  {
			  System.out.println("You are redirect to dashboard page");
			  Assert.assertEquals(currenturl, expectedurl);
			 
		  }
		  else {
			System.out.println("You are not redirect to dashboard page");
			Assert.assertEquals(currenturl, expectedurl);
		}
	}
	
	public void verifylogout()
	{
		try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement headermenu1=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement( headermenu)));
		headermenu1.click();
		WebElement logoutbutton= driver.findElement(logout);
		
		Boolean flag=logoutbutton.isDisplayed();
		System.out.println("Vsibility of logout button" + flag);
		
		logoutbutton.click();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			
		}
	}
	
	
	public void signuppage()
	{
		driver.get(url);
		driver.findElement(signinbuttonlocator).click();
		
	}
	
	
	public void logincredebtials(String email,String password)
	{
		driver.findElement(loginemailfield).sendKeys(email);
		driver.findElement(loginpassword).sendKeys(password);
	}
	
	
	public void signin()
	{
		driver.findElement(loginbutton).click();
	}
	
	public void verifylogin() throws InterruptedException
	{
		Thread.sleep(2000);
		String actuallogin=driver.findElement(loginverify).getText().trim();
		System.out.println(actuallogin);
		if(actuallogin.contains("Welcome"))
		{
			System.out.println("You are successfully logged in your account ");
		}
		else
		{
			System.out.println("Invalid login ");
		}
		
	}
	
	
	
	public void loginfunctionality(String email,String password)
	{
		driver.findElement(loginemailfield).sendKeys(email);
		driver.findElement(loginpassword).sendKeys(password);
		driver.findElement(loginbutton).click();
	}
	
	public void checkoutloginfunctionality(String email,String password) throws InterruptedException
	{
		driver.findElement(checkoutloginemail).clear();
		driver.findElement(checkoutloginemail).sendKeys(email);
		driver.findElement(checkoutloginpassword).sendKeys(password);
		Thread.sleep(3000);
		WebElement checkoutsignbutton1=driver.findElement(checkoutsigninbutton1);
		checkoutsignbutton1.click();
		
		
		
	}
	/*public void checkoutpopupsigninbutton()
	{
		WebElement checkoutsignbutton1=driver.findElement(checkoutsigninbutton1);
		checkoutsignbutton1.click();
	}*/
}
