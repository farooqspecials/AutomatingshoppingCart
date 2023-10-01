package unitTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import drivers.DriverSingleton;
import pages.CheckoutPage;
import pages.HomePage;
import utils.Constants;
import utils.FrameworkProperties;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;

public class Tests {
	
	static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static CheckoutPage checkoutPage;
    
	 @BeforeClass
	    public static void initializeObjects(){
	        frameworkProperties = new FrameworkProperties();
	        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
	        driver = DriverSingleton.getDriver();
	        homePage = new HomePage();
	        checkoutPage = new CheckoutPage();
	    }
	 
	 @Test
	    public void testingAuthentication(){
	        driver.get(Constants.URL);
	        homePage.signIn();
	        homePage.clickSignIn("farooqspecials@gmail.com", "farooq007");
	       // signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
	       // assertEquals(frameworkProperties.getProperty(Constants.USERNAME), homePage.getUsername());
	        assertEquals("Farooq Abdullah", homePage.getUsername());
	        
	       
	    }
	 
	 @Test 
	 public void orderplaced() throws InterruptedException {
		 //This is working without Junit seet test.java. but not working with Junit.. no idea why.
		 
		 	homePage.addFirstElementToCart();
	        homePage.addSecondElementToCart();
	        
	        checkoutPage.goToCheckout();
	        checkoutPage.logIn("farooqspecials@gmail.com", "farooq007");
	        checkoutPage.confirmAddress("Please my door code is 2098");
	        
	        checkoutPage.confirmCard("Farooq", "4108900120083005", "045", "05", "2022");
	        
	        assertEquals("Order Placed!", checkoutPage.orderstatus());
	        
	 }
	 @AfterClass
	 public static void close() {
		 driver.close();
	 }
	 

}
