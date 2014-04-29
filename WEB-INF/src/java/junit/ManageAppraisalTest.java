package junit;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ManageAppraisalTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testManageAppraisal() throws Exception {
    driver.get(baseUrl + "FYP/");
    driver.findElement(By.id("Login_Username")).clear();
    driver.findElement(By.id("Login_Username")).sendKeys("gillian");
    driver.findElement(By.id("Login_Password")).clear();
    driver.findElement(By.id("Login_Password")).sendKeys("test");
    driver.findElement(By.id("Login_0")).click();
    driver.findElement(By.linkText("Manage Employee Appraisal")).click();
    new Select(driver.findElement(By.id("SelectedEmployee_firstName"))).selectByVisibleText("Poppy");
    driver.findElement(By.id("SelectedEmployee_Submit")).click();
    driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[6]/td[8]/a/i")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
