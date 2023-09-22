package framework;

import org.openqa.selenium.WebDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("http://www.automationpractice.pl/index.php");
	}

}
