package ro.upt.ac.aplicatie.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginUITest 
{
    private WebDriver driver;
    
    @BeforeTest
    public void setUp() 
    {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }
    
    @Test
    public void testLogin() 
    {
        driver.get("http://localhost:7443/login");
        driver.findElement(By.id("username")).sendKeys("adminTest");
        driver.findElement(By.id("email")).sendKeys("adminTest@upt.ro");
        driver.findElement(By.id("password")).sendKeys("Test");
        driver.findElement(By.id("loginBtn")).click();
        assertTrue(driver.getPageSource().contains("Bine ai venit"));
    }
    
    @AfterTest
    public void tearDown() 
    {
        driver.quit();
    }
}
