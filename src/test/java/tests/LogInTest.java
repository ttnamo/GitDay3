package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
// Login tests are manintaned here .
//without page object approach
public class LogInTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
@Test
    public void loginTest1(){
        driver.get("e.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
    driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
    Assert.assertEquals(driver.getTitle(), "Web Orders");
}

    @Test
    public void negativeloginTest1(){
        driver.get("e.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
        String errormsage=driver.findElement(By.id("ctl00_MainContent_status")).getText();
        Assert.assertEquals(driver.getTitle(), "Web Orders");
    }
    @Test
    public void loginTest(){
        driver.get("e.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);

        driver.findElement(By.id("ctl00_logout")).click();

        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
    }
@AfterMethod
    public void CleanUp(){
        driver.close();

}
}



