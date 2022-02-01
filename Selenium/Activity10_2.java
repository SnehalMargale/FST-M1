package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Title of webpage is: " + driver.getTitle());

        actions.sendKeys("S").build().perform();
        System.out.println("Pressed Key is: "+driver.findElement(By.id("keyPressed")).getText());

        actions.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
        actions.keyUp(Keys.CONTROL);
        actions.keyDown(Keys.CONTROL).sendKeys("c").build().perform();
        actions.keyUp(Keys.CONTROL);

        System.out.println("Pressed Key is: "+driver.findElement(By.id("keyPressed")).getText());

        driver.close();
    }
}
