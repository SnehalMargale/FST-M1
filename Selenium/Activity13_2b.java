package Activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity13_2b {

    public List<List<String>> readExcel(String filePath) throws IOException {
        List<List<String>> data = new ArrayList<List<String>>();
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> rowIterator = sheet.iterator();
        while(rowIterator.hasNext()) {
            //Temp variable
            List<String> rowData = new ArrayList<String>();
            Row row = rowIterator.next();

            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if(row.getLastCellNum() == 5) {
                    //Store row data
                    rowData.add(cell.getStringCellValue());
                }
            }
            //Store row data in List
            data.add(rowData);
        }
        file.close();
        workbook.close();

        return data;
    }

    public static void main(String[] args) throws IOException {
        WebDriver driver = new FirefoxDriver();
        String filePath = "C:/Project/Selenium/Book2.xlsx";
        Activity13_2b obj = new Activity13_2b();

        List<List<String>> data= obj.readExcel(filePath);
        List<String> row;

        driver.get("https://www.training-support.net/selenium/simple-form");
        System.out.println("Page title is: " + driver.getTitle());

        row = data.get(3);

        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));

        firstName.sendKeys(row.get(1));
        lastName.sendKeys(row.get(2));
        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys(row.get(3));
        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys(row.get(4));
        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

        Alert message = driver.switchTo().alert();
        System.out.println("Alert message: " + message.getText());
        message.accept();

        driver.close();
    }

}
