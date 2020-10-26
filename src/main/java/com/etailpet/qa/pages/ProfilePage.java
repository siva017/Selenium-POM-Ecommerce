package com.etailpet.qa.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.etailpet.qa.base.TestBase;

import okhttp3.Address;

public class ProfilePage extends TestBase {
	
	SignInPage signinpage;
	HomePage homepage;
	ShopItemPage shoppage;
	
	public void VerifyProfileTitle() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		String ProfileTitle=driver.getTitle();
		System.out.println("The Title of the Page is:"+ProfileTitle);
		Assert.assertEquals(ProfileTitle,"Customer Profile | Awesome Pet's");
	}
	
	public void VerifyHistoryTitle() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("HISTORY")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		String HistoryTitle=driver.getTitle();
		System.out.println("The Title of the Page is:"+HistoryTitle);
		Assert.assertEquals(HistoryTitle,"Order History | Awesome Pet's");
	}
	
	public void VerifyManageAutoOrderTitle() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("MANAGE AUTO-ORDER")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		String ManageAutoOrderTitle=driver.getTitle();
		System.out.println("The Title of the Page is:"+ManageAutoOrderTitle);
		Assert.assertEquals(ManageAutoOrderTitle,"Auto Orders | Awesome Pet's");
	}
	
	
	public void VerifyManageAddressTitle(){
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.findElement(By.xpath("//a[text()=' Manage Addresses ']")).click();
		String ManageAddressTitle=driver.getTitle();
		System.out.println("The Title of the Page is:"+ManageAddressTitle);
		Assert.assertEquals(ManageAddressTitle,"Address List | Awesome Pet's");
	}
	
	public void VerifyChangePasswordTitle(){
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.findElement(By.xpath("//a[text()=' Change Password ']")).click();
		String ChangePasswordTitle=driver.getTitle();
		System.out.println("The Title of the page:"+ChangePasswordTitle);
		Assert.assertEquals(ChangePasswordTitle,"Change Password | Awesome Pet's");
	}
	
	public void ClickEmptyUpdateProfileButton() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
			String PageTitle=driver.findElement(By.xpath("//h2[text()='Account Information']")).getText();
			System.out.println("The Current Page is:"+PageTitle);
			driver.findElement(By.xpath("//input[@value='Update']")).click();
			Thread.sleep(5000);
		
	}}
	
	public void CheckValidFieldsInputProfile() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				}
		WebElement AccountField=driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		String AccountValue=AccountField.getAttribute("value");
		System.out.println("The Value is:"+AccountValue);
		Thread.sleep(5000);
		
	}
	}
	
	public void RemoveFirstNameAndUpdate() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='id_first_name']")).getText();
		driver.findElement(By.xpath("//input[@id='id_first_name']")).clear();
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String FirstNameValidation=driver.findElement(By.xpath("(//span[@class='text-danger'])[1]")).getText();
		System.out.println("The Validation Error is:"+FirstNameValidation);
		Assert.assertEquals(FirstNameValidation,"This field is required." );
		Thread.sleep(5000);
	}
	
	public void MaximumInputFirstNameAndUpdate() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='id_first_name']")).getText();
		driver.findElement(By.xpath("//input[@id='id_first_name']")).clear();
		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("This is a New Long length of the character to enter "
				+ "in the First Name Field I think this will not work");
		String FirstNameInputLength=driver.findElement(By.xpath("//input[@id='id_first_name']")).getText();
		System.out.println("The Entered input is:"+FirstNameInputLength);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(5000);
		
	}
	
	public void RemoveLastNameAndUpdate() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		String LastName=driver.findElement(By.xpath("//input[@id='id_last_name']")).getText();
		System.out.println("The Last Name is:"+LastName);
		driver.findElement(By.xpath("//input[@id='id_last_name']")).clear();
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String LastNameValidation=driver.findElement(By.xpath("(//span[@class='text-danger'])[2]")).getText();
		System.out.println("The Validation Error is:"+LastNameValidation);
		Assert.assertEquals(LastNameValidation,"This field is required." );
		Thread.sleep(5000);
	}
	
	
	public void MaximumInputLastNameAndUpdate() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='id_last_name']")).clear();
		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("This is a New Long length of the character "
				+ "to enter in the Last Name Field I think this will not work");
		String LastNameInputLength=driver.findElement(By.xpath("//input[@id='id_last_name']")).getText();
		System.out.println("The String entered is:"+LastNameInputLength);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(5000);
	}
	
	public void RemovePhoneNumberAndUpdate() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		String PhoneNumberInput=driver.findElement(By.xpath("//input[@id='id_phone']")).getText();
		driver.findElement(By.xpath("//input[@id='id_phone']")).clear();
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String PhoneNumberValidation=driver.findElement(By.xpath("(//span[@class='small text-muted'])[2]")).getText();
		Assert.assertEquals(PhoneNumberValidation,"No special characters allowed, and there should be 10 digits" );
		System.out.println("The Validation message is:"+PhoneNumberValidation);
		Thread.sleep(5000);
	}
	
	public void VerifyInputLimitationPhoneNumberField() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='id_phone']")).clear();
		driver.findElement(By.xpath("//input[@id='id_phone']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String PhoneNumberValidation=driver.findElement(By.xpath("(//span[@class='small text-muted'])[2]")).getText();
		System.out.println("The validation message is:"+PhoneNumberValidation);
		Assert.assertEquals(PhoneNumberValidation,"No special characters allowed, and there should be 10 digits" );
		Thread.sleep(5000);
		
	}
	
	public void RemoveRewardIdAndUpdate() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		String RewardIdInput=driver.findElement(By.xpath("//input[@id='id_custom_rewards_id']")).getText();
		System.out.println("The Reward ID field contains:"+RewardIdInput);
		driver.findElement(By.xpath("//input[@id='id_custom_rewards_id']")).clear();
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String Message=driver.findElement(By.xpath("//div[@class='alertinner wicon']")).getText();
		System.out.println("The Result is:"+Message);
		Assert.assertEquals(Message,"Profile Successfully Updated" );
	}
	
	public void MaximumLimitRewardIdField() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='id_custom_rewards_id']")).clear();
		driver.findElement(By.xpath("//input[@id='id_custom_rewards_id']")).sendKeys("1234567890123456789012345");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
	}
	
	public void validationMessageRewardIDField() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='id_custom_rewards_id']")).clear();
		driver.findElement(By.xpath("//input[@id='id_custom_rewards_id']")).sendKeys("@#$%");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String RewardIDValiation=driver.findElement(By.xpath("(//span[@class='text-danger'])[4]")).getText();
		System.out.println("The validaiton Message:"+RewardIDValiation);
		Assert.assertEquals(RewardIDValiation, "This field should contain only letters and numbers. No special characters are allowed");
		
	}
	
	public void UploadProfilePicture() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		WebElement upload=driver.findElement(By.xpath("//div[@class='avatar-edit']//label[text()='Browse']"));
		upload.sendKeys("C:\\Users\\ADMIN\\Desktop\\Excel Sheets\\Image.png");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(4000);
	}
	
	public void VerifyProfileInputFields(String FirstName,String LastName,String PhoneNumber,String RewardID) throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		List<WebElement> button=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		System.out.println("The Number option in the Drop-Down are:"+button.size());
		for(int i=0;i<button.size();i++){
			System.out.println("The Option is:"+button.get(i).getText());
			if(button.get(i).getText().contains("PROFILE")){
				button.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='id_first_name']")).clear();
		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@id='id_last_name']")).clear();
		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@id='id_phone']")).clear();
		driver.findElement(By.xpath("//input[@id='id_phone']")).sendKeys(PhoneNumber);
		driver.findElement(By.xpath("//input[@id='id_custom_rewards_id']")).clear();
		driver.findElement(By.xpath("//input[@id='id_custom_rewards_id']")).sendKeys(RewardID);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		}
	
	public void VerifyTheStoredAddress(){
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.findElement(By.xpath("//a[text()=' Manage Addresses ']")).click();
		List<WebElement> AddressList=driver.findElements(By.xpath("//div[@class='col-sm-12']//address//p"));
		System.out.println("The Total Number of address in First Page is:"+AddressList.size());
		for(int i=0;i<AddressList.size();i++){
			System.out.println("The Addresses are:"+AddressList.get(i).getText());
			if(i>=5){
				driver.findElement(By.xpath("//a[text()='Next']")).click();
				List<WebElement> AddressList1=driver.findElements(By.xpath("//div[@class='col-sm-12']//address//p"));
				System.out.println("The Total Number of address in this page is:"+AddressList1.size());
				for(int j=0;j<AddressList1.size();j++){
					System.out.println("The Addresses are:"+AddressList1.get(j).getText());
				}
			}
		}
	}
	
	public void MakeDefaultAddressMethod() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.findElement(By.xpath("//a[text()=' Manage Addresses ']")).click();
		List<WebElement> AddressList=driver.findElements(By.xpath("//div[@class='col-sm-12']//address//p"));
		System.out.println("The Total Number of address in First Page is:"+AddressList.size());
		for(int i=0;i<AddressList.size();i++){
			System.out.println("The Addresses are:"+AddressList.get(i).getText());
			if(AddressList.get(i).getText().contains("Thomas")){
				System.out.println("The Size is"+i);
				driver.findElement(By.xpath("(//div[@class='col-sm-12'])["+ ++i  +"]//div//a[@id='address-edit']")).click();
				driver.findElement(By.xpath("(//ul[@class='dropdown-menu']//li//a[text()='Make Default'])[3]")).click();
				Thread.sleep(5000);
				try {
				    WebDriverWait wait = new WebDriverWait(driver, 2);
				    wait.until(ExpectedConditions.alertIsPresent());
				    Alert alert = driver.switchTo().alert();
				    Thread.sleep(5000);
				    String AlertMessage=driver.switchTo().alert().getText();
				    System.out.println("The Alert Contains:"+AlertMessage);
				    alert.accept();
				} catch (Exception e) {
				    //exception handling
				break;}

			}
			if(i>=5){
				driver.findElement(By.xpath("//a[text()='Next']")).click();
				List<WebElement> AddressList1=driver.findElements(By.xpath("//div[@class='col-sm-12']//address//p"));
				System.out.println("The Total Number of address in this page is:"+AddressList1.size());
				for(int j=0;j<AddressList1.size();j++){
					System.out.println("The Addresses are:"+AddressList1.get(j).getText());
				}
			}
		}
	}
	
	
	public void ListManageAddress(){
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.findElement(By.xpath("//a[text()=' Manage Addresses ']")).click();
		List<WebElement> AddressList=driver.findElements(By.xpath("//div[@class='col-sm-12']//address//p"));
		System.out.println("The Total Number of address in First Page is:"+AddressList.size());
		for(int i=0;i<AddressList.size();i++){
			System.out.println("The Addresses are:"+AddressList.get(i).getText());
			if(i>=5){
				driver.findElement(By.xpath("//a[text()='Next']")).click();
				List<WebElement> AddressList1=driver.findElements(By.xpath("//div[@class='col-sm-12']//address//p"));
				System.out.println("The Total Number of address in Second page is:"+AddressList1.size());
				for(int j=0;j<AddressList1.size();j++){
					System.out.println("The Addresses are:"+AddressList1.get(j).getText());
					if(j>=5){
						driver.findElement(By.xpath("//a[text()='Next']")).click();
						List<WebElement> AddressList2=driver.findElements(By.xpath("//div[@class='col-sm-12']//address//p"));
						System.out.println("The Total Number of address in Third page is:"+AddressList2);
					}
				}
			}
		}
	}
	
	public void CheckAddNewAddressButton() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.findElement(By.xpath("//a[text()=' Manage Addresses ']")).click();
		driver.findElement(By.xpath("//a[text()='Add New ']")).click();
		Thread.sleep(4000);
	}
	
	public void CheckAddNewAddressPageTitle(){
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.findElement(By.xpath("//a[text()=' Manage Addresses ']")).click();
		driver.findElement(By.xpath("//a[text()='Add New ']")).click();
		String NewAddressPageTitle=driver.getTitle();
		System.out.println("The Title of the page is:"+NewAddressPageTitle);
		Assert.assertEquals(NewAddressPageTitle, "Add Address | Awesome Pet's");
	}
	
	public void ClickEmptyAddressSaveButton() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.findElement(By.xpath("//a[text()=' Manage Addresses ']")).click();
		driver.findElement(By.xpath("//a[text()='Add New ']")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-default']")).click();
		Thread.sleep(5000);
	}
	
	public void CheckFirstNameValidationMessage() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.findElement(By.xpath("//a[text()=' Manage Addresses ']")).click();
		driver.findElement(By.xpath("//a[text()='Add New ']")).click();
		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("LastName");
		driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("lothi garden street");
		driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Cucu road");
		driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("hanalei");
		driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
		driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
		driver.findElement(By.xpath("//input[@class='btn btn-default']")).click();  
		Thread.sleep(5000);
		String FirstNameValidaiton=driver.findElement(By.xpath("(//span[@class='text-danger'])[1]")).getText();
		System.out.println("The FirstName validation is:"+FirstNameValidaiton);
		Assert.assertEquals(FirstNameValidaiton, "This field is required.");
	} 
	 
	
	public void ExistingAddressValidation() throws InterruptedException{
		driver.findElement(By.xpath("//a[@id='dropdownMenu1']")).click();   
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.findElement(By.xpath("//a[text()=' Manage Addresses ']")).click(); 
		driver.findElement(By.xpath("//a[text()='Add New ']")).click();
		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("FirstNameFirstNameFirstNameFirstNameLastName");
		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("LastName");
		driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("lothi garden street");
		driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Cucu road");
		driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("hanalei");
		driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
		driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
		driver.findElement(By.xpath("//input[@class='btn btn-default']")).click();
		Thread.sleep(5000);
		String ErrorValidation=driver.findElement(By.xpath("//div[@class='alert alert-danger mt-20 mb-20']")).getText();
		System.out.println("The Validation is:"+ErrorValidation);
		Assert.assertEquals(ErrorValidation, "This address is already in your address book");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	}
