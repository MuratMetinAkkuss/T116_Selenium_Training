package Day03_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_WebElementsMethods {
    public static void main(String[] args) {
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> webElementList = driver.findElements(By.tagName("a"));
        int expectedNumberOfLink = 147;
        int actualNumberOfLink = webElementList.size();

        if (actualNumberOfLink == expectedNumberOfLink){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        //4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();

        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElement = driver.findElement(By.id("sale_image"));
        if (specialOfferElement.isDisplayed()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //6- Sayfayi kapatin
        driver.close();
    }
}
