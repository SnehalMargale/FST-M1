package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Title of webpage is: " + driver.getTitle());

        System.out.println("Checkbox is displayed: "+ driver.findElement(By.name("toggled")).isDisplayed());
        if(driver.findElement(By.name("toggled")).isDisplayed())
            System.out.println("Checkbox input is displayed");
        else
            System.out.println("Checkbox input is not displayed");

        driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println("Checkbox is displayed: "+ driver.findElement(By.name("toggled")).isDisplayed());
        if(driver.findElement(By.name("toggled")).isDisplayed())
            System.out.println("Checkbox input is displayed after clicking 'Remove checkbox' button");
        else
            System.out.println("Checkbox input is not displayed after clicking 'Remove checkbox' button");

        System.out.println("Done");

        driver.close();
    }
}
