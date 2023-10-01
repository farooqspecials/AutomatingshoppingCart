package framework;

import org.openqa.selenium.WebDriver;

import drivers.DriverSingleton;
import pages.CheckoutPage;
import pages.HomePage;
import utils.FrameworkProperties;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://automationexercise.com");
        
        HomePage homePage = new HomePage();
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();
        CheckoutPage check = new CheckoutPage();
        check.goToCheckout();
        check.logIn("farooqspecials@gmail.com", "farooq007");
        check.confirmAddress("Please my door code is 2098");
        
        check.confirmCard("Farooq", "4108900120083005", "045", "05", "2022");
        
        
	}

}
