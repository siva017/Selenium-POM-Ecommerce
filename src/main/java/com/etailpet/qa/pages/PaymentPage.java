package com.etailpet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.etailpet.qa.base.TestBase;

public class PaymentPage extends TestBase {
	

	//Guest User Email address for Order Notification
	@FindBy(xpath="//input[@id='id_username']")
	WebElement GuestEmailNotification;
	
	//Guest user Phone Number
	@FindBy(xpath="//input[@id='id_phone']")
	WebElement GuestUserPhoneNumber;
	
	//Add a Note
	@FindBy(xpath="//textarea[@id='id_notes']")
	WebElement AddNote;
	
	//Continue Button from Guest User
	@FindBy(xpath="//button[text()='Continue']")
	WebElement ContinueBtn;
	
	//Delivery Address Details
	//First Name
	@FindBy(xpath="//input[@id='id_first_name']")
	WebElement AddressFirstName;
	
	//LastName
	@FindBy(xpath="//input[@id='id_last_name']")
	WebElement AddressLastName;
	
	//Address Line-1
	@FindBy(xpath="//input[@id='id_line1']")
	WebElement AddressLine1;
	
	//Address Line-2
	@FindBy(xpath="//input[@id='id_line2']")
	WebElement AddressLine2;   
	
	//City
	@FindBy(xpath="//input[@id='id_line4']")
	WebElement AddressCity;
	
	//State
	@FindBy(xpath="//input[@id='id_state']")
	WebElement AddressState;
	
	//Zip Code
	@FindBy(xpath="//input[@id='id_postcode']")
	WebElement AddressZipCode;        
	                                        
	//Save and Continue        
	@FindBy(xpath="//button[text()='Save & Continue']")
	WebElement AddressSaveAndContinue;
	
	//Payment Section 
	//Card Holder Full Name
	@FindBy(xpath="//input[@id='name-element']")           
	WebElement CardHolderName;
	
	//Card Number                                                                                                                               
	@FindBy(xpath="(//input[@class='InputElement is-empty Input Input--empty'])[1]")
	WebElement CardNumber;
	
	//Cvv Input
	@FindBy(xpath="//input[@name='cvc']")               
	WebElement CvvNumber;
	
	//Expire Date
	@FindBy(xpath="//input[@name='exp-date']")
	WebElement ExpDate;
	
	//Post Code
	@FindBy(xpath="//input[@name='postal_code']")
	WebElement PostCode;
	
	//Continue Button
	@FindBy(xpath="//button[text()='Continue']")
	WebElement PayementContinueBtn;
	
	//Complete CheckOut button
	@FindBy(xpath="//button[@class='btn btn-default data-loader']")
	WebElement CompleteCheckOut;
	
	//Store Pick-Up Object Repository
	@FindBy(xpath="//span[text()='Store Pickup']")
	WebElement SelectStorePickUp;
	
	//Continue as a Guest User Button
	@FindBy(xpath="//button[text()='Continue as guest']")
	WebElement ContinueAsGuestBtn;
	
	//Ship To Me Object Repository
	@FindBy(xpath="//span[text()='Ship to Me']") 
	WebElement SelectShipToMeBtn;
	
	//Frequent Buyers Continue button
	@FindBy(xpath="//div[@class='col-sm-4 mb-10']")
	WebElement FrequentBuyerContinueBtn;                    
	
	//Auto-Order Continue button
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	WebElement AutoOrderContinueBtn;
	
	//Expire Month and Year
	@FindBy(xpath="//input[@name='exp-date']")
	WebElement ExpireMonth;          
	
	//Cvv Number
	@FindBy(xpath="//input[@name='cvc']")
	WebElement Cvv;
	
	//Selecting the delivery method radio check box
	@FindBy(xpath="//span[text()='Home Delivery']")
	WebElement SelectHomeDelivery;
	
	
	//Initializing the Page Objects
	public PaymentPage(){                                                        
		PageFactory.initElements(driver, this);
	}
	
	public String PaymentPageTitle(){
		return driver.getTitle();
	}

	
	public void RegUserHomeDelivery(String FirstName,
			String LastName,String addressLine1,String addressLine2,String City,String State,String 
			zipCode,String HolderName,String cardNumber,String expireMonth,String cvv,String postCode){  
		AddNote.sendKeys("Home Delivery");
		ContinueBtn.click();
		AddressFirstName.sendKeys(FirstName);
		AddressLastName.sendKeys(LastName);
		AddressLine1.sendKeys(addressLine1);
		AddressLine2.sendKeys(addressLine2);
		AddressCity.sendKeys(City);
		AddressState.sendKeys(State);
		AddressZipCode.sendKeys(zipCode);
		AddressSaveAndContinue.click();
		FrequentBuyerContinueBtn.click();
		AutoOrderContinueBtn.click();
		CardHolderName.sendKeys(HolderName);
		CardNumber.sendKeys(cardNumber);
		ExpireMonth.sendKeys(expireMonth);
		Cvv.sendKeys(cvv);
		PostCode.sendKeys(postCode);
		PayementContinueBtn.click(); 
		CompleteCheckOut.click();
		
	}
	
	public void RegUserStorePickUpDelivery(String HolderName,String cardNumber,String expireMonth,String cvv,String postCode){
   		AddNote.sendKeys("Store PickUp");
		ContinueBtn.click();
		FrequentBuyerContinueBtn.click();
		AutoOrderContinueBtn.click();
		CardHolderName.sendKeys(HolderName);
		CardNumber.sendKeys(cardNumber);
		ExpireMonth.sendKeys(expireMonth);
		Cvv.sendKeys(cvv);
		PostCode.sendKeys(postCode);
		PayementContinueBtn.click(); 
		CompleteCheckOut.click();

	}
	
	public void ChangeStoreInPaymentPage(String ChangeStoreName) throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='storeDropdown']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+ChangeStoreName+"')]")).click();
		Thread.sleep(5000);
		
	}
	
	
	
}
