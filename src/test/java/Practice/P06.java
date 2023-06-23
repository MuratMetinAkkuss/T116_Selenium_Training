package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P06 {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        ////1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");
        //        //2 ) Nurse  3 farkli relative locator ile locate edin
        WebElement police = driver.findElement(By.id("pol_thumb"));
        WebElement fireman = driver.findElement(By.id("frmn_thumb"));
        WebElement seller = driver.findElement(By.id("sll_thumb"));

        WebElement nurese1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(police));
        //        //3 ) Relative locator’larin dogru calistigini test edin
    }
}
