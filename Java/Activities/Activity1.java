package Activities.Activity1;

public class Activity1 {

        public static void main(String[] args){
            Activities.Activity1.Car car= new Activities.Activity1.Car();
            car.color= "Black";
            car.make = 2014;
            car.transmission="Manual";

            car.printCharacteristics();
            car.accelerate();
            car.brake();
        }
    }


