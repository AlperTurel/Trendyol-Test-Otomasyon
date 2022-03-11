import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    public void Anasayfa()
    {
        driver.get(Constants.url);
        driver.findElement(By.id("Combined-Shape")).click();
    }

    public void login()
    {
        driver.findElement(By.className("link-text")).click();
    }
}
