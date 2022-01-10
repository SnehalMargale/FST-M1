package Activities.Activity8;

public class Activity8 {
    public static void main(String[] args){
        try {
            Activity8.exceptionTest("Not null String");
            Activity8.exceptionTest(null);
        }
        catch(CustomException exception){
            System.out.println("inside catch block: " +exception.getMessage());
        }
    }

    public static void exceptionTest(String msg) throws CustomException {
        if (msg==null)
            throw new CustomException("String is null");
        else
            System.out.println("String is: "+ msg);
    }
}

class CustomException extends Exception{
    private String message;

    public CustomException(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
