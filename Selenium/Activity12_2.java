package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/nested-iframes");
        System.out.println("Title of webpage is: " + driver.getTitle());

        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        System.out.println("Content of first frame is: "+ driver.findElement(By.xpath("/html/body/div[1]/div/div/div")).getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);
        driver.switchTo().frame(1);
        System.out.println("Content of first frame is: "+ driver.findElement(By.xpath("/html/body/div[1]/div/div/div")).getText());

        driver.close();
    }
}
