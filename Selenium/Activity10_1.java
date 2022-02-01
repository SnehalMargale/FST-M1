package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Title of webpage is: " + driver.getTitle());

        WebElement cube = driver.findElement(By.id("wrapD3Cube"));

        actions.click(cube);
        WebElement cubeVal = driver.findElement(By.className("active"));
        System.out.println("Cube Value: "+cubeVal.getText());

        actions.doubleClick(cube).perform();
        cubeVal = driver.findElement(By.className("active"));
        System.out.println("Cube Value: "+cubeVal.getText());

        actions.contextClick(cube).perform();
        cubeVal = driver.findElement(By.className("active"));
        System.out.println("Cube Value: "+cubeVal.getText());

        
        driver.close();
    }
}
