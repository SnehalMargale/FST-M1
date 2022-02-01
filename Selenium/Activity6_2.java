package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/selenium/ajax");
        System.out.println("Title of webpage is: " + driver.getTitle());

        WebElement btnChangeContent = driver.findElement(By.xpath("//button[text()='Change Content']"));
        btnChangeContent.click();

        WebElement helloWord = driver.findElement(By.xpath("//h1[text()='HELLO!']"));
        wait.until(ExpectedConditions.visibilityOf(helloWord));
        System.out.println("Content: "+helloWord.getText());

        WebElement content = driver.findElement(By.xpath("//div/h3"));
        wait.until(ExpectedConditions.visibilityOf(content));
        System.out.println("Content: "+content.getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"I'm late!"));
        content = driver.findElement(By.xpath("//div/h3"));
        System.out.println("Content: "+content.getText());

        driver.close();
    }
}
