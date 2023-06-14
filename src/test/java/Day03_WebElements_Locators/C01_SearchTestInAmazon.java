package Day03_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_SearchTestInAmazon {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //arama cubuguna nutela yazdirip aratin
        /*
            bir web elementi kullanabilmek icin oncelikle o web elementi driver'in bulabilmesi icin
            locate etmeliyiz

            Amazon arama cubugu icin bu bilginin id = 'twotabsearchtextbox' oldugunu
            amazon sayfasinda arastirma yaparak bulduk

            Sonra bu locate bilgisini kullanarak web sayfasinda o elementi bulup
            bu class'da o web elementi kullanabilmek icin kaydedilecek
            methoda ihtiyacimiz var
         */
        WebElement wordForStorage = driver.findElement(By.id("twotabsearchtextbox"));
        /*
            bu satirda 3 islem yapiliyor:
            1- locate islemi:
            2- bu locate'i kullanarak istedigimiz arama kutusunu
               bize getirecek method --> driver.findElement
            3- Locate edip find element ile buldugumuz web elementi
               icinde bulundugumuz class'da kullanabilmemiz icin
               bir web element objesine atamak
         */

        wordForStorage.sendKeys("Nutella");
        wordForStorage.submit();
        //arama sonuclarinin nutella icerdigini test edin
        WebElement searhcedResultElement = driver.findElement(By.className("sg-col-inner"));
        //searhcedResultElement'ni bir WebElement olarak olusturduk
        //primitive data turu olmadigi icin direkt yazdiramayabiliriz.
        System.out.println(searhcedResultElement.getText());

        String expectedContent = "Nutella";
        String actualContent = searhcedResultElement.getText();

        if (actualContent.contains(expectedContent)){
            System.out.println("Nutella Search TEST PASSED");
        }else {
            System.out.println("Nutella Search TEST FAILED");
        }
    }
}
