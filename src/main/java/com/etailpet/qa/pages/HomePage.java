package com.etailpet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etailpet.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//HomePageLogo
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement HomePageLogo;
	
	//Shop Item Button
	@FindBy(xpath="//a[contains(text(),'SHOP ITEMS')]")
	WebElement ShopItemButton;
	
	//Change Store Button
	@FindBy(xpath="//a[contains(text(),'Change Store')]")
	WebElement ChangeStoreButton;
	
	//SearchTab
	@FindBy(xpath="//input[@id='header_search']")
	WebElement SearchTab; 
	
	//LocationView button
	@FindBy(xpath="//a[contains(text(),'Hanalei')]")
	WebElement LocationViewButton;
	
	//ID TAGS & ACCESSORIES Drop-Down
	@FindBy(xpath="//a[contains(text(),'ID TAGS & ACCESSORIES')]")
	WebElement AccessoriesDropDown;
	
	//Customer's Details 
	@FindBy(xpath="//a[@id='dropdownMenu1']")
	WebElement CustomerDetails;
	
	//BARK CONTROL & REMOTE TRAINING Link
	@FindBy(xpath="//a[contains(text(),'BARK CONTROL & REMOTE TRAINING')]")
	WebElement BarkControlLink;
	
	//CRUNCY TREATS FOR CATS Link
	@FindBy(xpath="//a[contains(text(),'CRUNCY TREATS FOR CATS')]")
	WebElement CruncyTreatsLink;  
	
	//Cartbutton
	@FindBy(xpath="//span[contains(@id,'cartCount')]")
	WebElement CartButton;
	
	//Cntact Number
	@FindBy(xpath="//span[contains(text(),'360-675-9646')]")
	WebElement ContactNumberLabel;
	
	//AddressLabel
	@FindBy(xpath="//span[contains(text(),'5-5161 Kuhio Hwy,, Hanalei, HI, 96714')]")
	WebElement AddressLabel;
	
	//Initializing the Page Obects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String VerifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public SearchPage VerifySearchTab(){
		 SearchTab.sendKeys("Acana");
		 return new SearchPage();
	}
	
	public CustomerDetailsPage VerifyCustomerDetails(){
		CustomerDetails.click();
		return new CustomerDetailsPage();         
	}
	
	public boolean VerifyHomePageLogo(){
		return HomePageLogo.isDisplayed();
	}
	
	public boolean VerifyStoreContactlabel(){
		return ContactNumberLabel.isDisplayed();
	}
	
	public boolean verifyStoreAddressLabel(){
		return AddressLabel.isDisplayed();
	}
	
	public ShopItemPage ClickOnShopItemLink(){
		ShopItemButton.click();
		return new ShopItemPage();
	}  
	
	public ChangeStorePage ClickOnChangeStoreButton(){
		ChangeStoreButton.click();
		return new ChangeStorePage();
	}
	
	public ViewLocationPage ClickOnViewLocationButton(){
		LocationViewButton.click();
		return new ViewLocationPage();
	}
	                                                                                                              
}
 