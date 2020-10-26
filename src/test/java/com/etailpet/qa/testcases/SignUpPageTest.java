package com.etailpet.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.GuestPaymentPage;
import com.etailpet.qa.pages.HomePage;
import com.etailpet.qa.pages.SignInPage;
import com.etailpet.qa.pages.SignUpPage;
import com.etailpet.qa.util.TestUtil;

public class SignUpPageTest extends TestBase{
	
	SignUpPage signuppage;
	SignInPage signinPage;
	GuestPaymentPage GuestUser;  
	HomePage homepage; 
	
	String sheetName="SignUp";  
	                                           
	public SignUpPageTest(){
		super();
	}
	@BeforeMethod
	public void SetUp(){      
		initialization();
		signuppage=new SignUpPage();    
		signinPage=new SignInPage();  
		driver.findElement(By.xpath("//button[@id='accept-cookie']")).click(); 
        signuppage=signinPage.NavigateToSignUpPage(); 
	}
	
	@Test(priority=1)
	public void SignUpPageTitleTest() throws InterruptedException{                                                       
		String Title=signuppage.ValidateSignUpPageTitle(); 
		Assert.assertEquals(Title,"Sign Up | Awesome Pet's");  
	}
	
	@Test(priority=2)
	public void SignUpPageImageTest(){    
		boolean Image=signuppage.SignUpImageValidation();
		Assert.assertTrue(Image);                                                 
	}
	  
	@DataProvider
	public Object[][] getSignUpTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}                                                                                        
	 
	@Test(priority=3,dataProvider="getSignUpTestData")
	public void SignUpTest(String ftname,String ltname,String mail,String pnumber,String password,String cfmpassword) throws InterruptedException{
		signuppage.SignUp(ftname, ltname, mail, pnumber, password, cfmpassword);
	}         
	
                                                                                                                	
	@AfterMethod
	public void teardown(){ 
		driver.quit();
		          
	}        

}
