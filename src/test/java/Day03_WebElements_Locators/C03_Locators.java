package Day03_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) {
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryElements = driver.findElements(By.className("panel-heading"));
        //4- Category bolumunde 3 element oldugunu test edin
        int expectedNumberOfCategory = 3;
        int actualNumberOfCategory = categoryElements.size();

        if (expectedNumberOfCategory == actualNumberOfCategory){
            System.out.println("Test PASSED ");
        }else {
            System.out.println("TEST FAILED");
        }
        //5- Category isimlerini yazdirin
        //System.out.println(categoryElements);
        /*
            biz bir listeyi direkt olarak yazdirabilir
            ancak bu liste web elementler icerdigi icin
            direkt yazdirmak istersek
            bize 3 tane referans degeri dondurecektir

            WebElementleri direkt olarak yazdiramayacagimiz icin
            bir for-each loop kullanarak
            herbir WebElement'i alip
            onun uzerindeki texti yazdirmaliyiz

         */
        for (WebElement eachElement : categoryElements
             ) {
            System.out.println(eachElement.getText());
        }


        //6- Sayfayi kapatin
        driver.close();
    }
}
