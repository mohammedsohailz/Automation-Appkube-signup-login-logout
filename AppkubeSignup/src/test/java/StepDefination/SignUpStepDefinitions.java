package StepDefination;


import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import com.sun.org.apache.xpath.internal.operations.Equals;

import PageObjectModel.SignUpPage;
import Utilities.Baseclass;

public class SignUpStepDefinitions extends Baseclass{

    WebDriver driver;
    SignUpPage signUpPage;

    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        signUpPage = new SignUpPage(driver);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
  
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.findElement(By.xpath("//a[normalize-space()='Sign up Now']")).click();
        try {
            Baseclass.takeScreenshot(driver, "user_opens_url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("I fill in the sign-up form with valid information")
    public void i_fill_in_the_sign_up_form_with_valid_information() {
    	 
           
    	signUpPage.fillFirstName("mohd");
        signUpPage.fillLastName("sohail");
        signUpPage.fillUserName(username);
        signUpPage.fillEmail(email);
        signUpPage.fillPassword("Sohail@123");
        System.out.println("The username is :" +username);
        System.out.println("The email is :" +email);
   
    }
    

    @And("I agree to the terms of service")
    public void i_agree_to_the_terms_of_service() {
        // Assuming the terms of service check box is already checked during sign up
    	signUpPage.termsOfServiceCheckbox();
    	try {
            Baseclass.takeScreenshot(driver, "I fill in the sign-up form with valid information");
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }

    @And("I click the sign-up button")
    public void i_click_the_sign_up_button() {
        // Sign up button click is performed during form submission
    	signUpPage.nextbutton();
    	   try {
               Baseclass.takeScreenshot(driver, "I click the sign-up button");
           } catch (IOException e) {
               e.printStackTrace();
           }
    }

    @Then("I fill company name")
    public void i_fill_company_name() {
    	
        signUpPage.fillCompanyName(companyName);
        System.out.println("The company name is :" +companyName);
    }

    @And("I click the Next button")
    public void i_click_the_next_button() throws InterruptedException {
    	
        signUpPage.clickNextButton();
        Thread.sleep(3000);
        
        try {
            Baseclass.takeScreenshot(driver, "Register complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(10000);
        driver.close();
    }
        /*String messageId = "New user registered!";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'New user registered!')]")));
driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/button[1]")).click();
    }
    /*@Then("I should see a popup message saying {string}")
    public void i_should_see_a_popup_message_saying(String expectedMessage) {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue("Pop up message with expected text is not displayed",
                signUpPage.isPopupMessageDisplayed(expectedMessage));
    }*/
    @And("User navigate to login page")
    public void user_navigate_to_login_page()  throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        signUpPage = new SignUpPage(driver);
        driver.manage().window().maximize();
        driver.get("https://appkube.synectiks.net");
        try {
            Baseclass.takeScreenshot(driver, "signinpage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    @And("I fill in the login form with the signed-up username and password")
    public void i_fill_in_the_login_form_with_the_signed_up_username_and_password() throws InterruptedException {
        // Use the signed up user name and provide corresponding password
 
        String password = "Sohail@123"; // Assuming same password for all sign-ups
        signUpPage.fillUserName(username);
        signUpPage.fillPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() throws InterruptedException {
        signUpPage.loginbutton();
        Thread.sleep(3000);
        try {
            Baseclass.takeScreenshot(driver, "loginsuccessful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @When("User click to icon")
    public void user_click_to_icon() throws InterruptedException {
    	
         Thread.sleep(3000);
    signUpPage.iconbtn();
    }
    

@And("I click to logout button")
public void i_click_to_logout_button() throws InterruptedException {
	Thread.sleep(4000);
	
	signUpPage.logoutbtn();
	  try {
          Baseclass.takeScreenshot(driver, "logoutsuccessful");
      } catch (IOException e) {
          e.printStackTrace();
      }
	driver.close();
	driver.quit();
}

    @AfterClass
    public void tearDown() { //sohae3bf
        driver.quit();
       
    }
    
    //invalid credentials for signup page
    
    @Given("User Lanuch Chrome browser")
    public void user_lanuch_chrome_browser() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        signUpPage = new SignUpPage(driver);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @When("User opens URL1 {string}")
    public void user_open_url1(String url) {
        driver.get(url);
        driver.findElement(By.xpath("//a[normalize-space()='Sign up Now']")).click();
        
    }

    @When("User fill in the sign-up form with invalid information")
    public void user_fill_in_the_sign_up_form_with_invalid_information() {
    	signUpPage.fillFirstName("moh");
        signUpPage.fillLastName("soh");
        signUpPage.fillUserName("me");
        signUpPage.fillEmail("email.com");
        signUpPage.fillPassword("s123");
        signUpPage.termsOfServiceCheckbox();
    }
    @When("User click the sign-up button")
    public void user_click_the_sign_up_button() {
    	signUpPage.nextbutton();
    }

    @Then("User see an error message in each input field")
    public void user_see_an_error_message_in_each_input_field() {
         String userNameErrorMessage = signUpPage.getUserNameErrorMessage();
         String emailErrorMessage = signUpPage.getEmailErrorMessage();
         String passwordErrorMessage = signUpPage.getPasswordErrorMessage();

         // Verify error messages for each input field
         assertEquals("Username error message does not match", "Username should be between 8 and 50 alphanumeric characters.", userNameErrorMessage);
         assertEquals("Email error message does not match", "Please enter valid email!", emailErrorMessage);
         assertEquals("Password error message does not match", "Please enter strong password", passwordErrorMessage);
    
         try {
             Baseclass.takeScreenshot(driver, "error_message_warning");
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    

    @And("User enter with valid information")
    public void user_enter_with_valid_information() {
    	
    	signUpPage.fillFirstName("mohd");
        signUpPage.fillLastName("sohail");
        signUpPage.fillUserName(username);
        signUpPage.fillEmail(email);
        signUpPage.fillPassword("Sohail@123");
        System.out.println("The username is :" +username);
        System.out.println("The email is :" +email);
    }
    @And("User click on the sign-up button1")
    public void user_click_on_the_sign_up_button1() {
    	signUpPage.nextbutton();
    }


    @When("User fill invalid or duplicate company name")
    public void user_fill_invalid_or_duplicate_company_name() {
    	signUpPage.fillCompanyName("hdy ejj 88 ej ");
    }
    @And ("User Click on next buttons")
    public void And_User_Click_on_next_buttons() {
    	signUpPage.clickNextButton();
    }

    @Then("User get an error message displayed")
    public void user_get_an_error_message_displayed() {
    	 String companyErrorMessage = signUpPage.companyErrorMessage();
    	 assertEquals("Password error message does not match", "Company Name should be a maximum of 50 characters.", companyErrorMessage);
    	  try {
              Baseclass.takeScreenshot(driver, "company_name_invalid");
          } catch (IOException e) {
              e.printStackTrace();
          }
    }
    

    @And("close browser")
    public void close_browser() {
       driver.close();
    }

    @AfterClass
    public void tearDowns() { 
        driver.quit();
       
    }

    
    
    
}


