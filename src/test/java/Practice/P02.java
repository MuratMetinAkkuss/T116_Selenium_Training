package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
    public static void main(String[] args) {
        //     . .Exercise2...
        //2-Java class'imiza chnomedriver.exet i tanitalim
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");


        //1-Driver oluşturalim
        WebDriver driver = new ChromeDriver();

        //3-Driver'in tum ekranı kaplamasini saglayalim
        driver.manage().window().maximize();
        //4-Driverla sayfanın yuklenmesini 10.000 milisaniye
        // (10 saniye) boyunca beklesini söyleyelim.
        // Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        //5-"https://www.otto.de" adresine gidelim
        driver.get("https://www.otto.de");
        //6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        //7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
        String expectedWord ="OTTO";
        if (title.contains(expectedWord)){
            System.out.println("Title TEST PASSED ");
        }else {
            System.out.println("Title TEST FAILED");
        }
        if (url.contains(expectedWord)){
            System.out.println("URL TEST PASSED");
        }else {
            System.out.println("URL TEST FAILED");
        }
        //8-Ardindan "https://wisequarter.com/" adresine gidip
        driver.navigate().to("https://wisequarter.com/");
        //9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
        title = driver.getTitle();
        if (title.contains("Quarter")){
            System.out.println("Quarter TEST PASSED");
        }else {
            System.out.println("Quarter TEST FAILED");
        }
        //10-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        //11-Sayfayı yenileyelim
        driver.navigate().refresh();
        //12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
        driver.navigate().forward();
        driver.close();
        //13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();

    }
}
