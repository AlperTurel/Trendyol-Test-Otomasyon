import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TrendyolTest
{
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void Start() throws InterruptedException {
    HomePage homePage=new HomePage(driver);
    homePage.Anasayfa();
    assertEquals(driver.getCurrentUrl(),Constants.url);

    homePage.login();

    LoginPage loginPage=new LoginPage(driver);
    loginPage.signup();

    Assert.assertEquals(loginPage.logincontrol(),"Alper Türel");

    Thread.sleep(2000);

    Product product=new Product(driver);
    product.SearchAndclick();
    product.SelectProductModel();
    Thread.sleep(2000);
    product.SelectProductPrice();
    product.SelectProduct();
    product.switchTo();
    product.AddBaskedProduct();
    }

}
