package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println("Title of webpage is: " + driver.getTitle());

        WebElement ballImg = driver.findElement(By.id("draggable"));
        WebElement dropZone1 = driver.findElement(By.id("droppable"));
        WebElement dropZone2 = driver.findElement(By.id("dropzone2"));

        actions.dragAndDrop(ballImg,dropZone1).build().perform();
        System.out.println("Moved to dropzone1");
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropZone1,"background-color"));

        actions.dragAndDrop(ballImg,dropZone2).build().perform();
        System.out.println("Moved to dropzone2");
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropZone2,"background-color"));

        driver.close();
    }
}
