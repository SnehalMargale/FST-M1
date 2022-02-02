package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println("Title of webpage is: " + driver.getTitle());

        System.out.println("By id: " +driver.findElement(By.id("about-link")).getText());
        System.out.println("By class name: " +driver.findElement(By.className("green")).getText());
        System.out.println("By link text: " +driver.findElement(By.linkText("About Us")).getText());
        System.out.println("By css selector: " +driver.findElement(By.cssSelector(".green")).getText());

        driver.close();


    }
}
