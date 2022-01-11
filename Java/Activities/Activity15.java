package Activities.Activity15;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class Activity15 {
    private static String fileName = "C:\\Project\\FST20 M1\\src\\main\\java\\Activities\\Activity15\\TestSheet.xlsx";

    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet worksheet = workbook.createSheet("Data Types in Java");
        Object data[][]= {
                {"DataType","Type","Size"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8}
        };
        System.out.println("data ready to copy");

        int rowNum = 0;

        for (Object[] datatype : data) {
            Row row = worksheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            workbook.write(fileOutputStream);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("data Copied to excel");
    }
}