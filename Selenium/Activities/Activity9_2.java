package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");
        System.out.println("Title of webpage is: " + driver.getTitle());

        WebElement dropDownText = driver.findElement(By.id("multi-value"));
        Select dropDown = new Select(driver.findElement(By.id("multi-select")));

        if(dropDown.isMultiple())
        {
            dropDown.selectByVisibleText("Javascript");
            System.out.println("Selected Option is: "+ dropDownText.getText());
            dropDown.selectByValue("node");
            System.out.println("Selected Option is: "+ dropDownText.getText());

            for(int i=4;i<=6;i++) {
                dropDown.selectByIndex(i);
                System.out.println("Selected Option is: "+ dropDownText.getText());
            }

            dropDown.deselectByValue("node");
            System.out.println("DeSelected Option is: "+ dropDownText.getText());
            dropDown.deselectByIndex(7);
            System.out.println("DeSelected Option is: "+ dropDownText.getText());

            System.out.println("First Selected Option: "+ dropDown.getFirstSelectedOption().getText());

            List<WebElement> list =dropDown.getAllSelectedOptions();
            System.out.println("Selected Option List: ");
            for (WebElement item : list)
                System.out.println(item.getText());
            }

        dropDown.deselectAll();
        System.out.println("DeSelected Option is: "+ dropDownText.getText());

           driver.close();
    }
}
