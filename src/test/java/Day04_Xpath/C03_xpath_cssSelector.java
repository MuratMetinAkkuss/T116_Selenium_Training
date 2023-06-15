package Day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_xpath_cssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //3- Browseri tam sayfa yapin
        //maximize
        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedResult = "Spend less";
        String actualResult = driver.getTitle();

        if (actualResult.contains(expectedResult)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test FAILED");
        }

        //6- Gift Cards sekmesine basin
        WebElement giftCardElement = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));
        giftCardElement.click();
        //7- Birthday butonuna basin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@aria-label='Birthday']")).click();
        //8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();
        //9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("//button[@id='gc-mini-picker-amount-1' and @value='25']")).click();
        //10-Urun ucretinin 25$ oldugunu test edin
        WebElement priceElement = driver.findElement(By.cssSelector("#gc-live-preview-amount"));
        String expectedPrice = "25$";
        String actualPrice = priceElement.getText();

        if (expectedPrice.equals(actualPrice)){
            System.out.println("Price TEST PASSED");
        }else {
            System.out.println("Price TEST FAILED");
        }
        //11-Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
