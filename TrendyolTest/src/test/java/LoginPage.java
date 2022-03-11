import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void signup(){
        driver.findElement(By.id("login-email")).sendKeys(Constants.email);
        driver.findElement(By.id("login-password-input")).sendKeys(Constants.sifre);
        driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Giriş Yap')]")).click();
    }
    public String logincontrol() throws InterruptedException {
        Thread.sleep(2000);
        String logincontrol = driver.findElement(By.xpath("//p[@class='user-name']")).getText();
        return logincontrol;
    }



}
