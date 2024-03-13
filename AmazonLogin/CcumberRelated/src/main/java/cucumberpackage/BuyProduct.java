package cucumberpackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuyProduct {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        extent = new ExtentReports();
        test = extent.createTest("BuyProduct Test");
    }

    @Test(priority = 1)
    public void f() throws InterruptedException {
        driver.get("https://www.amazon.in");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Your test steps here
        test.log(Status.INFO, "Navigated to Amazon.in");

        driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
        test.log(Status.INFO, "Clicked on 'Account & Lists'");

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("8668197226");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        test.log(Status.INFO, "Entered email and clicked 'Continue'");

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Shakthi@25");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
        test.log(Status.INFO, "Entered password and clicked 'Sign In'");

        driver.findElement(By.xpath("//div[@id='nav-cart-text-container']")).click();
        Thread.sleep(3000);
        test.log(Status.INFO, "Clicked on 'Cart'");

        driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
        test.log(Status.INFO, "Clicked 'Proceed to Retail Checkout'");

        driver.findElement(By.cssSelector("#orderSummaryPrimaryActionBtn > span > input")).click();
        Thread.sleep(10000);
        test.log(Status.INFO, "Clicked 'Place your order'");

        driver.findElement(By.cssSelector("#orderSummaryPrimaryActionBtn > span > input")).click();
        Thread.sleep(30000);
        test.log(Status.INFO, "Clicked 'Place your order' again");

        driver.findElement(By.id("bottomSubmitOrderButtonId")).click();
        Thread.sleep(4000);
        test.log(Status.INFO, "Clicked 'Place your order' once more");

        // Perform additional actions and logging as needed

        // Simulate a test failure
        // if (someCondition) {
        //     test.log(Status.FAIL, "Test step failed because of XYZ.");
        // }

        driver.close();
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
    }
}