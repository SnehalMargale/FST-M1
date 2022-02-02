package Activities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity13_2a {

    public void writeExcel(String filePath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        List<String[]> data = new ArrayList<String[]>();
        String[] heading = {"ID", "First Name", "Last Name", "Email", "Ph.No."};
        String[] row1 = {"1", "Satvik", "Shah", "satshah@example.com", "4537829158"};
        String[] row2 = {"2", "Avinash", "Kati", "avinashK@example.com", "4892184058"};
        String[] row3 = {"3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830"};

        data.add(heading);
        data.add(row1);
        data.add(row2);
        data.add(row3);

        int rownum = 0;
        for (String[] rowData : data) {
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            for (String cellData : rowData) {
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue(cellData);
            }
        }

        FileOutputStream out = new FileOutputStream(new File(filePath));
        workbook.write(out);
        out.close();
        workbook.close();
    }

    public void readExcel(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType()) {
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " \t ");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + " \t ");
                        break;
                    default:
                        System.out.println("Invalid value");
                        break;
                }
            }
            System.out.println("");
        }
        file.close();
        workbook.close();

    }

    public static void main(String[] args) throws IOException {
        String filePath = "C:/Project/Selenium/Book2.xlsx";
        Activity13_2a obj = new Activity13_2a();
        obj.writeExcel(filePath);
        obj.readExcel(filePath);
    }

}
