package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverSingleton;

public class SigninPage {
	
	private WebDriver driver;

    public SigninPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
	
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(id = "email_create")
    private WebElement emailSignUpField;

    @FindBy(id = "SubmitCreate")
    private WebElement signUpButton;
    
    
    public void logIn(String email, String passwd){
        emailField.sendKeys(email);
        password.sendKeys(passwd);
        signInButton.click();
    }

    public void signUp(String email){
        emailSignUpField.sendKeys(email);
        signUpButton.click();
    }
}
