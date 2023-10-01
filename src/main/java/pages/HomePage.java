package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverSingleton;


public class HomePage {
	  private WebDriver driver;

	    public HomePage(){
	        driver = DriverSingleton.getDriver();
	        PageFactory.initElements(driver, this);
	    }
	    
	    //add to card for product no 1

	    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.product-overlay > div > a")
	    private WebElement addToCartFirst;
	    
	    
	    
	    //add to card for product no 2

	    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.product-overlay > div > a")
	    private WebElement addToCartSecond;
	    
	    //cart element 

	    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a")
	    private WebElement cart;
	    
	    //sign in on home page
	   // 
	    
	    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a")
	    private WebElement signIn;

	  
	    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)")
	    private WebElement username;
	    
	    
	    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)")
	    private WebElement password;
	   
	    
	    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button")
	    private WebElement lgnBtn;
	    
	    
	    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b")
	    private WebElement nameassert;
	    
	    // continue to checkout button on pop up box
	    @FindBy(css = "#cartModal > div > div > div.modal-footer > button")
	    private WebElement continueShoppingButton;

	   // Add to card is hidden on the page. To hover on the web element to show add to cart button
	   @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > img")
	    private WebElement firstElement;
	 // Add to card is hidden on the page. To hover on the web element to show add to cart button
	    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.productinfo.text-center > img")
	    private WebElement secondElement;
	    
	    
	    public void signIn() {
	    	signIn.click();
	    	  	
	    }
	    
	    public void clickSignIn(String Username, String Password) {
	    	signIn.click();
	    	username.sendKeys(Username);
	        password.sendKeys(Password);
	        lgnBtn.click();
	    	
	    }
	    
	    public String getUsername() {
	    	return nameassert.getText();
	    }
	    
	    
	    public void addFirstElementToCart(){
	       // Actions hover = new Actions(driver);
	     //   hover.moveToElement(firstElement).build().perform();
	    	
	    	    
		         // actions.moveToElement(firstElement).build();
		         // actions.perform();
	    	JavascriptExecutor jse= (JavascriptExecutor) driver;
	    	//jse.executeScript("arguments[0].scrollIntoView()", addToCartFirst);
	    	jse.executeScript("arguments[0].scrollIntoView()", firstElement);
	    	
	    	
	    	 Actions actions = new Actions(driver);
		        actions.moveToElement(firstElement).build().perform();
		        
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.elementToBeClickable(addToCartFirst));
	    	
	        addToCartFirst.click();
	        
	        
	        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
	        continueShoppingButton.click();
	     //   if(cart.getText().contains(Constants.CART_QUANTITY))
	       //     System.out.println("Cart has been updated");
	       // else
	         //   System.out.println("Cart has not been updated");
	    }
	    
	    public void addSecondElementToCart(){
	     //    Actions actions = new Actions(driver);
	       // hover.moveToElement(secondElement).build().perform();
	       // actions.moveToElement(addToCartSecond).perform();
	    	 Actions actions = new Actions(driver);
		     actions.moveToElement(secondElement).build().perform();
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.elementToBeClickable(addToCartSecond));
	        addToCartSecond.click();
	       
	        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
	       // proceedToCheckoutButton.click();
	        continueShoppingButton.click();
	        
	        cart.click();
	    }

}
