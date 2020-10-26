package com.etailpet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etailpet.qa.base.TestBase;

public class ProductQuantityPage extends TestBase {
	
	//Object Repository For Quantity Page
	//Changing the Quantity
	@FindBy(xpath="//input[@id='id_quantity']")
	WebElement ProductQuan;
	
	//Adding to the Cart Button
	@FindBy(xpath="//button[contains(text(),'Add to cart ')]")
	WebElement AddToCartBtn; 
	
	//Back To Shopping Button
	@FindBy(xpath="//button[contains(text(),'Back to shopping')]")
	WebElement BackToShoppingBtn;
	
	//View Cart Page
	@FindBy(xpath="//b[contains(text(),'VIEW CART')]")
	WebElement ViewCartBtn;
	
	//Initializing the Object Repository
	public ProductQuantityPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String ChangeQuantityTitle(){
		return driver.getTitle();
	}
	public CartPage ChangeQuantity(){
		ProductQuan.clear();
		ProductQuan.sendKeys("10");
		AddToCartBtn.click();
		ViewCartBtn.click();
		return new CartPage();  
	}
	
	public void AddToCart(){
		AddToCartBtn.click();
	}
	
	public ShopItemPage VerifyBackToShopping(){
		BackToShoppingBtn.click();
		return new ShopItemPage();
	}
	
	public CartPage ViewCartPageButton(){
		ViewCartBtn.click();
		return new CartPage();
	}
	

}
