package com.etailpet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etailpet.qa.base.TestBase;

public class GuestShopItemPage extends TestBase {
	
	//Object Repositories
	//Shop Item Button
	@FindBy(xpath="//a[contains(@class,'shopnow-nav')]")
	WebElement ShopItemBtn;
	
	//Selecting Brand
	@FindBy(xpath="//a[text()='Acana']")
	WebElement SelectBrand;
	
	//Selecting a Product.
	@FindBy(xpath="//a[text()='ACANA Regionals Meadowland Formula Cat and Kitten Dry Cat Food']")
	WebElement SelectProduct;
	
	//Entering a Quantity
	@FindBy(xpath="//input[@name='quantity']")
	WebElement ProductQuantity;
	
	//Add to cart from quantity page
	@FindBy(xpath="//button[text()='Add to cart ']")
	WebElement AddToCartBtn;
	
	//View Cart button
	@FindBy(xpath="//b[text()='VIEW CART']")
	WebElement ViewCartBtn;
	
	//Selecting Delivery Method
	@FindBy(xpath="//span[text()='Home Delivery']")
	WebElement DeliveryLabel;
	
	//Proceed CheckOut Button
	@FindBy(xpath="//a[@id='add-cart-btn']")
	WebElement CheckOutBtn;
	 
	//Continue as Guest Button
	@FindBy(xpath="//button[text()='Continue as guest']")
	WebElement ContinueAsGuestBtn;
	
	//Initializing Page Objects
	public GuestShopItemPage(){
		PageFactory.initElements(driver, this);
	}
	         
	//Action 
	public GuestPaymentPage SelectProduct(String StoreName,String DeliveryMethod,String BrandName,String ProductName,String ProductQuan) throws InterruptedException{
		driver.findElement(By.xpath("(//a[text()='Change Store'])[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+StoreName+"')]/parent::h4/parent::div//following-sibling::div//a[text()='Shop this store']")).click();
		WebElement element = driver.findElement(By.xpath("(//a[text()='SHOP ITEMS'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//a[text()='"+BrandName+"']")).click();
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']/parent::h3/parent::div//a[text()='Add to cart']")).click();
		ProductQuantity.clear();
		ProductQuantity.sendKeys(ProductQuan);
		AddToCartBtn.click();
		ViewCartBtn.click();
		return new GuestPaymentPage();
	}
	
	
	
	
	

}
