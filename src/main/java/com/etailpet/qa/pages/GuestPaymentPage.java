package com.etailpet.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.etailpet.qa.base.TestBase;

public class GuestPaymentPage extends TestBase {
	
	//Object Repository 
	// Guest User Email address for Order Notification
	@FindBy(xpath = "//input[@id='id_username']")
	WebElement GuestEmailNotification;

	// Guest user Phone Number
	@FindBy(xpath = "//input[@id='id_phone']")
	WebElement GuestUserPhoneNumber;

	// Add a Note
	@FindBy(xpath = "//textarea[@id='id_notes']")
	WebElement AddNote;

	// Continue Button from Guest User
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement GuestContinueBtn;

	// Delivery Address Details
	// First Name
	@FindBy(xpath = "//input[@id='id_first_name']")
	WebElement AddressFirstName;

	// LastName
	@FindBy(xpath = "//input[@id='id_last_name']")
	WebElement AddressLastName;

	// Address Line-1    
	@FindBy(xpath = "//input[@id='id_line1']")
	WebElement AddressLine1;

	// Address Line-2
	@FindBy(xpath = "//input[@id='id_line2']")
	WebElement AddressLine2;

	// City
	@FindBy(xpath = "//input[@id='id_line4']")
	WebElement GuestAddressCity;

	// State
	@FindBy(xpath = "//input[@id='id_state']")
	WebElement GuestAddressState;

	// ZipCode
	@FindBy(xpath = "//input[@id='id_postcode']")
	WebElement GuestAddressZipCode;

	// Save and Continue
	@FindBy(xpath = "//button[text()='Save & Continue']")
	WebElement AddressSaveAndContinue;

	// Payment Section
	// Card Holder Full Name
	@FindBy(xpath = "//input[@id='name-element']")
	WebElement CardHolderName;

	// Card Number
	@FindBy(xpath = "//input[@name='cardnumber' and @class='InputElement is-empty Input Input--empty']")
	WebElement CardNumber;
	
	//Expire Date
	@FindBy(xpath="//input[contains(@name,'exp-date')]")
	WebElement ExpireDate;

	// CVV Input
	@FindBy(xpath = "//input[@name='cvc']")
	WebElement CvvNumber;

	// Post Code
	@FindBy(xpath="//input[@id='postal-code']")
  	WebElement PostCode;

	// Continue Button
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement PayementContinueBtn;

	// Complete CheckOut button
	@FindBy(xpath = "//button[@class='btn btn-default data-loader']")
	WebElement CompleteCheckOut;	
	
	//Initializing the Page Objects                                                                      
	public GuestPaymentPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void GuestUserHomeDeliveryPayment(String StoreName,String BrandName,String ProductName,String ProductQuan,String Email,String Phone,String FirstName,String LastName,
			String addressLine1,String addressLine2,String City,String State,
			String Zipcode,String HolderName,String cardNumber,String Expiredate,String cvvNumber,String postCode) throws InterruptedException{
		driver.findElement(By.xpath("(//a[text()='Change Store'])[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+StoreName+"')]/parent::h4/parent::div//following-sibling::div//a[text()='Shop this store']")).click();
		WebElement element = driver.findElement(By.xpath("(//a[text()='SHOP ITEMS'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//a[text()='"+BrandName+"']")).click();
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']/parent::h3/parent::div//a[text()='Add to cart']")).click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(ProductQuan);
		driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
		driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
		driver.findElement(By.xpath("//span[text()='Local Delivery']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		GuestEmailNotification.sendKeys(Email);
		GuestUserPhoneNumber.sendKeys(Phone);
		AddNote.sendKeys("This is Note");
		GuestContinueBtn.click();
		AddressFirstName.sendKeys(FirstName);
		AddressLastName.sendKeys(LastName);  
		AddressLine1.sendKeys(addressLine1);
		AddressLine2.sendKeys(addressLine2);
		GuestAddressCity.sendKeys(City);
		GuestAddressState.sendKeys(State);
		GuestAddressZipCode.sendKeys(Zipcode);   
		AddressSaveAndContinue.click(); 
		CardHolderName.sendKeys(HolderName);
		driver.switchTo().frame("__privateStripeFrame5");
		CardNumber.sendKeys(cardNumber);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("__privateStripeFrame6");
		ExpireDate.sendKeys(Expiredate);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("__privateStripeFrame7");
		CvvNumber.sendKeys(cvvNumber);
		driver.switchTo().defaultContent();
		PostCode.sendKeys(postCode);
		PayementContinueBtn.click();
		CompleteCheckOut.click(); 
		
	}
	
	public void GuestStorePickUpDelivery(String StoreName,String BrandName,String ProductName,String ProductQuan,String Email,String Phone,String HolderName,String cardNumber,String Expiredate,String cvvNumber,String postCode) throws InterruptedException{
		driver.findElement(By.xpath("(//a[text()='Change Store'])[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+StoreName+"')]/parent::h4/parent::div//following-sibling::div//a[text()='Shop this store']")).click();
		WebElement element = driver.findElement(By.xpath("(//a[text()='SHOP ITEMS'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//a[text()='"+BrandName+"']")).click();
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']/parent::h3/parent::div//a[text()='Add to cart']")).click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(ProductQuan);
		driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
		driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
		driver.findElement(By.xpath("//span[text()='Store Pickup']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		GuestEmailNotification.sendKeys(Email);
		GuestUserPhoneNumber.sendKeys(Phone);
		AddNote.sendKeys("This is Note");
		GuestContinueBtn.click();
		CardHolderName.sendKeys(HolderName);
		driver.switchTo().frame("__privateStripeFrame5");
		CardNumber.sendKeys(cardNumber);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("__privateStripeFrame6");
		ExpireDate.sendKeys(Expiredate);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("__privateStripeFrame7");
		CvvNumber.sendKeys(cvvNumber);
		driver.switchTo().defaultContent();
		PostCode.sendKeys(postCode);
		PayementContinueBtn.click();
		CompleteCheckOut.click(); 

	}
	

	}

		
		
		
		
	
	

