package PageObjectModel;

import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
public WebDriver ldriver;
public SignUpPage(WebDriver rdriver) {
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	
}
@FindBy(name = "firstName")
private WebElement firstNameInput;

@FindBy(name = "lastName")
private WebElement lastNameInput;

@FindBy(name = "userName")
private WebElement usernameInput;

@FindBy(name = "email")
private WebElement emailInput;

@FindBy(name = "password")
private WebElement passwordInput;

@FindBy(xpath="//input[@type='checkbox']")
private WebElement termsOfServiceCheckbox;

@FindBy(xpath="//button[normalize-space()='Next']")
private WebElement nextbutton;

@FindBy(name = "companyName")
private WebElement companyNameInput;

@FindBy(xpath = "//button[@id=':r2:']")
private WebElement clickNextButton;

@FindBy(xpath="//div[@role='alert']") 
private WebElement Newuserregisteredmessage;

@FindBy(xpath="//input[@id='userName']")
private WebElement fillUsername;

@FindBy(xpath="//input[@id='password']")
private WebElement fillpassword;

@FindBy(css="body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(6) > button:nth-child(1)")
private WebElement loginbtn;

@FindBy(css=".profile.MuiBox-root.css-0")
private WebElement iconbtn;
@FindBy(xpath="//li[normalize-space()='Logout']")
private WebElement logoutbtn;

public void fillFirstName(String firstName) {
	firstNameInput.clear();
    firstNameInput.sendKeys(firstName);
}

public void fillLastName(String lastName) {
	 lastNameInput.clear();
	lastNameInput.sendKeys(lastName);
   
}

public void fillUserName(String userName) {
	usernameInput.clear();
	usernameInput.sendKeys(userName);

	}
public void fillEmail(String email) {
	emailInput.clear();
	emailInput.sendKeys(email);

}
public void fillPassword(String pwd) {
	passwordInput.clear();
	passwordInput.sendKeys(pwd);
}
public void termsOfServiceCheckbox() {
	
	termsOfServiceCheckbox.click();
}
public void nextbutton() {
	nextbutton.click();
}
public void fillCompanyName(String companyName) {
	
    companyNameInput.sendKeys(companyName);
    
}

public void clickNextButton() {
    clickNextButton.click();
}

/*public boolean isPopupMessageDisplayed(String expectedMessage) {
    String actualMessage = Newuserregisteredmessage.getText();
    return actualMessage.contains(expectedMessage);
} */

public void fillUsername(String username) {
	fillUsername.sendKeys(username);
}

public void fillpassword(String password) {
	fillpassword.sendKeys(password);
}
public void loginbutton() {
	loginbtn.click();
}
public void iconbtn() {
	iconbtn.click();
}
public void logoutbtn() throws InterruptedException {
	
	logoutbtn.click();

	
}

public String getUserNameErrorMessage() {
	WebElement errorMessageElement = ldriver.findElement(By.xpath("//p[contains(text(),'Username should be between 8 and 50 alphanumeric c')]"));
	 return errorMessageElement.getText();
}

public String getEmailErrorMessage() {
	WebElement errorMessageElement = ldriver.findElement(By.xpath("//p[normalize-space()='Please enter valid email!']")); // Adjust locator as per your HTML
    return errorMessageElement.getText();
}

public String getPasswordErrorMessage() {
	WebElement errorMessageElement = ldriver.findElement(By.xpath("//p[normalize-space()='Please enter strong password']")); // Adjust locator as per your HTML
	  return errorMessageElement.getText();
}

public String companyErrorMessage() {
	WebElement errorMessageElement = ldriver.findElement(By.xpath("//p[@class='m-b-0']")); // Adjust locator as per your HTML
	  return errorMessageElement.getText();
}

}
