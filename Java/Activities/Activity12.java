package Activities.Activity12;

interface Addable{
    public int add(int num1, int num2);
}

public class Activity12 {

    public static void main(String[] args){

        Addable addable1 = (a, b) -> (a + b);
        System.out.println("Output of add (lambda) function without body: "+ addable1.add(10,20));

        Addable addable2 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println("Output of add (lambda) function with body: "+ addable2.add(10,20));
    }

}
