package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println("Title of webpage is: " + driver.getTitle());

        System.out.println("Third header: " +driver.findElement(By.xpath("//h3[@id='third-header']")).getText());
        System.out.println("Fifth header color is: " +driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color"));
        System.out.println("Violet button class is: " +driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class"));
        System.out.println("gray button text is: " +driver.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText());

        System.out.println("Done");

        driver.close();
    }
}
