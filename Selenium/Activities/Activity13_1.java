package Activities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class Activity13_1 {
    public static void main(String[] args) throws IOException, CsvException {

        //Load CSV file
        CSVReader reader = new CSVReader(new FileReader("C:/Project/Selenium/Book1.csv"));

        List<String[]> list = reader.readAll();
        System.out.println("Size of CSV file: "+list.size());

        Iterator<String[]> itr = list.iterator();

        while(itr.hasNext()){
            String[] str = itr.next();
            int len= str.length;

            for(int i=0;i<str.length;i++){
                System.out.println(" "+str[i]);
            }
            System.out.println("");
        }
        reader.close();

    }
}
