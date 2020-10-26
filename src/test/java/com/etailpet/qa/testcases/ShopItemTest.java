package com.etailpet.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.GuestPaymentPage;
import com.etailpet.qa.pages.HomePage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.pages.SignInPage;
import com.etailpet.qa.util.TestUtil;

public class ShopItemTest extends TestBase {
	ShopItemPage shopItemPage;
	SignInPage signinpage;
	HomePage homePage;
	GuestPaymentPage GuestUser;
	
	String sheetName="SearchProduct";
	       
	public ShopItemTest(){                         
		super();                      
	}   
	
	@BeforeMethod
	public void SetUp() throws InterruptedException{
		initialization(); 
		signinpage=new SignInPage();
		shopItemPage=new ShopItemPage();
		homePage=new HomePage(); 
		GuestUser=new GuestPaymentPage();  	
		shopItemPage=signinpage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		//shopItemPage=homePage.ClickOnShopItemLink();
	}
	
	@Test(priority=1)                                              
	public void VerifyShopItemLogoTest(){    
		Assert.assertTrue(shopItemPage.CheckShopItemPageLogo());   
	}
	
	@Test(priority=2)
	public void VerifyShopItemTitleTest(){
		String Title=shopItemPage.CheckShopItemTitle();
		System.out.println("The Title is"+Title);
		Assert.assertEquals(Title,"Products | Awesome Pet's");    
	}  
	  
	@Test(priority=3)
	public void VerifySearchWithResultsTest(){                                         
		shopItemPage.CheckSearchWithinResult();
	}     
	
	@Test(priority=4,enabled=false)       
	public void VerifyCheckFilterCheckBoxTest(){
		shopItemPage.CheckFilterCheckBox("Home Delivery");
	}
	
	@Test(priority=5,enabled=false) 
	public void ClearCheckFilterTest(){
		shopItemPage.CheckClearFiltersButton("Home Delivery");
	}
	
	@Test(priority=6)	
	public void CheckSortByTest(){ 
		shopItemPage.CheckSortBy("Name: A to Z");
	}
	
	
	@Test(priority=7)
	public void CheckSelectBrandTest(){
		shopItemPage.CheckSelectBrand("Acana");	   
	}	
	
	
	@DataProvider 	
	public Object[][] SearchProductData(){   
		Object data[][]=TestUtil.getTestData(sheetName);           
		return data;          
	}

   	
	@Test(priority=8, dataProvider="SearchProductData")
	public void SearchProductTest(String ProductToSearch,String ProductQuantity,String FirstName,String LastName,
			String AddressLine1,String AddressLine2,String City,String State,String ZipCode,String HolderName,String CardNumber,String ExpireDate, 
			String cvv,String PostCode) throws InterruptedException{
		shopItemPage.SearchProduct(ProductToSearch, ProductQuantity,prop.getProperty("DeliveryMethodAfterSearch"), FirstName, LastName, AddressLine1, AddressLine2, City, State, ZipCode, HolderName, CardNumber, cvv, ExpireDate, PostCode);
	}
	
	@Test(priority=9)
	public void SearchProductMethodTest() throws InterruptedException{
 		shopItemPage.SearchProductMethod(prop.getProperty("ProductToSearch"),prop.getProperty("ProductQuantity"),prop.getProperty("DeliveryMethodAfterSearch"));
	}
	
	@Test(priority=10,enabled=false)
		public void SearchByCategoryTest() throws InterruptedException{
			shopItemPage.SelectByCategory(); 
		}            
	  
	@Test(priority=11)   
	public void SearchByBrandTest() throws InterruptedException{   
		shopItemPage.SelectByBrand(prop.getProperty("SelectByBrand"), prop.getProperty("SelectByBrandQuantity"), prop.getProperty("SelectByBrandDeliveryMethod"));
	}	
	
 	@Test(priority=12)
	public void SelectByDeliveryMethodTest() throws InterruptedException{
		shopItemPage.SelectByDeliveryMethod(prop.getProperty("SelectByDeliveryMethod"));
	}
	
	@Test(priority=13)
		public void ApplyPromoCodeTest() throws InterruptedException{
		shopItemPage.PromoCodeCheckOut(prop.getProperty("PromoProduct"), prop.getProperty("PromoProductQuantity"), prop.getProperty("PromoDeliveryMethod"), prop.getProperty("PromoCode"));
	}
	
	@Test(priority=14)
	public void RemovePromoCodeTest() throws InterruptedException{
		shopItemPage.RemovePromoCheckOut(prop.getProperty("PromoProduct"), prop.getProperty("PromoProductQuantity"), prop.getProperty("PromoDeliveryMethod"), prop.getProperty("PromoCode"));
	}
	
	@Test(priority=15)
	public void ApplyBuyGetCodeTest() throws InterruptedException{
		shopItemPage.ApplyBuyGet(prop.getProperty("BuyGetProduct"), prop.getProperty("BuyGetProductQuantity"), prop.getProperty("BuyGetDeliveryMethod"), prop.getProperty("BuyGetCode"));
	}
	
	@Test(priority=16)
	public void RemoveBuyGetCodeTest() throws Exception{
 	shopItemPage.RemoveBuyGet(prop.getProperty("BuyGetProduct"), prop.getProperty("BuyGetProductQuantity"), prop.getProperty("BuyGetDeliveryMethod"), prop.getProperty("BuyGetCode"));
	}
	
	@Test(priority=17)	
	public void VerifyApplyPriceSlash() throws InterruptedException{
		shopItemPage.ApplyPriceSlash(prop.getProperty("PriceSlashProduct"),prop.getProperty("SelectByBrandDeliveryMethod"));
	}
		
	@Test(priority=18)
	public void AutoOrderTest() throws InterruptedException{
		shopItemPage.VerifyAutoOrderMethod(prop.getProperty("AutoOrderDeliveryMethod"),prop.getProperty("AutoOrderFrequency"));
	}
	
	@Test(priority=19)
	public void FrequentBuyersCardTest() throws InterruptedException{
		shopItemPage.FrequentBuyersCardMethod(prop.getProperty("FBCDeliveryMethod"));
	}
	@AfterMethod      
	public void TearDown(){
		driver.quit();
	}
	

}
