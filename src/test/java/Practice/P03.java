package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    public static void main(String[] args) throws InterruptedException {
        //Exercise3...
        System.setProperty("Webdriver.chrome.drive","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        //Click on  Calculater under Micro Apps
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
        //Type any number in the first input
         WebElement number1 = driver.findElement(By.xpath("//input[@id='number1']"));
        number1.sendKeys("23");
        Thread.sleep(1000);
         //Type any number in the second input
        WebElement number2 = driver.findElement(By.xpath("//input[@id='number2']"));
        number2.sendKeys("44");
        //Click on Calculate
        driver.findElement(By.xpath("//input[@id='calculate']")).click();
        //Get the result
        WebElement result = driver.findElement(By.xpath("//span[@id='answer']"));
        //Print the result
        System.out.println(result.getText());
    }
}
