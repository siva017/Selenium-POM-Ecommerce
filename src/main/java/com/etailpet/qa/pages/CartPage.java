package com.etailpet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etailpet.qa.base.TestBase;

public class CartPage extends TestBase {
	HomePage homepage;
	
	//CartPageLogo
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement CartPageLogo;
	
	//Cart count
	@FindBy(id="cartDiv")
	WebElement CartCount;
	
	//Continue Shopping page
	@FindBy(xpath="//a[contains(text(),'Continue shopping')]")
	WebElement ContinueShoppingBtn;
	
	//Proceed To CheckOut
	@FindBy(xpath="//a[contains(text(),' proceed to checkout')]")
	WebElement ProceedCheckoutBtn;
	
	// Selecting the delivery method radio check box
	@FindBy(xpath = "//span[text()='Home Delivery']") 
	WebElement SelectHomeDelivery;
	
	//Intializing the Page Objects
	public CartPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyCartPageTitle(){
		return driver.getTitle();  
	} 
	
	public String VerifuCartCount(){
		return CartCount.getText();
	}
	
	public HomePage VerifyContinueShoppingLable() throws InterruptedException{
		ContinueShoppingBtn.click();
	    return new HomePage();
	}
	
	public PaymentPage ProceedToCheckOutButton() throws InterruptedException{
		SelectHomeDelivery.click();
		ProceedCheckoutBtn.click();
		Thread.sleep(5000);
		return new PaymentPage();
	}
	
	public boolean VerifyCartPageLogo(){
		return CartPageLogo.isDisplayed();
		
	}

}
