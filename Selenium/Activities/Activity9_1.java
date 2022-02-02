package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");
        System.out.println("Title of webpage is: " + driver.getTitle());

        WebElement dropDownText = driver.findElement(By.id("single-value"));
        Select dropDown = new Select(driver.findElement(By.id("single-select")));
        dropDown.selectByVisibleText("Option 2");
        System.out.println("Selected Option is: "+ dropDownText.getText());
        dropDown.selectByIndex(3);
        System.out.println("Selected Option is: "+ dropDownText.getText());
        dropDown.selectByValue("4");
        System.out.println("Selected Option is: "+ dropDownText.getText());
        List<WebElement> list = dropDown.getOptions();

        System.out.println("Dropdown List: ");
        for (WebElement item : list)
            System.out.println(item.getText());

        driver.close();
    }
}
