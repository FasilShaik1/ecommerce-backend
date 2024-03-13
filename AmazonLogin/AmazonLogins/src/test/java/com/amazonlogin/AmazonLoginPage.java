package com.amazonlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonLoginPage {
    private WebDriver driver;

    public AmazonLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void signIN() {
		
		 driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
		
	}

    public void enterEmail(String email) {
    	driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(email);
    }

    public void clickContinue() {
    	driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    public void enterPassword(String password) {
    	driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
    }

    public void clickSignIn() {
    	driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
    }

	
}
