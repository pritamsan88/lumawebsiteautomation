package pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Carttocheckout {
	
	WebDriver driver;
	WebElement shippingnext;
	//WebDriverWait wait;
	By headermenuselect= By.id("ui-id-4");
	By undermenusubmenu=By.id("ui-id-9");
	By mainmenu=By.id("ui-id-12");
	By productone=By.xpath("//a[@href='https://magento.softwaretestingboard.com/circe-hooded-ice-fleece.html']");
	By firststoptionsize=By.id("option-label-size-143-item-167");
	By secondoptioncolor=By.id("option-label-color-93-item-57");
	By addtocartbutton=By.xpath("//button[@title=\"Add to Cart\"]");
	By productlist=By.cssSelector(".product-item-link");
	By productlist1=By.cssSelector(".product-item-link");
	By size=By.xpath("//div[contains(text(),'M')]");
	By size1=By.id("option-label-size-143-item-167");
	By color=By.xpath("//div[contains(@aria-label,'Purple')]");
	By color1=By.xpath("//div[contains(@aria-label,'Red')]");
	By addtocart=By.id("product-addtocart-button");
	By headercarticon=By.xpath("//a[@href='https://magento.softwaretestingboard.com/checkout/cart/']");
	By confirmationalertcart=By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div > div");
	//By confirmationalertcart1=By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div > div");
	By headermen=By.id("ui-id-5");
	By headermentop=By.id("ui-id-17");
	By menwear=By.id("ui-id-22");
	By cartcounter=By.cssSelector(".counter-number");
	By minicartitems=By.id("ui-id-1");
	By checkoutbuttom=By.id("top-cart-btn-checkout");
	By checkoutsigninbutton=By.xpath("//button/span[contains(text(),'Sign In')]");
	By nextbuttonshipping=By.xpath("//button/span[contains(text(),'Next')]");
	By scrolldownshpping=By.id("shipping");
	//By rows=By.xpath("//div[@id='opc-sidebar']/div/table/tbody/tr/th");
	//By cols=By.xpath("//div[@id='opc-sidebar']/div/table/tbody/tr/td");
	//By table=By.xpath("//div/table/caption[contains(text(),'Order Summary')]");
	By placeorder=By.xpath("//button/span[contains(text(),'Place Order')]");
	By paymentelement=By.id("checkout-payment-method-load");
	//By afterorderplacealert=By.cssSelector("#maincontent > div.page-title-wrapper > h1 > span");
	By afteroorderplacecartsection=By.cssSelector("#minicart-content-wrapper > div.block-content > strong");
	By afterorderplace=By.xpath("//a[@href='https://magento.softwaretestingboard.com/checkout/cart/']");
	By confirmation=By.cssSelector("#maincontent > div.page-title-wrapper > h1 > span");
	By orderno=By.cssSelector("#maincontent > div.columns > div > div.checkout-success > p:nth-child(1) > a > strong");
	
public 	Carttocheckout(WebDriver driver)
{
	this.driver=driver;
}
public void menuselect1() throws InterruptedException
{
	Actions act= new Actions(driver);
	WebElement ele=driver.findElement(headermenuselect);
	WebElement ele2=driver.findElement(undermenusubmenu);
	WebElement ele3=driver.findElement(mainmenu);
	//Actions act= new Actions(driver);
	Thread.sleep(3000);
	act.moveToElement(ele).build().perform();
	Thread.sleep(3000);
	act.moveToElement(ele2).build().perform();
	Thread.sleep(3000);
	act.click(ele3).build().perform();
	
}

public void addtocart() throws InterruptedException
{
	
	List<WebElement> allproducts=driver.findElements(productlist);
	String Expectedproduct="Phoebe Zipper Sweatshirt";
	 boolean productFound = false;
	 
	 for (WebElement product:allproducts) {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
		 if (product.getText().trim().contains(Expectedproduct)) 
		 {
			 product.click();
			 productFound = true;
             break;
         }
	 }if (!productFound) {
         System.out.println("Product not found.");
     }
	 else
	 {
		
		 
		 WebElement sizeOption=driver.findElement(size);
		 sizeOption.click();
		 
		 WebElement colorOption = driver.findElement(color);
		 colorOption.click();
		 
		 WebElement addToCartButton = driver.findElement(addtocart);
         addToCartButton.click();
         Thread.sleep(2000);

        // ((JavascriptExecutor) driver).executeScript("window.scrollBy(500,0);");
         
	 }
	 WebElement carticon=driver.findElement(headercarticon);
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carticon); 
     Thread.sleep(2000);
    	 
}
public void anotherproduct() throws InterruptedException
{
	Thread.sleep(2000);
	Actions act1=new Actions(driver);
	WebElement menproduct=driver.findElement(headermen);
	WebElement menproducttop=driver.findElement(headermentop);
	WebElement finalmenproduct=driver.findElement(menwear);
	Thread.sleep(2000);
	act1.moveToElement(menproduct).build().perform();
	Thread.sleep(2000);
	act1.moveToElement(menproducttop).build().perform();
	Thread.sleep(2000);
	act1.click(finalmenproduct).build().perform();
	
	
}

