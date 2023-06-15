package Day04_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XpathText {
    public static void main(String[] args) throws InterruptedException {
        //we use findElement with text content and xpath
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);
        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButtonElement = driver.findElement(By.xpath("//button[text()='Delete']"));
        if(deleteButtonElement.isDisplayed()){
            System.out.println("Delete button test PASSED");
        }else {
            System.out.println("Delete button Test FAILED");
        }
        Thread.sleep(2000);
        //4- Delete tusuna basin
        deleteButtonElement.click();
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if (addRemoveElement.isDisplayed()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        Thread.sleep(2000);
        driver.close();

    }
}
