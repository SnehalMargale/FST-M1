package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Title of webpage is: " + driver.getTitle());

        System.out.println("Input text box is enabled: "+ driver.findElement(By.id("input-text")).isEnabled());

        driver.findElement(By.id("toggleInput")).click();
        System.out.println("Input text box is enabled: "+ driver.findElement(By.id("input-text")).isEnabled());

        driver.close();
    }
}