public void menproduct() throws InterruptedException
{
	List<WebElement> allproducts=driver.findElements(productlist1);
	String Expectedproduct="Tristan Endurance Tank";
	 boolean productFound1 = false;
	 
	 for (WebElement product1:allproducts) {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product1);
		 if (product1.getText().trim().contains(Expectedproduct)) {
             // Click on the product to select it
			 product1.click();
			 productFound1 = true;
             break;
         }
	 }if (!productFound1) {
         System.out.println("Product not found.");
     }
	 else
	 {
		 WebElement sizeOption=driver.findElement(size1);
		 sizeOption.click();
		 
		 WebElement colorOption = driver.findElement(color1);
		 colorOption.click();
		 
		 WebElement addToCartButton = driver.findElement(addtocart);
         addToCartButton.click();
         Thread.sleep(2000);

        // ((JavascriptExecutor) driver).executeScript("window.scrollBy(500,0);");
         
	 }
	 WebElement carticon=driver.findElement(headercarticon);
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carticon); 
	 
	
}

public void verifycartcounter() throws InterruptedException
{
	Thread.sleep(3000);
	 WebElement cartCounter = driver.findElement(cartcounter);
     String itemCount = cartCounter.getText();
     
     System.out.println("Number of items in the cart: " + itemCount);
     if (Integer.parseInt(itemCount) > 0)
     {
    	 System.out.println("Product successfully added to the cart.");
     }
     else {
    	 System.out.println("Failed to add product to the cart.");
     }
     
}

public void cartsection()
{
	WebElement carticon=driver.findElement(headercarticon);
	carticon.click();
 List<WebElement> cartItem=driver.findElements(minicartitems);
	System.out.println(cartItem);
	for(WebElement product:cartItem) {
		System.out.println("Product in the cart: " + product.getText());
	}
   // System.out.println("Product in the cart: " + ((WebElement) cartItem).getText());
}
public void checkoutsection()
{
	WebElement checkout=driver.findElement(checkoutbuttom);
	checkout.click();
}
public void withoutlogincheckoutsigninbutton()
{
	WebElement checkoutsignbutton=driver.findElement(checkoutsigninbutton);
	checkoutsignbutton.click();
}
public void shipping() throws InterruptedException
{
	try{
		Thread.sleep(4000);
		WebElement scroolldown=driver.findElement(scrolldownshpping);
		JavascriptExecutor js10=(JavascriptExecutor) driver;
		js10.executeScript("arguments[0].scrollIntoView(true);", scroolldown);
		Thread.sleep(2000);
		shippingnext=driver.findElement( nextbuttonshipping);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingnext); 
		 Thread.sleep(1000);
		shippingnext.click();
	}catch (StaleElementReferenceException e) {
		e.printStackTrace();
	}    
  		
     }


public void reviewpayment() throws InterruptedException
{
	 try {
    		 Thread.sleep(2000);
    		 WebElement payment=driver.findElement(paymentelement);
    			JavascriptExecutor js11=(JavascriptExecutor) driver;
    			js11.executeScript("arguments[0].scrollIntoView(true);", payment);
    			Thread.sleep(3000);
                 WebElement placeorder1=driver.findElement( placeorder);
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeorder1); 
             placeorder1.click();
         } catch (StaleElementReferenceException e) {
             e.printStackTrace();
             Thread.sleep(1000);
       
            
 		
         }	
     }


public void afterorderplaceconfirmation() throws InterruptedException
{
	
	Thread.sleep(4000);
	String cart=driver.findElement(confirmation).getText();
	System.out.println(cart);
	Thread.sleep(3000);
	
	String ordernumber=driver.findElement(orderno).getText();
	System.out.println("Your order number is :-"+ordernumber);
	
}



public void finaladdtocart() throws InterruptedException
{
	Thread.sleep(3000);
	WebElement carticon=driver.findElement(headercarticon);
	Thread.sleep(2000);
	carticon.click();
	Thread.sleep(2000);
	String finalcartalert=driver.findElement(afteroorderplacecartsection).getText();
	System.out.println(finalcartalert);
	
}

}


