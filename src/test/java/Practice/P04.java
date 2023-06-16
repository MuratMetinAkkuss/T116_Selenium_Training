package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class P04 {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.drive","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //  Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        //  Under the ORIGINAL CONTENTS
        //  click on Alerts
        driver.findElement(By.xpath("//a[@id='alerts']")).click();
        //  print the URL
        String URL = driver.getCurrentUrl();
        System.out.println("URL1 = " +URL);
        //  navigate back
        driver.navigate().back();
        //  print the URL
        String URL2 = driver.getCurrentUrl();
        System.out.println("URL2 = " + URL2);
        //  Click on Basic Ajax
        driver.findElement(By.xpath("//*[text()='Basic Ajax']")).click();
        //  print the URL
        String URL3 = driver.getCurrentUrl();
        System.out.println("URL3 = " + URL3);
        //  enter value 20 and ENTER
        driver.findElement(By.id("lteq30")).sendKeys("20"+ Keys.ENTER);
        /*
        WebElement valueBox = driver.findElement(By.xpath("//input[@id='lteq30']"));
        valueBox.sendKeys("20");
        valueBox.submit();

         */
        //  and then verify Submitted Values is displayed open page
        String submitCheck = driver.findElement(By.xpath("//p[text()='Submitted Values']")).getText();
        if(submitCheck.equals("Submitted Values")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test FAILED");
        }
        //  close driver
        driver.close();

    }
}
