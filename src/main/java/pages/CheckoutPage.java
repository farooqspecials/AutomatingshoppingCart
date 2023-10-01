package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverSingleton;

public class CheckoutPage {
	
	private WebDriver driver;

    public CheckoutPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "head > title")
    private WebElement pageTitle;
    
    @FindBy(css = "#do_action > div.container > div > div > a")
    private WebElement checkoutButton;
    
    @FindBy(css = " #checkoutModal > div > div > div.modal-body > p:nth-child(2) > a")
    private WebElement loginPage;
    
    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)")
    private WebElement emailInput;
    
    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)")
    private WebElement passwordInput;
    
    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button")
    private WebElement loginButton;
      
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a")
    private WebElement cartButton;
    
    //proceed to checkout click again
    
    @FindBy(css = "#ordermsg > textarea")
    private WebElement inputComment;
    
    @FindBy(css = "#cart_items > div > div:nth-child(7) > a")
    private WebElement placeorderButton;
    
    @FindBy(css = "#payment-form > div:nth-child(2) > div > input")
    private WebElement cardName;
    @FindBy(css = "#payment-form > div:nth-child(3) > div > input")
    private WebElement cardnumber;
    
    @FindBy(css = "#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input")
    private WebElement cvv;
    
    @FindBy(css = "#payment-form > div:nth-child(4) > div:nth-child(2) > input")
    private WebElement expire;
    @FindBy(css = "#payment-form > div:nth-child(4) > div:nth-child(3) > input")
    private WebElement year;
    
    @FindBy(css = "#submit")
    private WebElement submitButton;
    
    
    @FindBy(css = ".title > b:nth-child(1)")
    private WebElement orderStatus;
    
    
    
    
    

  /*  public Boolean checkTitle(String title){
        return pageTitle.getText().equals(title);
    } */

    public void goToCheckout(){
    	checkoutButton.click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage));
        loginPage.click();
    }
    
    public void logIn(String email, String passwd){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(passwd);
        loginButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
        
        checkoutButton.click();
        
    }

    public void confirmAddress(String comment){
    	
    	inputComment.sendKeys(comment);
    	placeorderButton.click();
    }
    
 public void confirmCard(String card,String cardNumber, String Cvv, String Expire, String Year){
    	
    	cardName.sendKeys(card);
    	cardnumber.sendKeys(cardNumber);
    	
    	cvv.sendKeys(Cvv);
    	expire.sendKeys(Expire);
    	year.sendKeys(Year);
    	submitButton.click();
    	
    	
    }
 


    
    

   


}
