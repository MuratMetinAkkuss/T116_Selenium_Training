package Day03_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Locators {
    public static void main(String[] args) throws InterruptedException {
        /*
            locater :verdigimiz locate bilgisini kullanarak
                     driver'in locate etmesini saglayan hazir
                     method'lardir.
            selenium da 8 adet locater vardir
                   -ilk 6 tanesi WebElementi olusturan HTML
                    kodun icerigine baglidir.
                     1- By.id
                     2- By.name
                     3- By.className
                     4- By.linkText
                     5- By.partialLinkText
                     6- By.tagName
                   -son 2 tanesi ise her turlu web element icin kullanilabilir
                     7-By.xPath
                     8-By.cssSelector
         */
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        //arama kutusuna nutella yazip aratalim
        WebElement searchBoxElement = driver.findElement(By.name("field-keywords"));

        searchBoxElement.sendKeys("nutella");
        searchBoxElement.submit();

        // gosterilen urun resimlerinin 10'dan fazla oldugunu test edin
        //locater stratejisi olarak By.className secildiginde
        //Class attribute'nin degeri space iceriyorsa
        //locate islemi basariz olabilir
        //List<WebElement> productNameElementList = driver.findElements(By.className("a-size-base-plus a-color-base a-text-normal"));

        List<WebElement> productNameElementList = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        if (productNameElementList.size()>10){
            System.out.println("Listed Product Test PASSED");
        }else {
            System.out.println("Listed Product Test FAILED");
        }



        //5.urun isminin nutella icerdigini test edin
        String productOfFiveth = productNameElementList.get(4).getText();
        String expectedContent = "Nutella";
        System.out.println("5. product : " + productOfFiveth);

        if (productOfFiveth.contains(expectedContent)){
            System.out.println("5. product test PASSED ");
        }else {
            System.out.println("TEST FAILED FOR PRODUCT");
        }


        Thread.sleep(3000);
        driver.close();

    }
}
