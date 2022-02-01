package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity12_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.training-support.net/selenium/iframes");
        System.out.println("Title of webpage is: " + driver.getTitle());

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/selenium/frame1']")));
        System.out.println("Content of first frame is: "+ driver.findElement(By.xpath("/html/body/div[1]/div/div/div")).getText());
        WebElement button1= driver.findElement(By.xpath("//button[@id='actionButton']"));
        System.out.println("Content of first button is: "+button1.getText());
        System.out.println("Color of first button is: "+ button1.getCssValue("background-color"));
        button1.click();
        System.out.println("Content of first button is: "+button1.getText());
        System.out.println("Color of first button is: "+ button1.getCssValue("background-color"));

        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/selenium/frame2']")));
        System.out.println("Content of second frame is: "+ driver.findElement(By.xpath("/html/body/div[1]/div/div/div")).getText());
        button1= driver.findElement(By.xpath("//button[@class='ui inverted green button']"));
        System.out.println("Content of second button is: "+button1.getText());
        System.out.println("Color of second button is: "+ button1.getCssValue("background-color"));
        js.executeScript("arguments[0].scrollIntoView();", button1);
        button1.click();
      //  button1= driver.findElement(By.xpath("//button[@class='ui inverted button purple']"));
        System.out.println("Content of second button is: "+button1.getText());
        System.out.println("Color of second button is: "+ button1.getCssValue("background-color"));

        driver.close();
    }
}
