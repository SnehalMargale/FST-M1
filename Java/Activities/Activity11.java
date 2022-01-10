package Activities.Activity11;

import java.util.HashMap;

public class Activity11 {
    public static void main(String args[]){
        HashMap<Integer,String> colours = new HashMap<>();

        colours.put(1,"Red");
        colours.put(2,"White");
        colours.put(3,"Blue");
        colours.put(4,"Green");
        colours.put(5,"Black");

        System.out.println(colours);
        colours.remove(3);
        System.out.println(colours);
        System.out.println("Green color is present in map: "+ colours.containsValue("Green"));
        System.out.println("Size of map is: "+ colours.size());
    }
}
