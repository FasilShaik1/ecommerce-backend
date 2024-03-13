package cucumberpackage;

import java.io.IOException;



import org.openqa.selenium.By;

 

import org.openqa.selenium.WebDriver;

 

import org.openqa.selenium.WebElement;

 

import org.openqa.selenium.chrome.ChromeDriver;

 

import org.openqa.selenium.chrome.ChromeOptions;

 

import org.testng.annotations.BeforeTest;

 

import org.testng.annotations.Test;

 

public class Automationtest {

 

private WebDriver driver;

 

static String amazonBaseUrl = "https://www.amazon.in/?tag=msndeskabkin-21&ref=pd_sl_7qhce485bd_e&adgrpid=1322714095756137&hvadid=82669897710514&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=156243&hvtargid=kwd-82670512756912:loc-90&hydadcr=14453_2334184";

 

   @BeforeTest

 

  public void setUp() {

 

  System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\shaik.fasil\\\\Documents\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

 

ChromeOptions options = new ChromeOptions();

 

  options.addArguments("--start-maximized");

 

  driver = new ChromeDriver(options);

 

   }

 

   @Test(priority = 1)

 

public void testAmazonLogin() throws InterruptedException, IOException {

 

   driver.get(amazonBaseUrl);

 

WebElement hamburgerMenu = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));

 

  hamburgerMenu.click();

 


WebElement amazonPay = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));

 

amazonPay.sendKeys("7994978512");

 

Thread.sleep(1000);

 

  WebElement continues = driver.findElement(By.xpath("//*[@id=\"continue\"]"));

 

  continues.click();

 

  Thread.sleep(1000);

 

WebElement passwords = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));

 

  passwords.sendKeys("Vaishnav@99");

 

  Thread.sleep(1000);

 

WebElement signin = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));

 

signin.click();

 

Thread.sleep(0000);

 

driver.get("https://www.amazon.in/KABEER-ART-0-7mm-Color-Transparent/dp/B071Y36PDK/ref=sr_1_1_sspa?crid=1E0OYP3L2O6QR&keywords=pen&qid=1697476412&sprefix=pen%2Caps%2C304&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");

 


WebElement wishlist = driver.findElement(By.xpath("//*[@id=\"add-to-wishlist-button-submit\"]"));

 

wishlist.click();

 

Thread.sleep(10000);

 

WebElement proceed = driver.findElement(By.xpath("//*[@id=\"huc-view-your-list-button\"]/span/a"));

 

proceed.click();

 

Thread.sleep(10000);

 

driver.quit();

 

}}