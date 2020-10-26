package com.etailpet.qa.pages;

import java.util.List;    

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.etailpet.qa.base.TestBase;

public class ChangeStorePage extends TestBase {
	
	//Object Repository
	//Change Store Button
	@FindBy(xpath="//a[contains(text(),'Change Store')][1]")
	WebElement ChangeStoreBtn;
	
	//Search Bar inside the Change Store
	@FindBy(xpath="//input[contains(@id,'autocomplete')]")
	WebElement SearchStoreField;
	
	//Click on the store name
	@FindBy(xpath="//a[text()='Awesome Florida1']")
	WebElement Clickstorename;
	
	//Click on the Shop the Store button
	@FindBy(xpath="//a[contains(text(),'Shop this store')]")
	WebElement ShopThisStoreButton;
	
	//Next button- Bottom of the page.
	@FindBy(xpath="//a[text()='Next']")
	WebElement NextBtn;
	
	//Actions
	public void ChangeStore(String Store){
	WebElement StoreElement=driver.findElement(By.xpath("//a[text()='"+Store+"']/parent::h4/parent::div/following-sibling::div//a[text()='Shop this store']"));
	StoreElement.click();
	}
	
	public void SearchInChangeStore(String SearchStoreName) throws InterruptedException{
	WebElement SearchElement=driver.findElement(By.xpath("//input[contains(@id,'autocomplete')]"));
	SearchElement.sendKeys(SearchStoreName);
	SearchElement.sendKeys(Keys.ENTER);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[contains(text(),'Shop this store')][1]")).click();
	
	}
	
	public void ChangeStoreLocation(){
		driver.findElement(By.xpath("(//li//a[text()='Change Store'])[1]")).click();
	}
	
	
	public void ChangeStoreAndCompletePayment(String SearchStoreName,String SelectByBrandDeliveryMethod) throws InterruptedException{
		WebElement SearchElement=driver.findElement(By.xpath("//input[contains(@id,'autocomplete')]"));
		SearchElement.sendKeys(SearchStoreName);
		SearchElement.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Shop this store')][1]")).click();
		driver.findElement(By.xpath("//div[@class='main-hover-navbar hidden-xs']//div//ul//li[@class='shop-now']//a[text()='SHOP ITEMS']")).click();
		boolean status=true;
		driver.findElement(By.xpath("//a[text()='Acana']")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'prdct-detail-box')])[1]")).click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("2");
		driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
		driver.findElement(By.xpath("//b[contains(text(),'VIEW CART')]")).click();
		while(status){
		if(SelectByBrandDeliveryMethod.contains("Store Pickup")){
			driver.findElement(By.xpath("//span[contains(text(),'Store Pickup')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
			driver.findElement(By.xpath("//button[text()='Continue']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='row form-group check-avail-box']/div/button[text()='Continue']")).click();
			Thread.sleep(5000);
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Auto order')]/i/following::div/following::div/following::div/following::div/following::div/div//button[@type='submit']"))).click();
			driver.findElement(By.xpath("//input[@id='name-element']")).sendKeys("Elon");
			driver.switchTo().frame("__privateStripeFrame5");
			driver.findElement(By.xpath("(//input[@name='cardnumber'])[1]")).sendKeys("4111111111111111");
			driver.switchTo().parentFrame();
			driver.switchTo().frame("__privateStripeFrame6");
			driver.findElement(By.xpath("//input[@name='exp-date']")).sendKeys("0925");
			driver.switchTo().parentFrame(); 
			driver.switchTo().frame("__privateStripeFrame7");
			driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("897");
			driver.switchTo().parentFrame();
			driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("96714");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='row form-group check-avail-box']//following-sibling::div//button[@type='submit']")).click();
			boolean result1 = false;
		    int attempts = 0;
		    while(attempts < 2) {
		        try {
		          WebElement button1=  driver.findElement(By.xpath("//button[@class='btn btn-default data-loader']"));
		          button1.click();
		            result1 = true;
		            break;
		        } catch(StaleElementReferenceException e) {
		        }
		        attempts++;
		    }
		    return;}
	}
	
	

}}
