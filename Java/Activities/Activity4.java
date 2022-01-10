package Activities.Activity4;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int array[] = {37, 98, 76, 67, 81, 22, 0, 55};
        sort(array);
        System.out.println("Sorted Array is: "+ Arrays.toString(array));
    }

    public static void sort(int[] array) {
        for(int i=1; i<array.length;i++)
        {
            int j=i-1;
            int num= array[i];

            while(j>=0 && num<array[j])
            {
                array[j+1]=array[j];
                j=j-1;
            }
            array[j+1]=num;
        }
    }
}



