package AutomationQA.AutomationDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class E2ETest {


    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        
       
        // Initialize WebDriver
        driver = new FirefoxDriver();
    }

    @Test
    public void testLogin() {
        // Navigate to the login page
        driver.get("https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/LogIn");

        // Locate username, password fields and login button
        WebElement usernameField = driver.findElement(By.id("Username"));
        WebElement passwordField = driver.findElement(By.id("Password")); 
        WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));
        // Input username and password
        usernameField.sendKeys("TestUser417"); 
        passwordField.sendKeys("&IVCwQE-VU@i"); 


        loginButton.click();


        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify successful login
        WebElement successMessage = driver.findElement(By.id("add")); 
        Assert.assertTrue(successMessage.isDisplayed(), "Login failed");
    }

    
    @Test
    public void testAddEmployee() {
    	
         
        WebElement addEmployeeButton = driver.findElement(By.id("add"));

        addEmployeeButton.click();

        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        WebElement firstnameField = driver.findElement(By.id("firstName"));
        WebElement lastnameField = driver.findElement(By.id("lastName"));
        WebElement dependentField = driver.findElement(By.id("dependants"));
        
        firstnameField.sendKeys("Auto"); 
        lastnameField.sendKeys("Challenge"); 
        dependentField.sendKeys("7"); 

        WebElement addButton = driver.findElement(By.id("add"));
        addButton.click();
        
        
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify successful add
        WebElement successFirstName = driver.findElement(By.xpath("//*[text()='Auto']"));
        WebElement successLastName = driver.findElement(By.xpath("//*[text()='Challenge']")); 
        WebElement successDependent = driver.findElement(By.xpath("//*[text()='7']"));
        WebElement successSalary = driver.findElement(By.xpath("//*[text()='Auto']/..//*[text()='52000.00']"));
        WebElement successGrossPay = driver.findElement(By.xpath("//*[text()='Auto']/..//*[text()='2000.00']")); 
        WebElement successBenefitsCost = driver.findElement(By.xpath("//*[text()='Auto']/..//*[text()='173.08']"));
        WebElement successNetPay = driver.findElement(By.xpath("//*[text()='Auto']/..//*[text()='1826.92']"));
        
        Assert.assertTrue(successFirstName.isDisplayed(), "Expected fisrtname not displayed");
        Assert.assertTrue(successLastName.isDisplayed(), "Expected last name not displayed");
        Assert.assertTrue(successDependent.isDisplayed(), "Expected dependents not displayed");
        Assert.assertTrue(successSalary.isDisplayed(), "Expected salary not displayed");
        Assert.assertTrue(successGrossPay.isDisplayed(), "Expected gross pay not displayed");
        Assert.assertTrue(successBenefitsCost.isDisplayed(), "Expected benefits cost not displayed");
        Assert.assertTrue(successNetPay.isDisplayed(), "Expected benefits cost not displayed");
        
    }
    
    
    @Test
    public void testUpdateEmployee() {
    	 WebElement editEmployeeButton = driver.findElement(By.xpath("//*[text()='Auto']/..//*[@class='fas fa-edit']"));

         editEmployeeButton.click();

         try {
             Thread.sleep(2000); 
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         
         WebElement firstnameField = driver.findElement(By.id("firstName"));
         WebElement lastnameField = driver.findElement(By.id("lastName"));
         WebElement dependentField = driver.findElement(By.id("dependants"));
         
         firstnameField.sendKeys("AutoU"); 
         lastnameField.sendKeys("ChallengeU"); 
         dependentField.sendKeys("9"); 

         WebElement updateButton = driver.findElement(By.id("updateEmployee"));
         updateButton.click();
         
         
         try {
             Thread.sleep(2000); 
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

      // Verify successful update
         WebElement successFirstName = driver.findElement(By.xpath("//*[text()='AutoU']"));
         WebElement successLastName = driver.findElement(By.xpath("//*[text()='ChallengeU']")); 
         WebElement successDependent = driver.findElement(By.xpath("//*[text()='9']")); 
         WebElement successSalary = driver.findElement(By.xpath("//*[text()='AutoU']/..//*[text()='52000.00']"));
         WebElement successGrossPay = driver.findElement(By.xpath("//*[text()='AutoU']/..//*[text()='2000.00']")); 
         WebElement successBenefitsCost = driver.findElement(By.xpath("//*[text()='AutoU']/..//*[text()='211.54']"));
         WebElement successNetPay = driver.findElement(By.xpath("//*[text()='AutoU']/..//*[text()='1788.46']"));
         
         Assert.assertTrue(successFirstName.isDisplayed(), "Expected fisrtname not displayed");
         Assert.assertTrue(successLastName.isDisplayed(), "Expected last name not displayed");
         Assert.assertTrue(successDependent.isDisplayed(), "Expected dependents not displayed");
         Assert.assertTrue(successSalary.isDisplayed(), "Expected salary not displayed");
         Assert.assertTrue(successGrossPay.isDisplayed(), "Expected gross pay not displayed");
         Assert.assertTrue(successBenefitsCost.isDisplayed(), "Expected benefits cost not displayed");
         Assert.assertTrue(successNetPay.isDisplayed(), "Expected benefits cost not displayed");
    }
    
    
    @Test
    public void tesDeleteEmployee() {
   	 WebElement deleteEmployeeButton = driver.findElement(By.xpath("//*[text()='Auto']/..//*[@class='fas fa-times']"));

   	deleteEmployeeButton.click();

     try {
         Thread.sleep(2000); 
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     WebElement confirmDeleteEmployeeButton = driver.findElement(By.id("deleteEmployee"));
     confirmDeleteEmployeeButton.click();

     // Wait for the deletion to complete
     try {
         Thread.sleep(2000); 
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     // Validate that the employee record is deleted
     try {
         WebElement deletedEmployee = driver.findElement(By.xpath("//*[text()='Auto']"));
         // If the element is found, the deletion failed
         Assert.fail("Employee record still present after deletion");
     } catch (org.openqa.selenium.NoSuchElementException e) {
         // If NoSuchElementException is caught, it means the element is not present (deleted successfully)
         Assert.assertTrue(true, "Employee record deleted successfully");
     }
    }
    
    
    @Test
    public void testLogout() {
         // Locate username, password fields and login button
        WebElement usernameField = driver.findElement(By.id("Username"));
        WebElement passwordField = driver.findElement(By.id("Password")); 
        WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));
        WebElement logoutButton = driver.findElement(By.xpath("//*[text()='Log Out']"));

        logoutButton.click();


        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify successful logout
        Assert.assertTrue(usernameField.isDisplayed(), "Logout failed: No Username field displayed");
        Assert.assertTrue(usernameField.isDisplayed(), "Logout failed: No password field displayed");
        Assert.assertTrue(usernameField.isDisplayed(), "Logout failed: No Login button displayed");
    }
    
    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
    
}

