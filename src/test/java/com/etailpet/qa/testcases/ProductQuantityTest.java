package com.etailpet.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.GuestPaymentPage;
import com.etailpet.qa.pages.HomePage;
import com.etailpet.qa.pages.ProductQuantityPage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.pages.SignInPage;

public class ProductQuantityTest extends TestBase {

	ProductQuantityPage ProductQuantity;
	SignInPage signinpage;
	HomePage homePage;
	GuestPaymentPage GuestUser;
    ShopItemPage shopItemPage;
	
	public ProductQuantityTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException{
		initialization();    
		ProductQuantity=new ProductQuantityPage();
		signinpage=new SignInPage();
		homePage=new HomePage();
		shopItemPage=new ShopItemPage();                                     	
		shopItemPage=signinpage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	 
	@Test(priority=1)             
	public void ProductQuantityTitleTest(){
		String Title=ProductQuantity.ChangeQuantityTitle();
		System.out.println(Title);
	}               
	
	@Test(priority=2)
	public void ChangeQuantityTest(String Quantity){
		ProductQuantity.ChangeQuantity();                                           
	}
	
	@Test(priority=3)  
	public void AddToCartTest(){
		ProductQuantity.AddToCart();
	}
	
	@Test(priority=4)
	public void VerifyBackToShoppingTest(){
		ProductQuantity.VerifyBackToShopping();
	}
	
	@Test(priority=5)
	public void ViewCartPageButtonTest(){
		ProductQuantity.ViewCartPageButton();
	}
	
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
	
}
