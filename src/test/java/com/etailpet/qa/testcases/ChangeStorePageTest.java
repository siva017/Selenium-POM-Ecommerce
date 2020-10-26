package com.etailpet.qa.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.ChangeStorePage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.pages.SignInPage;

public class ChangeStorePageTest extends TestBase{
	ChangeStorePage ChangeStore;
	SignInPage SignIn;
	
	public ChangeStorePageTest(){
		super();   
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException{
		initialization();
		ChangeStore=new ChangeStorePage();
		SignIn=new SignInPage();
		ChangeStore=SignIn.SignInChangeStore(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void VerifyChangeStoreTest(){                                         
		ChangeStore.ChangeStore(prop.getProperty("Store"));       
	}
	
    @Test(priority=2)          
	public void VerifySearchStoreField() throws InterruptedException{
		ChangeStore.SearchInChangeStore(prop.getProperty("SearchStoreName"));
	}
    
    @Test(priority=3)
    public void VerifyChangeStoreAndPaymentFlow() throws InterruptedException{
    	ChangeStore.ChangeStoreAndCompletePayment(prop.getProperty("SearchStoreName"),prop.getProperty("SelectByBrandDeliveryMethod"));
    }
	    

	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}

}
