package Activities.Activity10;

import java.util.HashSet;

public class Activity10 {

    public static void main(String[] args){
        HashSet hs = new HashSet();

        hs.add("Snehal");
        hs.add("Sayali");
        hs.add("Vaishali");
        hs.add("Balasaheb");
        hs.add("Shreeraj");
        hs.add("Aryan");

        System.out.println("Size of Hashset is: "+ hs.size());
        System.out.println("Hashset is: "+ hs);
        hs.remove("Aryan");
        System.out.println("Size of Hashset is: "+ hs.size());
        System.out.println("Hashset is: "+ hs);
        if(hs.remove("Prasanna"))
         System.out.println("Prasanna is removed from set");
        else
            System.out.println("Prasanna is not present in List");
        System.out.println("Size of Hashset is: "+ hs.size());
        System.out.println("Hashset is: "+ hs);
        System.out.println("Snehal is present in hash set: " + hs.contains("Snehal"));
        System.out.println("Aryan is present in hash set: " + hs.contains("Aryan"));
        System.out.println("Hashset is: "+ hs);


    }
}
