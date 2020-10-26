package com.etailpet.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.etailpet.qa.base.TestBase;
import com.etailpet.qa.pages.HomePage;
import com.etailpet.qa.pages.ProfilePage;
import com.etailpet.qa.pages.ShopItemPage;
import com.etailpet.qa.pages.SignInPage;
import com.etailpet.qa.util.TestUtil;

public class ProfilePageTest extends TestBase {
	
	ProfilePage profile;
	SignInPage signin;
	HomePage home;
	ShopItemPage ShopItem;
	
	String sheetName="ProfileFieldInputFields";
	
	public ProfilePageTest(){
		super();
		
	}
	
	@BeforeClass
	public void ProfilePageOptionTest() throws InterruptedException{
		initialization();
		signin=new SignInPage();
		ShopItem=new ShopItemPage();
		home=new HomePage();
		profile=new ProfilePage();
		profile=signin.ProfileOptionNavigation(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void ProfileTitleTest() throws InterruptedException{
		profile.VerifyProfileTitle();
	}
	
	@Test(priority=2)
	public void VerifyHistoryPageTitleTest() throws InterruptedException{
		profile.VerifyHistoryTitle();
	}
	
	@Test(priority=3)
	public void VerifyManageOrderTitleTest() throws InterruptedException{
		profile.VerifyManageAutoOrderTitle();
	}
	
	@Test(priority=4)
	public void VerifyManageAddressTitleTest(){
		profile.VerifyManageAddressTitle();
	}
	
	@Test(priority=5)
	public void VerifyChangePasswordTitle(){
		profile.VerifyChangePasswordTitle();
	}
	
	@Test(priority=6)
	public void ClickEmptyUpdateProfileButtonTest() throws InterruptedException{
		profile.ClickEmptyUpdateProfileButton();
	}
	
	@Test(priority=7)
	public void CheckValidFieldsInputProfileTest() throws InterruptedException{
		profile.CheckValidFieldsInputProfile();
	}
	
	@Test(priority=8)
	public void RemoveFirstNameAndUpdateTest() throws InterruptedException{
		profile.RemoveFirstNameAndUpdate();
	}
	
	@Test(priority=9)
	public void MaximumInputFirstNameAndUpdateTest() throws InterruptedException{
		profile.MaximumInputFirstNameAndUpdate();
	}
	
	@Test(priority=10)
	public void RemoveLastNameAndUpdateTest() throws InterruptedException{
		profile.RemoveLastNameAndUpdate();
	}
	
	@Test(priority=11)
	public void MaximumInputLastNameAndUpdateTest() throws InterruptedException{
		profile.MaximumInputLastNameAndUpdate();
	}
	
	@Test(priority=12)
	public void RemovePhoneNumberAndUpdateTest() throws InterruptedException{
		profile.RemovePhoneNumberAndUpdate();
	}
	
	@Test(priority=13)
	public void VerifyInputLimitationPhoneNumberFieldTest() throws InterruptedException{
		profile.VerifyInputLimitationPhoneNumberField();
	}   
	
	@Test(priority=14)
	public void RemoveRewardIdAndUpdate() throws InterruptedException{
		profile.RemoveRewardIdAndUpdate();
	}
	
	@Test(priority=15)
	public void MaximumLimitRewardIdFieldTest() throws InterruptedException{
		profile.MaximumLimitRewardIdField();
	}
	
	@Test(priority=16)
	public void validationMessageRewardIDFieldTest() throws InterruptedException{
		profile.validationMessageRewardIDField();
	}
	
	@Test(priority=17)
	public void UploadProfilePictureTest() throws InterruptedException{
		profile.UploadProfilePicture();
	}
	
	@DataProvider 
	public Object[][] getProfileTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
		
	@Test(priority=18, dataProvider="getProfileTestData")
	public void VerifyProfileInputFieldsTest(String FirstName,String LastName,String PhoneNumber,String RewardID) throws InterruptedException{ 
		profile.VerifyProfileInputFields(FirstName, LastName, PhoneNumber, RewardID);
	}
	
	@Test(priority=19)
	public void VerifyTheStoredAddressTest(){ 
		profile.VerifyTheStoredAddress();
	}
	
	@Test(priority=20)
	public void MakeDefaultAddressMethodTest() throws InterruptedException{   
		profile.MakeDefaultAddressMethod();
	}
	
	@Test(priority=21) 
	public void ListManageAddressTest(){
		profile.ListManageAddress();   
	}
	
	@Test(priority=22)
	public void CheckAddNewAddressButtonTest() throws InterruptedException{  
		profile.CheckAddNewAddressButton();                                              
	}               
	
	@Test(priority=23)
	public void CheckAddNewAddressPageTitleTest(){ 
		profile.CheckAddNewAddressPageTitle();  
	}               
	
	@Test(priority=24)
	public void ClickEmptyAddressSaveButtonTest() throws InterruptedException{
		profile.ClickEmptyAddressSaveButton();
	}
	
	@Test(priority=25)
	public void CheckFirstNameValidationMessageTest() throws InterruptedException{ 
		profile.CheckFirstNameValidationMessage();
	}
	
	@Test(priority=26)
	public void ExistingAddressValidationTest() throws InterruptedException{
		profile.ExistingAddressValidation();
	}
	
	@AfterClass
	public void teardown(){
		driver.quit();
	}   

}
