package Day02_WebDriversMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ManageWondowSet {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition() + " Position");
        System.out.println(driver.manage().window().getSize()+ " Size");
        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(150,200));
        driver.manage().window().setSize(new Dimension(500,700));
        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
       // ???
        //8. Sayfayi kapatin
        driver.quit();
    }
}
