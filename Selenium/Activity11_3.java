package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("Title of webpage is: " + driver.getTitle());

        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Yes, you are!");
        Thread.sleep(1000);
        alert.accept();

        driver.close();
    }
}
