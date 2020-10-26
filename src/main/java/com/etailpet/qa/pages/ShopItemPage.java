package com.etailpet.qa.pages;

import java.awt.Checkbox;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.etailpet.qa.base.TestBase;

public class ShopItemPage extends TestBase{
	
	SignInPage signInPage;
	HomePage homePage;
	
	//Object Repository for Shop Item Page.
	//Search Within Result
	@FindBy(xpath="//input[@name='query']")
	WebElement SearchWithinResult;
	
	//ShopItem button                     
	@FindBy(xpath="//a[@class='shopnow-nav']")
	WebElement ShopItemButton;
	
	
	//Click Search Button
	@FindBy(xpath="//i[contains(@class,'flaticon-search')]")
	WebElement SearchEnterButton;
	
	//Choose Filters
	@FindBy(xpath="//span[contains(text(),'In-store Pickup')]")
	WebElement SelectFilter;
	
	//Choose Sort By
	@FindBy(xpath="//select[contains(@name,'price-filter')]")
	WebElement SortByDropDown;     
	
	//Select Category
//	@FindBy(xpath="//button[contains(@class,'btn btn-default dropdown-toggle')]")
//	WebElement SelectCategory;
	
	//Clear Filter button
	@FindBy(xpath="//a[contains(text(),'Clear Filters')]")
	WebElement ClearFilter; 
	
	//Stop Item Page Logo
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement ShopItemPageLogo;
	
	//Cartbutton
	@FindBy(xpath="//span[contains(@id,'cartCount')]")
	WebElement CartButton;
	
	//Add to cart from quantity page
	@FindBy(xpath="//button[text()='Add to cart ']")
	WebElement AddToCartBtn;
	
	//View Cart button
	@FindBy(xpath="//b[text()='VIEW CART']")
	WebElement ViewCartBtn;
	
	//Proceed CheckOut Button
	@FindBy(xpath="//a[@id='add-cart-btn']")
	WebElement CheckOutBtn;
	
	//Complete Order Button
	@FindBy(xpath="//button[@class='btn btn-default data-loader']")
	WebElement CompleteOrderBtn;
	
	


	
	//Initiating the Page Objects
	public ShopItemPage(){
		PageFactory.initElements(driver, this);  
	}    
	
	//Actions
	public String CheckShopItemTitle(){
		return driver.getTitle();
	}
	
	public boolean CheckShopItemPageLogo(){
		return ShopItemPageLogo.isDisplayed();
	}
	
	public CartPage ClickOnCartItemLink(){
		CartButton.click();
		return new CartPage();
	}
	
	public void CheckSearchWithinResult(){
		SearchWithinResult.sendKeys("Acana");
		SearchEnterButton.click();
		
	}
	
	
	
