package Activities.Activity9;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Snehal");
        myList.add("Vaishali");
        myList.add(0,"Balasaheb");
        myList.add(3,"Sayali");
        myList.add("Shreeraj");

        for(String x:myList)
            System.out.println(x);

       System.out.println("Third element of array list is: " + myList.get(3));

       if(myList.contains("Sayali"))
           System.out.println("List contains Sayali name.");

        System.out.println("Third element of array list is: " + myList.size());
        System.out.println("list is: " + myList);

        myList.remove("Shreeraj");
        System.out.println("Third element of array list is: " + myList.size());
        System.out.println("list is: " + myList);

    }
}
