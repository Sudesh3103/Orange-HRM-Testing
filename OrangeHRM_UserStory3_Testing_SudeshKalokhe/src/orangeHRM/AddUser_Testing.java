package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddUser_Testing {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
    }

    @Test(priority = 1)
    public void Test1() {
        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Admin Button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-main-menu-item-wrapper"))).click();

        // Add Button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']"))).click();

        // Select User Role (Admin)
        WebElement userRoleDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.oxd-select-text.oxd-select-text--active")));
        userRoleDropdown.click();
        WebElement adminOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-select-text') and contains(@class, 'oxd-select-text--active')]/div[text()='Admin']")));
        adminOption.click();

        // Employee Name Field
        WebElement employeeNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-autocomplete-text-input--active input[placeholder='Type for hints...']")));
        employeeNameField.sendKeys("Brian Johnson");

        // Select Status (Enabled)
        WebElement statusDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.oxd-select-text.oxd-select-text--active")));
        statusDropdown.click();
        WebElement enabledOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option' and contains(text(), 'Enabled')]")));
        enabledOption.click();

        // Enter Username
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Username']/../following-sibling::div/input")));
        usernameField.sendKeys("Sudesh Prabhu Kalokhe");

        // Enter Password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password'].oxd-input")));
        passwordField.sendKeys("Sudesh@123");

        // Confirm Password
        WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input")));
        confirmPasswordField.sendKeys("Sudesh@123");

        // Save Button
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit'].oxd-button--secondary")));
        saveButton.click();

        System.out.println("User added successfully!");
    }
    
    @Test(priority = 2)
	public void Test2() {
    	
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
	    // Login
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
	    driver.findElement(By.name("password")).sendKeys("admin123");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();

	    // Admin Button
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-main-menu-item-wrapper"))).click();

	    // Add Button
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']"))).click();

	    // Select User Role (Admin)
	    WebElement userRoleDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.oxd-select-text.oxd-select-text--active")));
	    userRoleDropdown.click();
	    WebElement adminOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-select-text') and contains(@class, 'oxd-select-text--active')]/div[text()='ESS']")));
	    adminOption.click();

	    // Employee Name Field
	    WebElement employeeNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-autocomplete-text-input--active input[placeholder='Type for hints...']")));
	    employeeNameField.sendKeys("  ");

	    // Select Status (Enabled)
	    WebElement statusDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.oxd-select-text.oxd-select-text--active")));
	    statusDropdown.click();
	    WebElement enabledOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option' and contains(text(), 'Enabled')]")));
	    enabledOption.click();

	    // Enter Username
	    WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Username']/../following-sibling::div/input")));
	    usernameField.sendKeys(" ");

	    // Enter Password
	    WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password'].oxd-input")));
	    passwordField.sendKeys("sudesh");

	    // Confirm Password
	    WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input")));
	    confirmPasswordField.sendKeys("sudesh@123");

	    // Save Button
	    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit'].oxd-button--secondary")));
	    saveButton.click();

	    System.out.println("User not added successfully!");
	}
    
   
}
