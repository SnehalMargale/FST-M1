package Activities.Activity14;



import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Activity14 {

    public static void main(String[] args) {
        try {
            String filepath= "C:\\Project\\FST20 M1\\src\\main\\java\\Activities\\Activity14\\file.txt";
            File file = new File(filepath);
            boolean Status = file.createNewFile();
            if(Status)
                System.out.println("File Created Successfully");
            else
                System.out.println("File is Not Created");

           File fileUtil = FileUtils.getFile(filepath);
           System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));

            File directory = new File("resources");
            FileUtils.copyFileToDirectory(file, directory);

           File newFile = FileUtils.getFile(directory, "newfile.txt");
           String newFileData = FileUtils.readFileToString(newFile, "UTF8");
           System.out.println("Data in new file: " + newFileData);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }

}
