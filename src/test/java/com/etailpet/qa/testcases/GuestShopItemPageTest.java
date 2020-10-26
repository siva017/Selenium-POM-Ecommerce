package com.etailpet.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.GuestPaymentPage;
import com.etailpet.qa.pages.GuestShopItemPage;

public class GuestShopItemPageTest extends TestBase {
	
	GuestShopItemPage GuestShopItem;
	GuestPaymentPage GuestPage;
	
	public GuestShopItemPageTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp(){
		initialization();
		GuestShopItem=new GuestShopItemPage();
	}
	
	@Test
	public void VerifyGuestSelectProduct() throws InterruptedException{
		GuestPage=GuestShopItem.SelectProduct(prop.getProperty("StoreName"),prop.getProperty("DeliveryMethod"),prop.getProperty("BrandName"),prop.getProperty("ProductName"),prop.getProperty("ProductQuan"));
	}
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}

}
