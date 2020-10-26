package com.etailpet.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.CartPage;
import com.etailpet.qa.pages.GuestPaymentPage;
import com.etailpet.qa.pages.HomePage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.pages.SignInPage;

public class CartPageTest extends TestBase {
	
	SignInPage signinpage;
	HomePage homePage;
	CartPage cartpage;
	ShopItemPage ShopItem;
	GuestPaymentPage GuestUser;
	
	
	public CartPageTest(){
		super();
	}
	
	@BeforeMethod()
	public void SetUp() throws InterruptedException{
		initialization();
		signinpage=new SignInPage();
		homePage=new HomePage();
		ShopItem=new ShopItemPage();
		//GuestUser=new GuestUserPage();
		//signinpage=GuestUser.FromGuestSignIn();
		ShopItem=signinpage.signIn(prop.getProperty("username"),prop.getProperty("password"));
		cartpage=ShopItem.ClickOnCartItemLink();
	}
	
	@Test
	public void VerifyCartPageTitleTest(){
		String Title=cartpage.verifyCartPageTitle();
		Assert.assertEquals(Title,"Cart | Awesome Pet's","The Tile is not matching in the cart page");
	}         
	
	@Test
	public void CartPageLogoTest(){
		Assert.assertTrue(cartpage.VerifyCartPageLogo());
	}
	
	@Test
	public void CartPageContinueShoppingTest() throws InterruptedException{
		cartpage.VerifyContinueShoppingLable();            
	}              
	
	@Test
	public void CartPageItemCountTest(){
		String count=cartpage.VerifuCartCount();
		System.out.println("The Count is "+count);
	}
	
	@Test
	public void ProceedToCheckoutTest() throws InterruptedException{
		cartpage.ProceedToCheckOutButton();
	}
	@AfterMethod
	public void TearDowwn(){
		driver.quit();
	}

}
