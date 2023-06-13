package Day02_WebDriversMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Training {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        //(title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi
        //yazdirin.
        driver.get("https://www.facebook.com");
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
            System.out.println(driver.getTitle() + "actual title");
        }
        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        //“actual” URL’i yazdirin.
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED" );
            System.out.println(actualUrl + " actual URL");
        }
        //4.https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");
        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        expectedTitle = "Walmart.com";
        actualTitle = driver.getTitle();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test Walmart PASSED");
        }else {
            System.out.println("Test Walmart FAILED");
        }
        //6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //7. Sayfayi yenileyin
        driver.navigate().refresh();
        //8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        //9.Browser’i kapatin
        driver.quit();
    }
}
