package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println("Title of webpage is: " + driver.getTitle());

        driver.findElement(By.id("firstName")).sendKeys("Snehal");
        driver.findElement(By.id("lastName")).sendKeys("Margale");
        driver.findElement(By.id("email")).sendKeys("Test@mail.com");
        driver.findElement(By.id("number")).sendKeys("9922113344");
        driver.findElement(By.cssSelector(".ui.green.button")).click();
        System.out.println("Form submitted ");

        driver.close();
    }
}
