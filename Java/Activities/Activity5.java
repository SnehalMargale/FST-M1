package Activities.Activity5;

public class Activity5 {
    public static void main(String[] args){
        MyBook newNovel = new MyBook();
        newNovel.setTitle("My Book");
        System.out.println("The title is: " + newNovel.getTitle());
    }
}

 abstract class Book {
    String title;
    public abstract void setTitle(String title) ;
    public String getTitle() {
        return title;
    }
}

 class MyBook extends Book {
     public void setTitle(String s) {
         title = s;
     }
 }



