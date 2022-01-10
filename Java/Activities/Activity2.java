package Activities.Activity2;

public class Activity2 {

    public static void main(String[] args){
        int sum=0, expectedVal=30;
        int array[]= {10, 77, 10, 54, -11, 10};
        boolean res= result(array, sum, expectedVal);
        System.out.println("Sum of all 10's is: "+ res);
    }

    public static boolean result(int[] array, int sum, int expectedVal)
    {
        for (int x:array) {
            if(x==10)
                sum=sum+x;
        }
        if(sum==expectedVal)
            return true;
        else
            return false;
    }
}
