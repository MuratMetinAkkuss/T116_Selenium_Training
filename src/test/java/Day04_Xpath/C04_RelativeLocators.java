package Day04_Xpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_RelativeLocators {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2 ) Berlin’i 3 farkli relative locator ile locate edin

        /*
            Berlin WebElement'inin HTML kodlari
            <img id="pid7_thumb" src="bots/sl-berlin-bot.png" class="ui-li-thumb">

            normalde locate edip kullanabilecegimiz bir web elementi icin gerek yoktur

            Relative locators, HTML ozelliklerini gordugumuz halde locate edememdigimiz bir
            veb elemt varsa kullanilir

            Bu soruda ornek olmasi amacitla berlin elamini locate edemedgimizi varsayiyoruz

            bu durumda berlin webelement'in etrafindaki web elementleri locate edip berlin'i onlar uzerinden tarif edecegiz
            

         */


        //3 ) Relative locator’larin dogru calistigini test edin


    }
}
