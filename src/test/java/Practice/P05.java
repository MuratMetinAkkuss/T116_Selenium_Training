package Practice;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //    5-Navigate to http://www.babayigit.net/murat/testpage.html
        driver.get("http://www.babayigit.net/murat/testpage.html");
        //    6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
        //        alanlarına gerekli bilgileri yazsın
        driver.findElement(By.xpath("//input[@id='ad']")).sendKeys("Metin");
        driver.findElement(By.xpath("//input[@id='soyad']")).sendKeys("akkus");
        driver.findElement(By.xpath("//input[@id='yas']")).sendKeys("24");
        driver.findElement(By.xpath("//input[@id='meslek']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='dogum_yeri']")).sendKeys("Turkey");
        driver.findElement(By.xpath("//input[@id='mezun_okul']")).sendKeys("DEU");
        driver.findElement(By.xpath("//input[@id='cocuk_sayisi']")).sendKeys("0");

        //    7-Submit tuşuna bassın.
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        //    8- All information was entered correctly.. yazısının göründüğünü test etsin
        if (driver.findElement(By.xpath("//p[text()='All information was entered correctly..']")).isDisplayed()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test failed");
        }
        //    9- Clear butonu ile tüm butonları temizlesin
        driver.findElement(By.xpath("//input[@value='Clear']")).click();
        //    10- Manuel olarak temizlendiğini görecek kadar beklesin
        Thread.sleep(3000);
        //    11- Sayfayı kapatsın
        driver.close();
        //    10-8. maddededeki Test sonucunu yazdırsın
    }

}
