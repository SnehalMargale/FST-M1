package Activities.Activity1;

    public class Car {
        int make;
        String color;
        String transmission;

        public void printCharacteristics() {
            System.out.println("Make of the Car is: " + make);
            System.out.println("Color of the Car is: " + color);
            System.out.println("Transmission of the Car is: " + transmission);
        }

        public void accelerate() {
            System.out.println("\n This is accelerate function");
        }

        public void brake() {
            System.out.println("\n This is brake function");
        }
    }
