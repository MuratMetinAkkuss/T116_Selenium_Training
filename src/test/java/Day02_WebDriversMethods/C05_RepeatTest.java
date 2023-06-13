package Day02_WebDriversMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RepeatTest {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Youtube title test PASSED");
        }else {
            System.out.println("Youtube title test FAILED");
            System.out.println("Correct Title : " + actualTitle);
        }

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        //doğru URL'yi yazdırın.
        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Youtube URL Test PASSED");
        }else {
            System.out.println("Youtube URL test FAILED");
            System.out.println("Correct URL : " + actualUrl);
        }
        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //5. Youtube sayfasina geri donun
            driver.navigate().back();
        //6. Sayfayi yenileyin
        driver.navigate().refresh();
        //7. Amazon sayfasina donun
        driver.navigate().forward();
        //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        expectedTitle = "Amazon";
        actualTitle = driver.getTitle();

        if (actualUrl.contains(expectedTitle)){
            System.out.println("Amazon Title Test PASSED");
        }else  {
            System.out.println("Amazon title test FAILED");
            System.out.println(actualTitle+" is correct title");
        }
        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
        //doğru URL'yi yazdırın
        expectedUrl = "https://www.amazon.com/";
        actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("AMAZON URL TEST PASSED");
        }else {
            System.out.println("AMAZON URL TEST FAILED");
            System.out.println("actual url : " + actualUrl);
        }
        //11.Sayfayi kapatin
        driver.close();
    }
}
