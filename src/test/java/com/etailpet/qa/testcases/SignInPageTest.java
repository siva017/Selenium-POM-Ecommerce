package com.etailpet.qa.testcases;

import org.apache.poi.hwpf.model.SinglentonTextPiece;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.GuestPaymentPage;
import com.etailpet.qa.pages.HomePage;
import com.etailpet.qa.pages.ProfilePage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.pages.SignInPage;
import com.etailpet.qa.pages.SignUpPage;

public class SignInPageTest extends TestBase{
	SignInPage signinPage;
	ShopItemPage ShopItempage;
	SignUpPage signuppage;
	GuestPaymentPage GuestUser;
	ProfilePage Profile;
	
	public SignInPageTest(){
		super();
	}
	 
	@BeforeMethod    
	public void setUp(){
		initialization();
		signinPage= new SignInPage();  	
	}
	@Test(priority=1)
	public void SigninPageTitleTest() throws InterruptedException{
		Thread.sleep(15000);
		String title=signinPage.ValidateSignInPageTitle();
		Assert.assertEquals(title,"Sign In | Awesome Pet's");
	}
	@Test(priority=2)
	public void etailLogoTest(){
		boolean flag=signinPage.ValidateEtailPetImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void signinTest() throws InterruptedException{
		ShopItempage=signinPage.signIn(prop.getProperty("username"),prop.getProperty("password"));
	    String Title=signinPage.ValidateSignInPageTitle();
	    System.out.println(Title);
	}         
	
	@Test(priority=4)
	public void ProfileNavigationMethod() throws InterruptedException{
		Profile=signinPage.ProfileOptionNavigation(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod 
	public void teardown(){
		driver.quit();
	}

}
