package framework;

import org.openqa.selenium.WebDriver;

import drivers.DriverSingleton;
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
	}

}
