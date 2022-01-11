package Activities.Activity13;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Random indexGen = new Random();

        System.out.println("Enter numbers to add to the array: ");
        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }
        System.out.println("List: " + list);
        Integer nums[]= list.toArray(new Integer[0]);

        System.out.println("Converted Array: ");
        for(int x=0;x< nums.length;x++)
            System.out.println(nums[x]);

        System.out.println("nums.length: " + nums.length);

        int index = indexGen.nextInt(nums.length);
        System.out.println("Generated index: " + index);
        System.out.println("Value at index: "+ nums[index]);
    }
}
