package com.amazonlogin;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AmazonLoginTest {
    private AmazonLoginPage loginPage;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setup() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shaik.fasil\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
        extent.attachReporter(htmlReporter);
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String password) {
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
        loginPage = new AmazonLoginPage(driver);
        driver.get("https://www.amazon.in/?tag=msndeskabkin-21&ref=pd_sl_7qhce485bd_e&adgrpid=1322714095756137&hvadid=82669897710514&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=156243&hvtargid=kwd-82670512756912:loc-90&hydadcr=14453_2334184");
        loginPage.signIN();
        loginPage.enterEmail(email);
        loginPage.clickContinue();
        loginPage.enterPassword(password);
        loginPage.clickSignIn();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Initialize the "test" object for this iteration
        test = extent.createTest("Login Test for " + email);

        // Capture a screenshot and add it to the Extent Report
        captureAndAddScreenshot(driver, test);

        driver.quit(); // Close the driver after each login
    }

    @DataProvider(name = "loginData")
    public Object[][] readLoginData() throws IOException {
        File excelFile = new File("C:\\Users\\shaik.fasil\\Desktop\\AmazonLogin.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][columnCount];
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            data[i - 1][0] = row.getCell(0).getStringCellValue(); // Email
            data[i - 1][1] = row.getCell(1).getStringCellValue(); // Password
        }

        fis.close();
        workbook.close();
        return data;
    }

    @AfterClass
    public void tearDown() {
        extent.flush(); // Flush the Extent Report
    }

    // Helper method to capture a screenshot and add it to the Extent Report
    private void captureAndAddScreenshot(WebDriver driver, ExtentTest test) {
        try {
            // Generate a unique screenshot name with timestamp
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date timestamp = new Date();
            String screenshotName = "screenshot_" + dateFormat.format(timestamp) + ".png";

            // Capture the screenshot and save it to a file
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define the destination path
            String destinationPath = "C:\\Users\\shaik.fasil\\Desktop\\AmazonLogin\\AmazonLogins\\src\\main\\resources\\screenshots\\" + screenshotName;

            // Save the screenshot to the specified destination
            File destination = new File(destinationPath);
            FileUtils.copyFile(screenshotFile, destination);

            // Add the screenshot to the Extent Report
            test.addScreenCaptureFromPath(destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