	public void CheckFilterCheckBox(String name){ 
		driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]")).click();
	}
	    
	public ShopItemPage CheckClearFiltersButton(String name){
		driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]")).click();        
		ClearFilter.click();
		return new ShopItemPage();
	}
	         
	public void CheckSortBy(String name){
		 Select SortBy=new Select(SortByDropDown);
		 SortBy.selectByVisibleText(name);
	}
	
	public void CheckSelectCategory(String name){
		List<WebElement> dropdown_list=driver.findElements(By.xpath("//button[contains(@class,'simplebar-scroll-content')]"));
		System.out.println("The Total Values in the drop are"+dropdown_list);   
		for(int i=0;i<dropdown_list.size();i++){        
			System.out.println(dropdown_list.get(i).getText());
			if(dropdown_list.get(i).getText().contains("Bird"))
				dropdown_list.get(i).click();
			}
		}
	
	      
	public void CheckSelectBrand(String brand){
		driver.findElement(By.xpath("//a[contains(text(),'"+brand+"')]")).click();
	}
	
	public PaymentPage SelectProductBrand(String StoreName,String BrandName,String ProductName,String ProductQuan,String DeliveryMethod) throws InterruptedException{
		driver.findElement(By.xpath("//a[text()='Change Store'][1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+StoreName+"')]/parent::h4/parent::div//following-sibling::div//a[text()='Shop this store']")).click();
		driver.findElement(By.xpath("//a[text()='SHOP ITEMS'][1]")).click();
		driver.findElement(By.xpath("//a[text()='"+BrandName+"']")).click();
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']/parent::h3/parent::div//a[text()='Add to cart']")).click();
        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(ProductQuan);
        AddToCartBtn.click();
        ViewCartBtn.click();
		driver.findElement(By.xpath("//span[text()='"+DeliveryMethod+"']")).click();
		Thread.sleep(5000);
        CheckOutBtn.click();       
        return new PaymentPage();
	}
	
	public void SearchProduct(String ProductToSearch,String ProductQuantity,String DeliveryMethodAfterSearch,String FirstName,String LastName,
			String AddressLine1,String AddressLine2,String City,String State,String ZipCode,String HolderName,String CardNumber,String cvv, 
			String ExpireDate,String PostCode) throws InterruptedException{
        String result = null;
		  boolean status=true;
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//input[@id='header_search']")).sendKeys(ProductToSearch);
		  driver.findElement(By.xpath("//button[@class='btn'][1]")).click();
		  Thread.sleep(5000);
		  while(status){
			  result=driver.findElement(By.xpath("(//div[@class='prdct-detail-box']//following-sibling::h3)")).getText();
			  if(result.equals(ProductToSearch)){
			  driver.findElement(By.xpath("(//div[@class='prdct-detail-box']//following-sibling::h3)")).click();
			  driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		               driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(ProductQuantity); 
              driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
              driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
              List<WebElement> checkbox=driver.findElements(By.xpath("//div[@class='left-sec']//following-sibling::ul//div[@class='checkbox']"));
      		  //WebElement checkbox=driver.findElement(By.xpath("//span[text()='"+DeliveryMethodAfterSearch+"']"));
              System.out.println("The Total number of elements"+checkbox.size());
              for(int i=0;i<=checkbox.size();i++){
            	  System.out.println("The List is "+checkbox.get(i).getText());
            	  if(checkbox.get(i).getText().startsWith(DeliveryMethodAfterSearch)){
            		  checkbox.get(i).click();
          			  System.out.println("The delivery method is selected");            		  
            	  }
            	  else{
            		  Thread.sleep(5000);
          			  driver.findElement(By.xpath("//i[@class='flaticon-cancel']")).click();
          			  System.out.println("The Delivery method is not available");
          			  driver.close(); 
            	  }
              }
               driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
      		  Thread.sleep(5000);}
              else
              { 
            	  System.out.println("There is a Problem");}

      		  System.out.println("The Product searched- "+ProductToSearch+" is matching with the Result:"+result);
			  Thread.sleep(5000);

			  Thread.sleep(5000);
			  status=false;
		  }}

public void SearchProductMethod(String ProductToSearch,String ProductQuantity,String DeliveryMethodAfterSearch) throws InterruptedException{
	String Delivery = null;
	int i;
	driver.findElement(By.xpath("//input[@id='header_search']")).sendKeys(ProductToSearch);
	driver.findElement(By.xpath("(//button[@class='btn'])[1]")).click();
	WebElement result=driver.findElement(By.xpath("(//div[@class='prdct-detail-box']//following-sibling::h3)"));
	System.out.println(result.getText());
	if(result.getText().contains(ProductToSearch)){
		System.out.println("Searched Item is matching with the result.");
		result.click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
	    driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(ProductQuantity);
        driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
        driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        List<WebElement> method=driver.findElements(By.xpath("//div[@class='left-sec']//following-sibling::ul//div[@class='checkbox']"));
        System.out.println("The List is:"+method.size());
        for(i=0;i<method.size();i++){
        	System.out.println("The List are:"+method.get(i).getText()); 
        	
        	if(method.get(i).getText().startsWith(DeliveryMethodAfterSearch)){
        		driver.findElement(By.xpath("//span[text()='"+DeliveryMethodAfterSearch+"']")).click();
        		Thread.sleep(5000); 
        	
        		
        		if(DeliveryMethodAfterSearch.contains("Store Pickup")){
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//button[text()='Continue']")).click();
        			driver.findElement(By.xpath("//div[@class='col-sm-4 mb-10']")).click();
        			driver.findElement(By.xpath("//button[text()='Continue']")).click();
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
        			driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("96722");
        			Thread.sleep(2000);
        			WebElement button=driver.findElement(By.xpath(" //div[@class='row form-group check-avail-box']//div//button[text()='Continue']"));
        			button.click();
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
        		else if(DeliveryMethodAfterSearch.contains("Home Delivery")){
        				driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        				driver.findElement(By.xpath("//button[text()='Continue']")).click();
        				driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
        				driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
        				driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
        				driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
        				driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
        				driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
        				driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
        				Thread.sleep(3000);
        				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(text(),'Save & Continue')]")).click();
        				Thread.sleep(3000);
        				driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
        				Thread.sleep(3000);
        				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
            			Thread.sleep(2000);
            			driver.findElement(By.xpath("//div[@class='row form-group check-avail-box']//following-sibling::div//button[contains(@type,'submit')]")).click();
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
        		
        			
        		
        	}else{
    			System.out.println("The Delivery method is not matching");
    		}
        

	}}
	else{
		System.out.println("Product Not Matching");
	}

	
}
public void SelectByCategory() throws InterruptedException{ 
	WebElement category=driver.findElement(By.xpath("//button[contains(@id,'category-select')]"));
	category.click();
	List<WebElement> dropdown=driver.findElements(By.xpath("//div[@class='simplebar-content']//following-sibling::li"));
	System.out.println("Total number of options"+dropdown.size());
	for(int i=0;i<dropdown.size();i++){
		System.out.println(dropdown.get(i).getText());
		if(dropdown.get(i).getText().startsWith("Dog")){
			System.out.println("If is Working");
			dropdown.get(i).click();
			Thread.sleep(2000);
		}
		else{
			System.out.println("Else is working");
			//dropdown.get(1).click();
			Thread.sleep(1000);
		}break;
	}
	Thread.sleep(5000);
}

public void SelectByBrand(String SelectByBrand,String SelectByBrandQuantity,String SelectByBrandDeliveryMethod) throws InterruptedException{
	boolean status=true;
	driver.findElement(By.xpath("//a[contains(text(),'"+SelectByBrand+"')]")).click();
	driver.findElement(By.xpath("(//div[contains(@class,'prdct-detail-box')])[1]")).click();
	driver.findElement(By.xpath("//input[@name='quantity']")).clear();
	driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(SelectByBrandQuantity);
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
	else if(SelectByBrandDeliveryMethod.contains("Local Delivery")){
		driver.findElement(By.xpath("//span[text()='Local Delivery']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click(); 
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
		driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
		driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
		driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     	
		driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
		driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
		driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
		//driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
	else if(SelectByBrandDeliveryMethod.contains("Ship to Me")){
	    driver.findElement(By.xpath("//span[text()='Ship to Me']")).click();
	    driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click();
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
		driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
		driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
		driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
		driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
		driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
		driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
	else{
		System.out.println("The Delivery Method is not matching...");
	}
	status=false;
	
	}
}

public void SelectByDeliveryMethod(String SelectByDeliveryMethod) throws InterruptedException{
	if(SelectByDeliveryMethod.contains("Store Pickup")){{
	driver.findElement(By.xpath("//span[contains(text(),'Store Pickup')]")).click(); }
	driver.findElement(By.xpath("(//a[@class='btn brand-bg-green cart-btn'])[1]")).click();
	driver.findElement(By.xpath("//input[@name='quantity']")).clear();
	driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("3");
	driver.findElement(By.xpath("//button[@class='btn add-cart-btn']")).click();          
	driver.findElement(By.xpath("//b[contains(text(),'VIEW CART')]")).click();                      
	
		boolean result1 = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	          WebElement button1=  driver.findElement(By.xpath("//span[contains(text(),'Store Pickup')]"));
	          button1.click();
	            result1 = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        	System.out.println("The Selected Delivery Method-'"+SelectByDeliveryMethod+"'-is not matching with the available delivery of the selected product");
	        }
	        attempts++;
	    }
	    return;}
	else if(SelectByDeliveryMethod.contains("Local Delivery")){
		driver.findElement(By.xpath("//span[contains(text(),'Local Delivery')]")).click();
		driver.findElement(By.xpath("(//a[@class='btn brand-bg-green cart-btn'])[1]")).click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("3");
		driver.findElement(By.xpath("//button[@class='btn add-cart-btn']")).click();
		driver.findElement(By.xpath("//b[contains(text(),'VIEW CART')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Local Delivery')]")).click();
		driver.findElement(By.xpath("//div[@class='cart-price-wrap']/div/following::div/a[@id='add-cart-btn']")).click();
		driver.findElement(By.xpath("//button[text()='Continue']")).click();      
		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
		driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
		driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
		driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
		driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
		driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
		driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(text(),'Save & Continue')]")).click();
		WebDriverWait cont=new WebDriverWait(driver,20);
		cont.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]"))).click();
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
		driver.findElement(By.xpath("//div[@class='col-sm-8']/div/div/div/following::form/div/following::div/following::div/following::"
				+ "div/following::div/following::div/following::div/following::div/following::div/following::"
				+ "div/following::div/following::div/following::div/following::div/div/button[@type='submit']")).submit();
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
	else if(SelectByDeliveryMethod.contains("Ship to Me")){
		driver.findElement(By.xpath("//span[text()='Ship to Me']")).click();
		driver.findElement(By.xpath("(//a[@class='btn brand-bg-green cart-btn'])[1]")).click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("3");
		driver.findElement(By.xpath("//button[@class='btn add-cart-btn']")).click();
		driver.findElement(By.xpath("//b[contains(text(),'VIEW CART')]")).click();
		List<WebElement> method=driver.findElements(By.xpath("//div[@class='left-sec']//following-sibling::ul//div[@class='checkbox']"));
        System.out.println("The List is:"+method.size());
        for(int i=0;i<method.size();i++){
        	System.out.println("The List are:"+method.get(i).getText()); 
        	
        	if(method.get(i).getText().equals("Ship to Me")){
        		driver.findElement(By.xpath("//span[text()='Ship to Me']")).click();
        		driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click();
        		driver.findElement(By.xpath("//button[text()='Continue']")).click();
        		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
        		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
        		driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
        		driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
        		driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
        		driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
        		driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
        		driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
        		driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
        		driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
        		driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
        	else{
        		System.out.println("The Delivery Method "+SelectByDeliveryMethod+" is not applicable for the selected product");
        	}

}
}
}

public void PromoCodeCheckOut(String PromoProduct,String PromoProductQuantity,String PromoDeliveryMethod,String PromoCode) throws InterruptedException{
	String Delivery = null;
	int i;
	driver.findElement(By.xpath("//input[@id='header_search']")).sendKeys(PromoProduct);
	driver.findElement(By.xpath("(//button[@class='btn'])[1]")).click();
	WebElement result=driver.findElement(By.xpath("(//div[@class='prdct-detail-box']//following-sibling::h3)"));
	System.out.println(result.getText());
	if(result.getText().contains(PromoProduct)){
		System.out.println("Searched Item is matching with the result.");
		result.click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
	    driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(PromoProductQuantity);
        driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
        driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        List<WebElement> method=driver.findElements(By.xpath("//div[@class='left-sec']//following-sibling::ul//div[@class='checkbox']"));
        System.out.println("The List is:"+method.size());
        for(i=0;i<method.size();i++){
        	System.out.println("The List are:"+method.get(i).getText()); 
        	
        	if(method.get(i).getText().startsWith(PromoDeliveryMethod)){
        		driver.findElement(By.xpath("//span[text()='"+PromoDeliveryMethod+"']")).click();
        		Thread.sleep(5000); 
        	
        		
        		if(PromoDeliveryMethod.contains("Store Pickup")){
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(PromoCode,Keys.ENTER);
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//button[text()='Continue']")).click();
        			driver.findElement(By.xpath("//div[@class='col-sm-4 mb-10']")).click();
        			driver.findElement(By.xpath("//button[text()='Continue']")).click();
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
        			driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("96722");
        			Thread.sleep(2000);
        			WebElement button=driver.findElement(By.xpath(" //div[@class='row form-group check-avail-box']//div//button[text()='Continue']"));
        			button.click();
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
        		else if(PromoDeliveryMethod.contains("Local Delivery")){
        				driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        				driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(PromoCode,Keys.ENTER);
            			Thread.sleep(2000);
        				driver.findElement(By.xpath("//button[text()='Continue']")).click();
        				driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
        				driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
        				driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
        				driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
        				driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
        				driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
        				driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
        				Thread.sleep(3000);
        				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(text(),'Save & Continue')]")).click();
        				Thread.sleep(3000);
        				driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
        				Thread.sleep(3000);
        				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
            			Thread.sleep(2000);
            			driver.findElement(By.xpath("//div[@class='row form-group check-avail-box']//following-sibling::div//button[contains(@type,'submit')]")).click();
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
        		else if(method.get(i).getText().equals("Ship to Me")){
            		driver.findElement(By.xpath("//span[text()='Ship to Me']")).click();
            		driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click();
            		driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(PromoCode,Keys.ENTER);
        			Thread.sleep(2000);
            		driver.findElement(By.xpath("//button[text()='Continue']")).click();
            		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
            		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
            		driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
            		driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
            		driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
            		driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
            		driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
            		driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
            		driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
            		driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
            		driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
        		
        				
        		
        	}else{
    			System.out.println("The Delivery method is not matching");
    		}
        

	}}
	else{
		System.out.println("Product Not Matching");
	}

	
}

public void RemovePromoCheckOut(String PromoProduct,String PromoProductQuantity,String PromoDeliveryMethod,String PromoCode) throws InterruptedException{
	String Delivery = null;
	int i;
	driver.findElement(By.xpath("//input[@id='header_search']")).sendKeys(PromoProduct);
	driver.findElement(By.xpath("(//button[@class='btn'])[1]")).click();
	WebElement result=driver.findElement(By.xpath("(//div[@class='prdct-detail-box']//following-sibling::h3)"));
	System.out.println(result.getText());
	if(result.getText().contains(PromoProduct)){
		System.out.println("Searched Item is matching with the result.");
		result.click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
	    driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(PromoProductQuantity);
        driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
        driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        List<WebElement> method=driver.findElements(By.xpath("//div[@class='left-sec']//following-sibling::ul//div[@class='checkbox']"));
        System.out.println("The List is:"+method.size());
        for(i=0;i<method.size();i++){
        	System.out.println("The List are:"+method.get(i).getText()); 
        	
        	if(method.get(i).getText().startsWith(PromoDeliveryMethod)){
        		driver.findElement(By.xpath("//span[text()='"+PromoDeliveryMethod+"']")).click();
        		Thread.sleep(5000); 
        	
        		
        		if(PromoDeliveryMethod.contains("Store Pickup")){
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(PromoCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//a[text()='Remove Coupon']")).click();
        			driver.findElement(By.xpath("//button[text()='Continue']")).click();
        			driver.findElement(By.xpath("//div[@class='col-sm-4 mb-10']")).click();
        			driver.findElement(By.xpath("//button[text()='Continue']")).click();
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
        			driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("96722");
        			Thread.sleep(2000);
        			WebElement button=driver.findElement(By.xpath(" //div[@class='row form-group check-avail-box']//div//button[text()='Continue']"));
        			button.click();
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
        		else if(PromoDeliveryMethod.contains("Local Delivery")){
        				driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        				driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(PromoCode);
            			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
            			Thread.sleep(2000);
        				driver.findElement(By.xpath("//button[text()='Continue']")).click();
        				driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
        				driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
        				driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
        				driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
        				driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
        				driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
        				driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
        				Thread.sleep(3000);
        				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(text(),'Save & Continue')]")).click();
        				Thread.sleep(3000);
        				driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
        				Thread.sleep(3000);
        				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
            			Thread.sleep(2000);
            			driver.findElement(By.xpath("//div[@class='row form-group check-avail-box']//following-sibling::div//button[contains(@type,'submit')]")).click();
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
        			    return;           
        				
        			}
        		else if(method.get(i).getText().equals("Ship to Me")){
            		driver.findElement(By.xpath("//span[text()='Ship to Me']")).click();
            		driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click();
            		driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(PromoCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
            		driver.findElement(By.xpath("//button[text()='Continue']")).click();
            		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
            		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
            		driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
            		driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
            		driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
            		driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
            		driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
            		driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
            		driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
            		driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
            		driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
    			    return;
        		}
        		
        			
        		
        	}else{
    			System.out.println("The Delivery method is not matching");
    		}
        

	}}
	else{
		System.out.println("Product Not Matching");
	}

	
}
public void ApplyBuyGet(String BuyGetProduct,String BuyGetProductQuantity,String BuyGetDeliveryMethod,String BuyGetCode) throws InterruptedException{
	String Delivery = null;
	int i;
	driver.findElement(By.xpath("//input[@id='header_search']")).sendKeys(BuyGetProduct);
	driver.findElement(By.xpath("(//button[@class='btn'])[1]")).click();
	WebElement result=driver.findElement(By.xpath("(//div[@class='prdct-detail-box']//following-sibling::h3)"));
	System.out.println(result.getText());
	if(result.getText().contains(BuyGetProduct)){
		System.out.println("Searched Item is matching with the result.");
		result.click();    
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
	    driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(BuyGetProductQuantity);
        driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
        driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        List<WebElement> method=driver.findElements(By.xpath("//div[@class='left-sec']//following-sibling::ul//div[@class='checkbox']"));
        System.out.println("The List is:"+method.size());
        for(i=0;i<method.size();i++){
        	System.out.println("The List are:"+method.get(i).getText()); 
        	
        	if(method.get(i).getText().startsWith(BuyGetDeliveryMethod)){
        		driver.findElement(By.xpath("//span[text()='"+BuyGetDeliveryMethod+"']")).click();
        		Thread.sleep(5000); 
        	 
        		
        		if(BuyGetDeliveryMethod.contains("Store Pickup")){
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//a[text()='here']")).click();
        			driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).clear();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).sendKeys("1");
        			driver.findElement(By.xpath("//div[@class='add-product-box']//button//i[@class='flaticon-commerce']")).click();
        			driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        			driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select']")).click();
        			driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[2]//li//a[text()='"+BuyGetDeliveryMethod+"']")).click();
        			Thread.sleep(5000);
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//button[text()='Continue']")).click();
        			driver.findElement(By.xpath("//div[@class='col-sm-4 mb-10']")).click();
        			driver.findElement(By.xpath("//button[text()='Continue']")).click();
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
        			driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("96722");
        			Thread.sleep(2000);
        			WebElement button=driver.findElement(By.xpath(" //div[@class='row form-group check-avail-box']//div//button[text()='Continue']"));
        			button.click();
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
        		else if(BuyGetDeliveryMethod.contains("Local Delivery")){
    				driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
    				driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//a[text()='here']")).click();
        			driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).clear();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).sendKeys("1");
        			driver.findElement(By.xpath("//div[@class='add-product-box']//button//i[@class='flaticon-commerce']")).click();
        			driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        			driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select']")).click();
        			driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[2]//li//a[text()='"+BuyGetDeliveryMethod+"']")).click();
        			Thread.sleep(5000);
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
    				driver.findElement(By.xpath("//button[text()='Continue']")).click();
    				driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
    				driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
    				driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
    				driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
    				driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
    				driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
    				driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
    				Thread.sleep(3000);
    				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(text(),'Save & Continue')]")).click();
    				Thread.sleep(3000);
    				driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
    				Thread.sleep(3000);
    				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//div[@class='row form-group check-avail-box']//following-sibling::div//button[contains(@type,'submit')]")).click();
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
    			    return;  
    			}
        		else if(method.get(i).getText().equals("Ship to Me")){
            		driver.findElement(By.xpath("//span[text()='Ship to Me']")).click();
            		driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click();
            		driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//a[text()='here']")).click();
        			driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).clear();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).sendKeys("1");                                        
        			driver.findElement(By.xpath("//div[@class='add-product-box']//button//i[@class='flaticon-commerce']")).click();
        			driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        			driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select']")).click();
        			driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[2]//li//a[text()='"+BuyGetDeliveryMethod+"']")).click();
        			Thread.sleep(5000);
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
            		driver.findElement(By.xpath("//button[text()='Continue']")).click();
            		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
            		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
            		driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
            		driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
            		driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
            		driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
            		driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
            		driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
            		driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
            		driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
            		driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
    			    return;
        		}

}

}
	}
}

public void RemoveBuyGet(String BuyGetProduct,String BuyGetProductQuantity,String BuyGetDeliveryMethod,String BuyGetCode) throws Exception{
	String Delivery = null;
	int i;
	driver.findElement(By.xpath("//input[@id='header_search']")).sendKeys(BuyGetProduct);
	driver.findElement(By.xpath("(//button[@class='btn'])[1]")).click();
	WebElement result=driver.findElement(By.xpath("(//div[@class='prdct-detail-box']//following-sibling::h3)"));
	System.out.println(result.getText());
	if(result.getText().contains(BuyGetProduct)){
		System.out.println("Searched Item is matching with the result.");
		result.click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
	    driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(BuyGetProductQuantity);
        driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
        driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        List<WebElement> method=driver.findElements(By.xpath("//div[@class='left-sec']//following-sibling::ul//div[@class='checkbox']"));
        System.out.println("The List is:"+method.size());
        for(i=0;i<method.size();i++){
        	System.out.println("The List are:"+method.get(i).getText()); 
        	
        	if(method.get(i).getText().startsWith(BuyGetDeliveryMethod)){
        		driver.findElement(By.xpath("//span[text()='"+BuyGetDeliveryMethod+"']")).click();
        		Thread.sleep(5000); 
        	
        		
        		if(BuyGetDeliveryMethod.contains("Store Pickup")){
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//a[text()='here']")).click();
        			driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).clear();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).sendKeys("1");
        			driver.findElement(By.xpath("//div[@class='add-product-box']//button//i[@class='flaticon-commerce']")).click();
        			driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        			driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select']")).click();
        			driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[2]//li//a[text()='"+BuyGetDeliveryMethod+"']")).click();
        			Thread.sleep(5000);
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//a[text()='Remove Coupon']")).click();
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//div[@class='col-sm-4']//button[text()='Continue']")).click();
        			driver.findElement(By.xpath("//div[@class='col-sm-4 mb-10']//button[text()='Continue']")).click();
        			driver.findElement(By.xpath("//button[text()='Continue']")).click();
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
        			driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("96722");
        			Thread.sleep(2000);
        			WebElement button=driver.findElement(By.xpath(" //div[@class='row form-group check-avail-box']//div//button[text()='Continue']"));
        			button.click();
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
        		else if(BuyGetDeliveryMethod.contains("Local Delivery")){
    				driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
    				driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//a[text()='here']")).click();
        			driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).clear();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).sendKeys("1");
        			driver.findElement(By.xpath("//div[@class='add-product-box']//button//i[@class='flaticon-commerce']")).click();
        			driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        			driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select']")).click();
        			driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[2]//li//a[text()='"+BuyGetDeliveryMethod+"']")).click();
        			Thread.sleep(5000);
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
    				driver.findElement(By.xpath("//button[text()='Continue']")).click();
    				driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
    				driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
    				driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
    				driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
    				driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
    				driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
    				driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
    				Thread.sleep(3000);
    				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(text(),'Save & Continue')]")).click();
    				Thread.sleep(3000);
    				driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
    				Thread.sleep(3000);
    				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//div[@class='row form-group check-avail-box']//following-sibling::div//button[contains(@type,'submit')]")).click();
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
    			    return;
    			}
        		else if(method.get(i).getText().equals("Ship to Me")){
            		driver.findElement(By.xpath("//span[text()='Ship to Me']")).click();
            		driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click();
            		driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
        			driver.findElement(By.xpath("//a[text()='here']")).click();
        			driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).clear();
        			driver.findElement(By.xpath("//input[@id='id_quantity']")).sendKeys("1");
        			driver.findElement(By.xpath("//div[@class='add-product-box']//button//i[@class='flaticon-commerce']")).click();
        			driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
        			driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select']")).click();
        			driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[2]//li//a[text()='"+BuyGetDeliveryMethod+"']")).click();
        			Thread.sleep(5000); 
        			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
        			driver.findElement(By.xpath("//div[@class='input-group promo-code']//input[@id='id_code']")).sendKeys(BuyGetCode);
        			driver.findElement(By.xpath("//span[@class='input-group-btn']//button[text()='Apply']")).click();
        			Thread.sleep(2000);
            		driver.findElement(By.xpath("//button[text()='Continue']")).click();
            		driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
            		driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
            		driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
            		driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
            		driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
            		driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
            		driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
            		driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
            		driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
            		driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
            		driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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

}
	}
}
public void ApplyPriceSlash(String PriceSlashProduct,String SelectByBrandDeliveryMethod) throws InterruptedException{
	boolean status=true;
	List<WebElement> list=driver.findElements(By.xpath("//ul[@class='level-1-list']//li//div//label//a"));
	System.out.println(list.size());
	for(WebElement webElement :list){
		String name=webElement.getText();
		System.out.println(name);
		if(name.contains(PriceSlashProduct)){
			WebElement slider=driver.findElement(By.xpath("(//div[@class='filter-repeater']/div/div/div[@class='simplebar-scrollbar visible'])[1]"));
			WebElement elemen=driver.findElement(By.xpath("//a[text()='"+PriceSlashProduct+"']"));
			Actions actions=new Actions(driver);
			actions.clickAndHold(slider);
			actions.moveToElement(elemen).build().perform();
			elemen.click();
			Thread.sleep(10000);
			
			
			break;
		}
	}
	
	WebElement slash=driver.findElement(By.xpath("(//div[@class='prdct-detail-box'])[1]//preceding-sibling::div//preceding-sibling::span[text()='Click to reveal the price']"));
	String Tag=slash.getText();
	System.out.println(Tag);
	if(Tag.contains("Click to reveal the price")){
		driver.findElement(By.xpath("(//div[@class='prdct-detail-box'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("3");
		driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
		driver.findElement(By.xpath("//b[contains(text(),'VIEW CART')]")).click();
		while(status){
		if(SelectByBrandDeliveryMethod.contains("Store Pickup")){
			driver.findElement(By.xpath("//span[contains(text(),'Store Pickup')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
			driver.findElement(By.xpath("//button[text()='Continue']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='row form-group check-avail-box']/div/button[text()='Continue']")).click();
			Thread.sleep(1000);
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
		else if(SelectByBrandDeliveryMethod.contains("Local Delivery")){
			String delivery=driver.findElement(By.xpath("//ul[@id='id_form-0-delivery_method']")).getText();
			if(delivery.contains(SelectByBrandDeliveryMethod)){
			driver.findElement(By.xpath("//span[text()='Local Delivery']")).click();
			Thread.sleep(5000);
			}
			else{
				driver.findElement(By.xpath("//i[@class='flaticon-cancel']")).click();
				System.out.println("The Delivery Method is Not Matching with the Delivery Method of the product");
				break;
			}
			driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click(); 
			driver.findElement(By.xpath("//button[text()='Continue']")).click();
			driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
			driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
			driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
			driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
			driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
			driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
			driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
			driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
			driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
			driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
		else if(SelectByBrandDeliveryMethod.contains("Ship to Me")){
		    driver.findElement(By.xpath("//span[text()='Ship to Me']")).click();
		    driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click();
			driver.findElement(By.xpath("//button[text()='Continue']")).click();
			driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
			driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
			driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
			driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
			driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
			driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
			driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
			driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
			driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
			driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
		else{
			System.out.println("The Delivery Method is not matching...");
		}
		status=false;
		
		}

	}
	else{
		System.out.println("The Selected Product Does not Has the PRICE SLASH, PLEASE SELECT OTHER BRAND");
		driver.close();
	}
}

public void VerifyAutoOrderMethod(String AutoOrderDeliveryMethod,String AutoOrderFrequency) throws InterruptedException{
	boolean status=true;
	driver.findElement(By.xpath("//a[text()='Acana']")).click();
	driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]")).click();
	driver.findElement(By.xpath("//input[@id='id_quantity']")).clear();
	driver.findElement(By.xpath("//input[@id='id_quantity']")).sendKeys("10");
	driver.findElement(By.xpath("//button[text()='Add to cart ']")).click();
	driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
	while(status){
		if(AutoOrderDeliveryMethod.contains("Store Pickup")){
			driver.findElement(By.xpath("//span[contains(text(),'Store Pickup')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='add-cart-btn']")).click();
			driver.findElement(By.xpath("//button[text()='Continue']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='row form-group check-avail-box']/div/button[text()='Continue']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//b[text()='Yes, auto-order & save.']")).click();
			Select dropdown=new Select(driver.findElement(By.id("id_frequency")));
			dropdown.selectByVisibleText(AutoOrderFrequency);
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
		else if(AutoOrderDeliveryMethod.contains("Local Delivery")){
			String delivery=driver.findElement(By.xpath("//ul[@id='id_form-0-delivery_method']")).getText();
			if(delivery.contains(AutoOrderDeliveryMethod)){
			driver.findElement(By.xpath("//span[text()='Local Delivery']")).click();
			Thread.sleep(5000);
			}
			else{
				driver.findElement(By.xpath("//i[@class='flaticon-cancel']")).click();
				System.out.println("The Delivery Method is Not Matching with the Delivery Method of the product");
				break;
			}
			driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click(); 
			driver.findElement(By.xpath("//button[text()='Continue']")).click();
			driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
			driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
			driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
			driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
			driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
			driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
			driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
			driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
			driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
			driver.findElement(By.xpath("//b[text()='Yes, auto-order & save.']")).click();
			Select dropdown=new Select(driver.findElement(By.id("id_frequency")));
			dropdown.selectByVisibleText(AutoOrderFrequency);
			driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
		else if(AutoOrderDeliveryMethod.contains("Ship to Me")){
			 try {
		          WebElement delivery=driver.findElement(By.xpath("//span[text()='Ship to Me']"));
		          delivery.click();
		        } catch(NoSuchElementException e) {
		        	System.out.println("The Delivery Method is not Available for the Selected Product.....");
		        	throw new AssertionError("Change the Delivery Method",e);
		        }
		    //driver.findElement(By.xpath("//span[text()='Ship to Me']")).click();
		    driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click();
			driver.findElement(By.xpath("//button[text()='Continue']")).click();
			driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
			driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
			driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
			driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
			driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
			driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
			driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
			driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
			driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
			driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
		else{
			System.out.println("The Delivery Method is not matching...");
		}
		status=false;
		
		}

	}


public void FrequentBuyersCardMethod(String FBCDeliveryMethod) throws InterruptedException{
	driver.findElement(By.xpath("//a[text()='Acana']")).click();
	driver.findElement(By.xpath("(//div[@class='prdct-detail-box'])[1]")).click();
	String ProductName=driver.findElement(By.xpath("(//div[@class='col-sm-6'])[2]//h1")).getText();
	System.out.println("The Selected Product is:"+ProductName);
	List<WebElement> Category=driver.findElements(By.xpath("//div[@class='size-box']//div//div//label"));
	System.out.println("The Total Size is:"+Category.size());
	for(int i=0;i<Category.size();i++){
		System.out.println("The Size are:"+Category.get(i).getText());
		if(Category.get(i).getText().equals("12-lb")){
			System.out.println("Nothing");
			driver.findElement(By.xpath("//a[text()='12-lb']")).click();
			Thread.sleep(4000);
		}
	}
	driver.findElement(By.xpath("//input[@id='id_quantity']")).clear();
	driver.findElement(By.xpath("//input[@id='id_quantity']")).sendKeys("1500");
	driver.findElement(By.xpath("//button[@class='btn add-cart-btn']")).click();
	String ActualLimitError=driver.findElement(By.xpath("//div[@class='alertinner wicon']")).getText();
	String ExpectedLimitError="This item is limited to 1200 units per order";
	if(ActualLimitError.equals(ExpectedLimitError)){
		System.out.println("The Limit of the product item has exceeded.");
		driver.close();
	}
	Assert.assertEquals(ActualLimitError,ExpectedLimitError);
	driver.findElement(By.xpath("//b[text()='VIEW CART']")).click();
	List<WebElement> elements=driver.findElements(By.xpath("//ul[@class='right-sec cart-delivery-methods']//li"));
	System.out.println("The Number of Delivery method for the product"+ProductName+"is:"+elements.size());
	for(int i=0;i<elements.size();i++){
		System.out.println("The values are:"+elements.get(i).getText());
		while(elements.get(i).getText().startsWith(FBCDeliveryMethod)){ 
			if(elements.get(i).getText().startsWith("Store Pickup")){
				driver.findElement(By.xpath("//span[text()='Store Pickup']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[text()='Continue']")).click();
				driver.findElement(By.xpath("//div[@class='row form-group check-avail-box']/div/button[text()='Continue']")).click();
				Thread.sleep(2000);
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

		
			if(elements.get(i).getText().startsWith("Local Delivery")){
			    driver.findElement(By.xpath("//span[text()='Local Delivery']")).click();
		    	Thread.sleep(3000);
		    	driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click(); 
				driver.findElement(By.xpath("//button[text()='Continue']")).click();
				driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
				driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
				driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
				driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
				driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
				driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
				driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
				driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
				//driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
			
			if(elements.get(i).getText().startsWith("Ship")){
				driver.findElement(By.xpath("//span[text()='Ship to Me']")).click();
		    	driver.findElement(By.xpath("//a[contains(@class,'btn add-cart-btn data-loader')]")).click();
				driver.findElement(By.xpath("//button[text()='Continue']")).click();
				driver.findElement(By.xpath("//input[@id='id_first_name']")).sendKeys("Elon");
				driver.findElement(By.xpath("//input[@id='id_last_name']")).sendKeys("Musk");
				driver.findElement(By.xpath("//input[@id='id_line1']")).sendKeys("Lothi Gardens Street");
				driver.findElement(By.xpath("//input[@id='id_line2']")).sendKeys("Church Street");
				driver.findElement(By.xpath("//input[@id='id_line4']")).sendKeys("Hanalei");     
				driver.findElement(By.xpath("//input[@id='id_state']")).sendKeys("HI");
				driver.findElement(By.xpath("//input[@id='id_postcode']")).sendKeys("96714");
				driver.findElement(By.xpath("//button[text()='Save & Continue']")).click();
				//driver.findElement(By.xpath("//div[contains(@class,'col-sm-4 mb-10')]//following-sibling::button[text()='Continue']")).click();
				driver.findElement(By.xpath("//div[contains(@class,'row form-group check-avail-box')]//following-sibling::div//button[contains(@class,'btn')]")).click();
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
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("#payment-form > div.row.form-group.check-avail-box > div > button")).submit();
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
			System.out.println("The Delivery Method is not available for the selected product");
		}
		

	}}
	


		






	
	


