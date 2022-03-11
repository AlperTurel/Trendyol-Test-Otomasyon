import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class Product
{
    WebDriver driver;
    public Product(WebDriver driver){this.driver=driver;}
    public void SearchAndclick() throws InterruptedException {
        driver.findElement(By.className("search-box")).sendKeys(Constants.word);
        Thread.sleep(2000);
        driver.findElement(By.className("search-icon")).click();
    }
    public void SelectProductModel() {
        driver.findElement(xpath("//div[normalize-space()='Monster']")).click();
    }
    public void SelectProductPrice(){
        driver.findElement(xpath("//input[@placeholder='En Az']")).sendKeys(Constants.minvalue);
        driver.findElement(xpath("//input[@placeholder='En Çok']")).sendKeys(Constants.maxvalue);
        driver.findElement(xpath("//button[@class='fltr-srch-prc-rng-srch']")).click();
    }
    public void SelectProduct() {
        driver.findElement(xpath("//div[@class='image-overlay-body']")).click();
    }

    //Child sayfalardaki elementleri bulmak için gerekli metod
    public void switchTo() {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }
        }
    }

    public void AddBaskedProduct()
    {
        driver.findElement(By.xpath("//div[@class='product-button-container']//button[@class='add-to-basket']")).click();
    }
}
