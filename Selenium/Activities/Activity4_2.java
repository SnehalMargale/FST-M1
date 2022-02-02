package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        System.out.println("Title of webpage is: " + driver.getTitle());

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Snehal");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Margale");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Test@mail.com");
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9922113344");
        driver.findElement(By.xpath("//input[@value='submit']")).click();
        System.out.println("Form submitted ");

        driver.close();
        driver.quit();
    }
}
