package com.etailpet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etailpet.qa.base.TestBase;

public class SignInPage extends TestBase{
	
	
	//PageFactory (or) Object Repository
	//Navigate to Sign Up
	@FindBy(xpath="//p[@class='pull-right']//span//a[text()='SIGN UP']")
	WebElement NavigateSignUpBtn;
	//Username
	@FindBy(name="username")
	WebElement username;

	//Password
	@FindBy(name="password")
	WebElement password;
	
	//sign in button   
	@FindBy(xpath="//button[contains(text(),'SIGN IN')]")
	WebElement signInBtn;
	
	//Sign up button
	@FindBy(xpath="//a[contains(text(),'SIGN UP')]")
	WebElement signUpBtn;
	
	//Logo
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")        
	WebElement etailpetLogo;
	
	//Facebook link
	@FindBy(xpath="//a[contains(@aria-label,'Facebook')]")
	WebElement SignInFaceBookBtn;
	
	//Facebook Password
	@FindBy(xpath="//input[@name='pass']")
	WebElement FacebookPasswordBtn;
		
	//Facebook Continue button 
	@FindBy(xpath="//input[@id='u_0_3']")
	WebElement FacebookContinueBtn;
	
	//Using Facebook Link
	@FindBy(xpath="//a[contains(@aria-label,'Facebook')]")
	WebElement SignUpFacebookBtn;
		
	//Facebook Password
	@FindBy(xpath="//input[@name='pass']")
	WebElement FacebookPassword;
		
	//Facebook Email
	@FindBy(xpath="//input[@name='email']")
	WebElement FacebookEmail;
		
	//Facebook Login button
	@FindBy(xpath="//button[@id='loginbutton']")
	WebElement FacebookLoginBtn;
	
	//Google Plus button 
	@FindBy(xpath="//a[contains(@aria-label,'Google Plus')]")
	WebElement SignUpGoogleBtn;
		
	//Google plus Email Field
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement SignUpGooglePlusEmail;
		
	//Google plus Email Field 'Next' button
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement SignUpGoogleNextBtn;
	
	//HomePage Navigation
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement HomePageNavigationBtn;
	
	//ChangeStore
	@FindBy(xpath="//a[contains(text(),'Change Store')][1]")
	WebElement ChangeStoreBtn;

	
	
	//Initializing PageObjects
	public SignInPage(){
		PageFactory.initElements(driver, this);
	}
	     
	//Actions
	public String ValidateSignInPageTitle(){
		return driver.getTitle();
	}
	
	public boolean ValidateEtailPetImage(){
		return etailpetLogo.isDisplayed();
	}
	
	public SignUpPage NavigateToSignUpPage(){
		NavigateSignUpBtn.click();
		return new SignUpPage();               
	}
	
	public ShopItemPage signIn(String un,String pwd) throws InterruptedException{
		//driver.findElement(By.xpath("//div[@class='modal-dialog modal-md']//div//div//button[@class='close']")).click();
		//driver.findElement(By.xpath("//button[@id='accept-cookie']")).click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
		Thread.sleep(5000);
		return new ShopItemPage();         
	}           
	
	public ChangeStorePage SignInChangeStore(String un,String pwd) throws InterruptedException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
		ChangeStoreBtn.click();
		Thread.sleep(5000);
		return new ChangeStorePage();
        
	}
	
	public HomePage NavigateToHomePage(){
		HomePageNavigationBtn.click();
		return new HomePage();
	}
	
	public void VerifySignInFacebookButton(){
		SignInFaceBookBtn.click();
		FacebookPasswordBtn.sendKeys("siva1427908");
		FacebookContinueBtn.click();
	}                  
	
	public ProfilePage ProfileOptionNavigation(String un,String pwd) throws InterruptedException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
		Thread.sleep(5000);
		return new ProfilePage();
	}
	
	public HomePage SignInFacebook() throws InterruptedException{
		SignUpFacebookBtn.click();
		FacebookEmail.sendKeys("sivaprakash340640@gmail.com");
		FacebookPassword.sendKeys("thomas001");
		FacebookLoginBtn.click();
		Thread.sleep(10000);
		System.out.println(driver.getTitle());
		return new HomePage();
	
	}
	public HomePage SignInGooglePlus() throws InterruptedException{   
		SignUpGoogleBtn.click();
		SignUpGooglePlusEmail.sendKeys("me.sivaprakasam@gmail.com");
		SignUpGoogleNextBtn.click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		return new HomePage();
	}
		}        
