package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/tables");
        System.out.println("Title of webpage is: " + driver.getTitle());

        List<WebElement> list = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody//tr"));
        System.out.println("No. of rows: " + list.size());

        list = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody//tr[1]/td"));
        System.out.println("No. of columns: " + list.size());

        list = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody//tr[3]/td"));
        System.out.println("Third row content: ");
        for(WebElement item:list)
            System.out.println(item.getText());

        System.out.println("Third row content: "+
                driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody//tr[3]")).getText());

        System.out.println("Cell text at second row second column: "+
                driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody//tr[2]/td[2]")).getText());


    }
}
