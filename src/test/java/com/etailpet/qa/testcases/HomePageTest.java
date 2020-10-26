package com.etailpet.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.CartPage;
import com.etailpet.qa.pages.ChangeStorePage;
import com.etailpet.qa.pages.GuestPaymentPage;
import com.etailpet.qa.pages.HomePage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.pages.SignInPage;
import com.etailpet.qa.pages.ViewLocationPage;

public class HomePageTest extends TestBase {
	SignInPage signinpage;
	HomePage homepage;
	ChangeStorePage changeStore;
	ShopItemPage shopItem;
	ViewLocationPage viewLocation;
	CartPage cartItemPage;
	GuestPaymentPage GuestUser;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp(){
		initialization();
		signinpage=new SignInPage();
//		GuestUser=new GuestUserPage();
//		signinpage=GuestUser.FromGuestSignIn();
		homepage=signinpage.NavigateToHomePage();
//		changeStore=new ChangeStorePage(); 
//		shopItem=new ShopItemPage();
//		viewLocation=new ViewLocationPage();
//		cartItemPage=new CartPage();
	}
	
	@Test(priority=1)
	public void VerifyHomePageTitleTest() throws InterruptedException{
		String Title=homepage.VerifyHomePageTitle();
		Thread.sleep(3000);
		Assert.assertEquals(Title,"Products | Awesome Pet's","The Home Page Title is not Matched");
	}
	
	@Test(priority=2)
	public void VerifyHomePageContactLabelTest() throws InterruptedException{
		boolean ContactLabel=homepage.VerifyStoreContactlabel();
		Thread.sleep(3000);
		Assert.assertTrue(ContactLabel);
	}
	
	@Test(priority=3)
	public void VerifyHomePageAddressLabelTest(){
		boolean AddressLabel=homepage.verifyStoreAddressLabel();
		Assert.assertTrue(AddressLabel);
	}
	
	@Test(priority=4)
	public void VerifyChangeStoreLinkTest(){
		changeStore=homepage.ClickOnChangeStoreButton();
	}
	
	@Test(priority=5)
	public void VerifyShopItemLinkTest(){
		shopItem=homepage.ClickOnShopItemLink();
	}
	
	@Test(priority=6)
	public void VerifyViewLocationLinkTest(){
		viewLocation=homepage.ClickOnViewLocationButton();
	}
	
	@Test(priority=8)
	public void VerifyHomePageLogoTest(){
	   boolean Logo=homepage.VerifyHomePageLogo();
		Assert.assertTrue(Logo);
	}
	
	@Test(priority=11)    
	public void VerifySearchPage(){
		homepage.VerifySearchTab();   
	}
	
	@AfterMethod
	public void TearDown(){ 
		driver.quit();
	}	
	
	

}
