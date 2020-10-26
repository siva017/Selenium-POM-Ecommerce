package com.etailpet.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.CartPage;
import com.etailpet.qa.pages.GuestPaymentPage;
import com.etailpet.qa.pages.GuestShopItemPage;
import com.etailpet.qa.pages.PaymentPage;
import com.etailpet.qa.pages.ProductQuantityPage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.util.TestUtil;

public class GuestPaymentPageTest extends TestBase {
	
	GuestPaymentPage GuestPayment;
	GuestShopItemPage GuestShopItem;
	
	String sheetName="GuestHomeDeliveryPayment";
	String sheetName1="GuestStorePickpDeliveryPayment";
	
	public GuestPaymentPageTest(){
		super();  
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException{
		initialization();
		GuestPayment=new GuestPaymentPage();
		GuestShopItem=new GuestShopItemPage();
		//driver.findElement(By.xpath("//button[@id='accept-cookie']")).click();
		GuestPayment=GuestShopItem.SelectProduct(prop.getProperty("StoreName"),prop.getProperty("DeliveryMethod"),prop.getProperty("BrandName"),prop.getProperty("ProductName"),prop.getProperty("ProductQuan"));
	}
	
	@DataProvider
	public Object[][] GuestHomeDeliveryPaymentData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
      
	
	@Test(priority=1,dataProvider="GuestHomeDeliveryPaymentData")
	public void VerifyGuestHomeDeliveryPaymentTest(String Email,String Phone,String FirstName,String LastName,
			String addressLine1,String addressLine2,String City,String State,
			String Zipcode,String HolderName,String cardNumber,String Expiredate,String cvvNumber,String postCode) throws InterruptedException{
		GuestPayment.GuestUserHomeDeliveryPayment(prop.getProperty("StoreName"),prop.getProperty("BrandName"),prop.getProperty("ProductName"),prop.getProperty("ProductQuan"),Email, Phone, FirstName, LastName, addressLine1, addressLine2, City, State, Zipcode, HolderName, cardNumber, Expiredate, cvvNumber, postCode);
	}
	                 
	@DataProvider
	public Object[][] GuestStorePickUpDeliveryPaymentData(){
		Object data[][]=TestUtil.getTestData(sheetName1);
		return data;
	}
	
	@Test(priority=2, dataProvider="GuestStorePickUpDeliveryPaymentData")
	public void VerifyGuestStorePickUpDeliveryPaymentTest(String Email,String Phone,String HolderName,String cardNumber,String Expiredate,String cvvNumber,String postCode) throws InterruptedException{
		GuestPayment.GuestStorePickUpDelivery(prop.getProperty("StoreName"),prop.getProperty("BrandName"),prop.getProperty("ProductName"),prop.getProperty("ProductQuan"),Email, Phone, HolderName, cardNumber, Expiredate, cvvNumber, postCode);
	}
	
	
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
	}
