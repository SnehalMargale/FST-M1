package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Title of webpage is: " + driver.getTitle());

        System.out.println("Checkbox is selected: "+ driver.findElement(By.name("toggled")).isSelected());

        driver.findElement(By.name("toggled")).click();
        System.out.println("Checkbox is selected: "+ driver.findElement(By.name("toggled")).isSelected());

        driver.close();
    }
}
